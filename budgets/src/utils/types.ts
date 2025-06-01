import { z } from "zod";

const Budget = z.object({
  id: z
    .string({
      required_error: "Id must be unique",
      invalid_type_error: "Id must be of type String (UUID like)",
    })
    .uuid(),
  month: z.number({
    required_error: "Month must be a number",
    invalid_type_error: "Month must be of type Int",
  }),
  year: z.number({
    required_error: "Year must be a number",
    invalid_type_error: "Year must be of type Int",
  }),
  limitAmount: z.number({
    required_error: "Limit Amount must not allow negative numbers",
    invalid_type_error: "Limit Amount must be of type Int",
  }),
  spentAmount: z.number({
    required_error: "Spent Amount shouldn't overrun Limit Amount",
    invalid_type_error: "Spent Amount must be of type Int",
  }),
  userId: z
    .string({
      required_error: "User Id must be unique",
      invalid_type_error: "User Id must be of type String (UUID like)",
    })
    .uuid(),
  categoryId: z
    .string({
      required_error: "Category Id must be unique",
      invalid_type_error: "Category Id must be of type String (UUID like)",
    })
    .uuid(),
  createdAt: z.date(),
  updatedAt: z.date(),
});

export type TBudget = z.infer<typeof Budget>;
