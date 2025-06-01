import { PrismaClient } from "../generated/prisma";
import { TCategory } from "../utils/types";

async function save(category: TCategory) {
  const prisma = new PrismaClient();

  await prisma.$connect();
  await prisma.category.create({
    data: {
      name: category.name.toUpperCase(),
      type: category.type,
      userId: category.userId,
    },
  });

  await prisma.$disconnect();

  return;
}

async function findById(id: string) {
  const prisma = new PrismaClient();

  await prisma.$connect();

  const userFound = await prisma.category.findUnique({
    where: {
      id: id,
    },
  });

  await prisma.$disconnect();

  return userFound;
}

async function findAll() {
  const prisma = new PrismaClient();

  await prisma.$connect();

  const categories = await prisma.category.findMany();

  await prisma.$disconnect();

  return categories;
}

async function updateById(id: string, category: TCategory) {
  const prisma = new PrismaClient();

  await prisma.$connect();
  await prisma.category.update({
    where: {
      id: id,
    },
    data: {
      name: category.name.toUpperCase(),
      type: category.type,
      userId: category.userId,
    },
  });

  await prisma.$disconnect();

  return;
}

async function deleteById(id: string) {
  const prisma = new PrismaClient();

  await prisma.$connect();

  await prisma.category.delete({
    where: {
      id: id,
    },
  });

  await prisma.$disconnect();

  return;
}

const categoryRepository = {
  save,
  findById,
  findAll,
  updateById,
  deleteById,
};

export default categoryRepository;
