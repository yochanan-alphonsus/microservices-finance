import { z } from "zod";

const Category = z.object({
  id: z
    .string({
      required_error: "Id must be unique",
      invalid_type_error: "Id must be of type String (UUID like)",
    })
    .uuid(),
  name: z.string({
    required_error: "Name must be unique",
    invalid_type_error: "Name must be of type String",
  }),
  type: z.enum(["INCOME", "EXPENSE"], {
    required_error: "Type isn't either INCOME nor EXPENSE",
    invalid_type_error: "Type must be an enum, either INCOME or EXPENSE",
  }),
  userId: z
    .string({
      required_error: "User Id must be unique",
      invalid_type_error: "User Id must be of type String (UUID like)",
    })
    .uuid(),
  createdAt: z.date(),
  updatedAt: z.date(),
});

export type TCategory = z.infer<typeof Category>;
