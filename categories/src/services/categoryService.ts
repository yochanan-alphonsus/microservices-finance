import categoryRepository from "../repositories/categoryRepository";
import { TCategory } from "../utils/types";

async function createCategory(category: TCategory) {
  try {
    await categoryRepository.save(category);
    return;
  } catch (error) {
    throw new Error("Error: \n" + error);
  }
}

async function readOneCategory(id: string) {
  try {
    const categoryFound = await categoryRepository.findById(id);
    return categoryFound;
  } catch (error) {
    throw new Error("Error: \n" + error);
  }
}

async function readAllCategories() {
  try {
    const categories = await categoryRepository.findAll();
    return categories;
  } catch (error) {
    throw new Error("Error: \n" + error);
  }
}

async function updateCategory(id: string, category: TCategory) {
  try {
    await categoryRepository.updateById(id, category);
    return;
  } catch (error) {
    throw new Error("Error: \n" + error);
  }
}

async function deleteCategory(id: string) {
  try {
    await categoryRepository.deleteById(id);
    return;
  } catch (error) {
    throw new Error("Error: \n" + error);
  }
}

const categoryService = {
  createCategory,
  readOneCategory,
  readAllCategories,
  updateCategory,
  deleteCategory,
};

export default categoryService;
