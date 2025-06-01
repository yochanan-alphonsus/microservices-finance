import { Request, Response, Router } from "express";
import budgetService from "../services/budgetService";
import { TBudget } from "../utils/types";

const router = Router();

router.post("/api/budgets", async function (req: Request, res: Response) {
  const requestedData = req.body as TBudget;
  await budgetService.createBudget(requestedData);

  res.status(201).send("Budget created successfully");
});

router.get("/api/budgets/:id", async function (req: Request, res: Response) {
  const budgetFound = await budgetService.readOneBudget(
    req.params.id as string
  );

  res.status(200).json(budgetFound);
});

router.get("/api/budgets", async function (req: Request, res: Response) {
  const budgets = await budgetService.readAllBudgets();

  res.status(200).json(budgets);
});

router.patch("/api/budgets/:id", async function (req: Request, res: Response) {
  await budgetService.updateBudget(
    req.params.id as string,
    req.body as TBudget
  );

  res.status(200).send("Budget updated successfully");
});

router.delete("/api/budgets/:id", async function (req: Request, res: Response) {
  await budgetService.deleteBudget(req.params.id);

  res.status(200).send("Budget deleted successfully");
});

const budgetController = router;

export default budgetController;
