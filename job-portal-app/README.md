# 📌 Job Portal Application

A full-stack **Job Portal App** built with :-
- **Backend** → Spring Boot (Java, REST APIs)
- **Frontend** → React + Vite + TailwindCSS

This project demonstrates **CRUD operations** (Create, Read, Update,
Delete) for job postings.

------------------------------------------------------------------------

## ⚙️ Features

### 🔹 Backend (Spring Boot)

-   **Job Model**: Represents job postings with fields →
    `id, title, company, location, desc`.
-   **REST Endpoints** (in `JobController`):
    -   `GET /jobs` → Fetch all jobs
    -   `GET /job/{id}` → Fetch a specific job by ID
    -   `POST /job` → Add a new job
    -   `PUT /job` → Update an existing job
    -   `DELETE /job/{id}` → Delete a job
-   **In-Memory Repository (`JobRepo`)**:
    -   Pre-loaded with sample jobs (Java Developer, Frontend Developer,
        Data Scientist, etc.)
    -   Stores job postings in a list (`ArrayList`)
    -   Supports CRUD logic without an external database
-   **Service Layer (`JobService`)**:
    -   Acts as a middle layer between controller and repo
    -   Keeps code organized and modular

------------------------------------------------------------------------

### 🔹 Frontend (React + Vite + Tailwind)

-   Fetches jobs from Spring Boot backend (`http://localhost:8080`)
-   Displays job cards (title, company, location, description)
-   Provides a form to **add / edit jobs**
-   Allows **deleting jobs** with confirmation
-   Responsive design using TailwindCSS
-   Minimal Navbar for navigation

------------------------------------------------------------------------

## 🗂️ Project Structure

    job-portal-app/
    ├── backend/                                   # Spring Boot application
    │ ├── src/main/java/com/mahesh/job_portal_app/
    │ │ ├── model/JobPost.java
    │ │ ├── controller/JobController.java
    │ │ ├── service/JobService.java
    │ │ └── repo/JobRepo.java
    │ └── pom.xml
    │
    ├── frontend/                               # React frontend application
    │ ├── src/
    │ ├── package.json
    │ └── vite.config.js
    │
    └── start-job-portal.bat                      # One-click starter script

------------------------------------------------------------------------

## 🚀 Getting Started

### 1️⃣ Clone Repository

``` bash
git clone https://github.com/<your-username>/job-portal-app.git
cd job-portal-app
```
```

This will: - Start Spring Boot backend (`mvn spring-boot:run`)
- Start React frontend (`npm run dev`)

### 2️⃣ Start Backend (Spring Boot)

``` bash
cd backend
mvn spring-boot:run
```

Backend runs at → http://localhost:8080

### 3️⃣ Start Frontend (React)

``` bash
cd frontend
npm install
npm run dev
```

Frontend runs at → http://localhost:5173

---
## ⚡ Quick Start with Batch Script (Windows)
Instead of starting backend & frontend separately:

``` bash
start-job-portal.bat
```
---

------------------------------------------------------------------------

## 🖥️ API Endpoints

  | Method  | Endpoint        | Description              | Request Body                           |
|---------|------------------|--------------------------|----------------------------------------|
| GET     | `/jobs`          | Get all jobs             | —                                      |
| GET     | `/job/{id}`      | Get job by ID            | —                                      |
| POST    | `/job`           | Add new job              | `{ id, title, company, location, desc }` |
| PUT     | `/job`           | Update existing job      | `{ id, title, company, location, desc }` |
| DELETE  | `/job/{id}`      | Delete job by ID         | —                                      |


## 📌 Example Job Object

``` json
{
  "id": 101,
  "title": "Java Developer",
  "company": "Oracle",
  "location": "Mumbai",
  "desc": "Must have good experience in core Java and advanced Java"
}
```

------------------------------------------------------------------------



------------------------------------------------------------------------

## 🛠️ Tech Stack

### Backend:

-   Java 17
-   Spring Boot
-   REST APIs

### Frontend:

-   React (Vite)
-   TailwindCSS
-   Axios (API calls)

------------------------------------------------------------------------

## 📚 Future Enhancements

-   Replace in-memory repo with MySQL/PostgreSQL
-   Add User authentication & roles
-   Advanced search & filter for jobs
-   Deploy backend & frontend to cloud

------------------------------------------------------------------------

## 📸 Screenshots


------------------------------------------------------------------------

✨ Built with ❤️ by Mahesh
