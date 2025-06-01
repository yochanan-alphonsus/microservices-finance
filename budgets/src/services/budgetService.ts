import budgetRepository from "../repositories/budgetRepository";
import { TBudget } from "../utils/types";

async function createBudget(budget: TBudget) {
  try {
    const budgets = await budgetRepository.findAll();

    const budgetFound0 = budgets.filter(
      (bg) => bg.categoryId == budget.categoryId
    );
    const budgetFound1 = budgets.filter((bg) => bg.month == budget.month);

    if (
      budgetFound0.map((b) => b.userId).includes(budget.userId) &&
      budgetFound1.map((b) => b.userId).includes(budget.userId)
    ) {
      throw new Error(
        "A user cannot define multiple budgets for the same category in the same month"
      );
    }
    if (budget.spentAmount > budget.limitAmount) {
      if (budget.limitAmount < 0) {
        throw new Error("Budget must not allow negative limit amount");
      } else {
        throw new Error(
          "Budget is considered overrun, spent amount cannot be greater than limit amount"
        );
      }
    } else {
      await budgetRepository.save(budget);
    }

    return;
  } catch (error) {
    throw new Error("Error: \n" + error);
  }
}

async function readOneBudget(id: string) {
  try {
    const budgetFound = await budgetRepository.findById(id);
    return budgetFound;
  } catch (error) {
    throw new Error("Error: \n" + error);
  }
}

async function readAllBudgets() {
  try {
    const budgets = await budgetRepository.findAll();
    return budgets;
  } catch (error) {
    throw new Error("Error: \n" + error);
  }
}

async function updateBudget(id: string, budget: TBudget) {
  try {
    if (budget.spentAmount > budget.limitAmount) {
      if (budget.limitAmount < 0) {
        throw new Error("Budget must not allow negative limit amount");
      } else {
        throw new Error(
          "Budget is considered overrun, spent amount cannot be greater than limit amount"
        );
      }
    } else {
      await budgetRepository.updateById(id, budget);
    }

    return;
  } catch (error) {
    throw new Error("Error: \n" + error);
  }
}

async function deleteBudget(id: string) {
  try {
    await budgetRepository.deleteById(id);
    return;
  } catch (error) {
    throw new Error("Error: \n" + error);
  }
}

const budgetService = {
  createBudget,
  readOneBudget,
  readAllBudgets,
  updateBudget,
  deleteBudget,
};

export default budgetService;
