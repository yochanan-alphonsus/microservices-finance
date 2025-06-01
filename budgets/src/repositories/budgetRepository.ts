import { PrismaClient } from "../generated/prisma";
import { TBudget } from "../utils/types";

async function save(budget: TBudget) {
  const prisma = new PrismaClient();

  await prisma.$connect();

  await prisma.budget.create({
    data: {
      month: budget.month,
      year: budget.year,
      limitAmount: budget.limitAmount,
      spentAmount: budget.spentAmount,
      userId: budget.userId,
      categoryId: budget.categoryId,
    },
  });

  await prisma.$disconnect();

  return;
}

async function findById(id: string) {
  const prisma = new PrismaClient();

  await prisma.$connect();

  const budgetFound = await prisma.budget.findUnique({
    where: {
      id: id,
    },
  });

  await prisma.$disconnect();

  return budgetFound;
}

async function findAll() {
  const prisma = new PrismaClient();

  await prisma.$connect();

  const budgets = await prisma.budget.findMany();

  await prisma.$disconnect();

  return budgets;
}

async function updateById(id: string, budget: TBudget) {
  const prisma = new PrismaClient();

  await prisma.$connect();

  await prisma.budget.update({
    where: {
      id: id,
    },
    data: {
      month: budget.month,
      year: budget.year,
      limitAmount: budget.limitAmount,
      spentAmount: budget.spentAmount,
      userId: budget.userId,
      categoryId: budget.categoryId,
    },
  });

  await prisma.$disconnect();

  return;
}

async function deleteById(id: string) {
  const prisma = new PrismaClient();

  await prisma.$connect();

  await prisma.budget.delete({
    where: {
      id: id,
    },
  });

  await prisma.$disconnect();

  return;
}

const budgetRepository = {
  save,
  findById,
  findAll,
  updateById,
  deleteById,
};

export default budgetRepository;
