# 📘 Java Learnings Repository

This repository is a collection of my hands-on practice and notes while learning **Java frameworks and tools** such as:
- JDBC
- Hibernate
- Spring (to be added later)
- And more as I progress 🚀
---

## ⚡ Topics Covered So Far
### 🔹 JDBC
- Establishing connection with MySQL using `DriverManager`
- Performing **CRUD** operations with `PreparedStatement`
- Using `ResultSet` for data retrieval
- Best practices (`try-with-resources`)

### 🔹 Hibernate
- Hibernate configuration and setup
- Entity mapping (`@Entity`, `@Id`, etc.)
- Saving, updating, deleting entities
- Querying with HQL

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



## 🛠️ Prerequisites
- **Java 8+** installed
- **MySQL** installed and running (for JDBC examples)
- **MySQL Connector/J** (JDBC driver in classpath)
- **Hibernate JARs** or Maven/Gradle dependencies
- Any IDE (**IntelliJ, Eclipse, or VS Code**)

---

