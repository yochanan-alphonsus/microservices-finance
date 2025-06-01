import express from "express";
import cors from "cors";
import dotenv from "dotenv";
import helmet from "helmet";
import morgan from "morgan";
import path from "node:path";
import categoryController from "./controllers/categoryController";

const server = express();

server.use(express.json());
server.use(express.urlencoded({ extended: true }));
server.use(express.static(path.resolve(process.cwd(), "./public")));
server.use(cors());
server.use(helmet());
server.use(morgan("dev"));
dotenv.config({ path: path.resolve(process.cwd(), ".env") });

server.use(categoryController);

server.listen(Number(process.env.SERVER_PORT), function () {
  console.info(`Category Service started on ${process.env.SERVER_URL}`);
});
