# 🏢 Job Portal Application

A full-stack **Job Portal Web Application** built using **Spring Boot**, **JSP**, and **Maven**.  
This project is designed for **learning & revision purposes**, covering core concepts of Java, Spring Boot, MVC, and web application development.

---

## 🚀 Features

- Post new jobs  
- View all job listings  
- Add job details dynamically  
- Simple and clean UI with JSP  
- Service-Repository layered architecture  
- Easy to extend for real-world use  

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot, Java 8+, Maven  
- **Frontend**: JSP, CSS  
- **Database**: In-memory (default), can be extended to MySQL/PostgreSQL  
- **Build Tool**: Maven  

---

## 📂 Project Structure

```
job-portal-app/
  ├── pom.xml                # Maven build configuration
  ├── mvnw, mvnw.cmd         # Maven wrapper scripts
  ├── HELP.md                # Spring Boot starter help
  ├── src/
  │   ├── main/
  │   │   ├── java/com/mahesh/job_portal_app/
  │   │   │   ├── JobPortalAppApplication.java    # Main Spring Boot application
  │   │   │   ├── controller/                     # Controllers
  │   │   │   │   └── JobController.java
  │   │   │   ├── model/                          # Entities / Models
  │   │   │   │   └── JobPost.java
  │   │   │   ├── repo/                           # Repository layer
  │   │   │   │   └── JobRepo.java
  │   │   │   ├── service/                        # Service layer
  │   │   │   │   └── JobService.java
  │   │   ├── resources/
  │   │   │   ├── application.properties          # App configuration
  │   │   │   ├── static/                         # Static resources
  │   │   │   ├── templates/                      # Templates (if used)
  │   │   │   └── webapp/
  │   │   │       ├── style.css
  │   │   │       └── views/                      # JSP Views
  │   │   │           ├── addjob.jsp
  │   │   │           ├── home.jsp
  │   │   │           ├── success.jsp
  │   │   │           └── viewalljobs.jsp
  │   └── test/java/com/mahesh/job_portal_app/    # Unit tests
  └── .idea, .mvn, .gitignore                     # Project configs
```

---

## ⚙️ Setup & Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/job-portal-app.git
   cd job-portal-app
   ```

2. **Build the project with Maven**
   ```bash
   ./mvnw clean install
   ```

3. **Run the Spring Boot application**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the application**
   ```
   http://localhost:8080/
   ```

---

## 📖 Usage

- Navigate to **Home Page** → `home.jsp`  
- Add new jobs via **Add Job Form** (`addjob.jsp`)  
- View all jobs on **View All Jobs** page (`viewalljobs.jsp`)  
- Confirmation appears on `success.jsp`  

---

## 🧩 Future Enhancements

- User authentication (Spring Security)  
- Database integration (MySQL/PostgreSQL)  
- Advanced search & filter jobs  
- REST APIs for external clients  
- Responsive UI with Bootstrap/React  

---

## 🤝 Contribution

Contributions are welcome!  
1. Fork the repo  
2. Create a new branch (`feature-xyz`)  
3. Commit changes  
4. Open a Pull Request  

---

## 📜 License

This project is open-source and available under the **MIT License**.

---
✨ Happy Coding & Revising! 🚀
