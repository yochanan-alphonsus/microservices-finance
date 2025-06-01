import { Request, Response, Router } from "express";
import categoryService from "../services/categoryService";
import { TCategory } from "../utils/types";

const router = Router();

router.post("/api/categories", async function (req: Request, res: Response) {
  const requestedData = req.body as TCategory;
  await categoryService.createCategory(requestedData);

  res.status(201).send("Category created successfully");
});

router.get("/api/categories/:id", async function (req: Request, res: Response) {
  const categoryFound = await categoryService.readOneCategory(
    req.params.id as string
  );

  res.status(200).json(categoryFound);
});

router.get("/api/categories", async function (req: Request, res: Response) {
  const categories = await categoryService.readAllCategories();

  res.status(200).json(categories);
});

router.patch(
  "/api/categories/:id",
  async function (req: Request, res: Response) {
    await categoryService.updateCategory(
      req.params.id as string,
      req.body as TCategory
    );

    res.status(200).send("Category updated successfully");
  }
);

router.delete(
  "/api/categories/:id",
  async function (req: Request, res: Response) {
    await categoryService.deleteCategory(req.params.id);

    res.status(200).send("Category deleted successfully");
  }
);

const categoryController = router;

export default categoryController;
