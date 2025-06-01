# 💸 Microservices API for Personal Finance

A scalable and modular Spring Boot microservices system for users, transaction tracking, budgeting, and categorization.

---

## 🧩 Microservices Overview

Each microservice is independently deployable and discoverable via Eureka:

| Service       | Base URL            | Description                            |
| ------------- | ------------------- | -------------------------------------- |
| Auth Service  | `/api/auth`         | User registration, and login           |
| Users Service | `/api/users`        | User profile management                |
| Transactions  | `/api/transactions` | Financial transaction tracking         |
| Budgets       | `/api/budgets`      | Budget creation and management         |
| Categories    | `/api/categories`   | Expense and income category management |

![Service Map](./service-map.png)

---

## 🔐 Auth Service - `/api/auth`

Handles authentication (I didn't get too far with the JWT thing).

| Method | Endpoint | Description    |
| ------ | -------- | -------------- |
| POST   | `/`      | Sign Up a user |
| POST   | `/`      | Sign In a user |

---

## 👤 Users Service - `/api/users`

| Method | Endpoint | Description         |
| ------ | -------- | ------------------- |
| GET    | `/{id}`  | Get user by ID      |
| PATCH  | `/{id}`  | Update user details |
| DELETE | `/{id}`  | Delete user         |
| GET    | `/`      | List users          |

---

## 💳 Transactions Service - `/api/transactions`

| Method | Endpoint           | Description                                         |
| ------ | ------------------ | --------------------------------------------------- |
| GET    | `/`                | List user transactions                              |
| GET    | `/{id}`            | Get a specific transaction                          |
| GET    | `?description=foo` | Get a specific transaction by description parameter |
| POST   | `/`                | Create a new transaction                            |
| PATCH  | `/{id}`            | Update a transaction                                |
| DELETE | `/{id}`            | Delete a transaction                                |

---

## 📊 Budgets Service - `/api/budgets`

| Method | Endpoint | Description           |
| ------ | -------- | --------------------- |
| GET    | `/`      | List user budgets     |
| GET    | `/{id}`  | Get a specific budget |
| POST   | `/`      | Create a new budget   |
| PATCH  | `/{id}`  | Update a budget       |
| DELETE | `/{id}`  | Delete a budget       |

---

## 🧾 Categories Service - `/api/categories`

| Method | Endpoint | Description             |
| ------ | -------- | ----------------------- |
| GET    | `/`      | List all categories     |
| GET    | `/{id}`  | Get a specific category |
| POST   | `/`      | Create a new category   |
| PATCH  | `/{id}`  | Update a category       |
| DELETE | `/{id}`  | Delete a category       |

---

## 🧰 Tech Stack

- **Spring Boot & Spring Cloud Gateway**
- **Spring Security**
- **PostgreSQL**
- **Eureka Server + Eureka Client**
- **Expressjs + Prisma**

---

## 📦 Run Locally

```bash
git clone https://github.com/yochanan-alphonsus/microservices-finance.git
cd microservices-finance
```

## 🤝 Contributing

I welcome contributions!

1. Fork the project
2. Create your branch
3. Make your changes
4. Submit a PR
