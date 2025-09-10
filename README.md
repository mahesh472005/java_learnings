# 📘 Java Learnings Repository

This repository is a collection of my hands-on practice and notes while learning **Java frameworks and tools** such as:
- JDBC
- Hibernate
- Spring (to be added later)
- And more as I progress 🚀
---


---

## ⚡ Topics Covered So Far

### 🔹 JDBC
- Establishing connection with MySQL using `DriverManager`
- Performing **CRUD** operations with `PreparedStatement`
- Using `ResultSet` for data retrieval
- Best practices (`try-with-resources`)

### 🔹 Hibernate
- Hibernate configuration and setup
- Entity mapping with annotations and XML
- CRUD operations (`persist`, `get`, `update`, `delete`)
- Relationships / Mappings:
  - One-to-One
  - One-to-Many & Many-to-One
  - Many-to-Many

---

## ⚡ JDBC Implementation – Steps

1. **Set up Database**  
   - Create a database (e.g., `java_learning`) in MySQL.  
   - Create a table (e.g., `student` with columns `id`, `name`, `marks`).  

2. **Add JDBC Driver**  
   - Add MySQL Connector/J (JDBC driver) to your project (via Maven dependency or jar file).  

3. **Establish Connection**  
   - Use `DriverManager.getConnection(url, username, password)` to connect to MySQL.  

4. **Perform CRUD Operations**  
   - **Create** → Use `INSERT` query with `PreparedStatement`.  
   - **Read** → Use `SELECT` query and process results with `ResultSet`.  
   - **Update** → Use `UPDATE` query with `PreparedStatement`.  
   - **Delete** → Use `DELETE` query with `PreparedStatement`.  

5. **Close Resources**  
   - Always close `ResultSet`, `PreparedStatement`, and `Connection` objects.  
   - Prefer `try-with-resources` for automatic resource management.  

---

## ⚡ Hibernate Implementation – Steps

1. **Create a Maven Project**  
   - Choose Maven with JDK (Java 8 or above).  

2. **Add Dependencies in `pom.xml`**  
   - Add MySQL JDBC driver.  
   - Add Hibernate Core ORM library.  

3. **Create an Entity Class (e.g., `Student`)**  
   - Add fields like `rollno`, `name`, `marks`.  
   - Generate getters and setters.  

4. **Create Hibernate Configuration File (`hibernate.cfg.xml`)**  
   - Add database connection details (URL, username, password).  
   - Specify Hibernate dialect.  
   - Enable `hbm2ddl.auto` (update/create).  
   - Map the entity class.  

5. **Write Main Class**  
   - Create `Configuration` object and load `hibernate.cfg.xml`.  
   - Build `SessionFactory`.  
   - Open a `Session`.  
   - Create an object of `Student` and set values using setters.  
   - Begin transaction.  
   - Use `session.persist(obj)` to save the object.  
   - Commit transaction and close session.  

---

## 🔄 Hibernate CRUD Operations
- **Create** → `session.persist(entity)`  
- **Read** → `session.find(Entity.class, id)`  
- **Update** → `session.merge(entity)`  
- **Delete** → `session.remove(entity)`  

---

## 🔗 Hibernate Mappings

1. **One-to-One Mapping**  
   - Used when one entity is associated with exactly one other entity.  

2. **One-to-Many & Many-to-One Mapping**  
   - One entity is related to multiple entities, and vice versa.  

3. **Many-to-Many Mapping**  
   - Entities can have a relationship with many entities on both sides.  

Each mapping is implemented with proper Hibernate annotations (`@OneToOne`, `@OneToMany`, `@ManyToOne`, `@ManyToMany`) and tested with sample entities.  

---

## 🎯 Purpose
This repository is meant for:
- Documenting my journey of learning the **Java ecosystem**
- Building a strong foundation in **enterprise development**
- Serving as **reference code** for future projects

---

## 📌 Recruiter Highlights
- Hands-on experience with **JDBC** and **Hibernate**
- Strong knowledge of **CRUD operations**
- Implemented **Hibernate mappings (One-to-One, One-to-Many, Many-to-One, Many-to-Many)**
- Familiar with **SQL integration with Java**
- Actively learning **Spring Core** and **Spring Boot**

---

## 🔮 Next Steps
- Add **Spring Core** and **Spring Boot** examples  
- Work on **JPA** with Hibernate  
- Create small demo projects integrating multiple technologies  

---

## 🛠️ Prerequisites
- **Java 8+** installed
- **MySQL** installed and running
- **Maven** installed
- Any IDE (**IntelliJ, Eclipse, VS Code**)

👨‍💻 Author: Mahesh Kumar  
