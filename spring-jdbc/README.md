# 💾   Spring JDBC 

This project demonstrates how to build a **Spring Boot application using Spring JDBC**, step by step — from setup to connecting with external databases.  

---

## 🚀 Project Setup  
- Created project from **[start.spring.io](https://start.spring.io/)**.  
- Added dependency for **H2 Database**.  
- Later, added external driver dependency (MySQL etc) to switch databases.  
- Organized code into **Model, Service, Repository layers**.  

---

## 📦 Dependencies Used  
```xml
<!-- Spring JDBC Starter -->
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>

<!-- H2 Database (for in-memory DB) -->
<dependency>
   <groupId>com.h2database</groupId>
   <artifactId>h2</artifactId>
   <scope>runtime</scope>
</dependency>

<!-- MySQL Driver (for external DB) -->
<dependency>
   <groupId>mysql</groupId>
   <artifactId>mysql-connector-j</artifactId>
   <scope>runtime</scope>
</dependency>
```

---

## 🗂️ Database Initialization  
- Created **`schema.sql`** → defines table structure.  
- Created **`data.sql`** → inserts initial records.  
- Spring Boot automatically executes these files on startup.  

---

## 🏗️ Repository Layer — JdbcTemplate  
- Imported and Autowired **`JdbcTemplate`**.  
- Used methods:  
  - **`update()`** → for `INSERT`, `UPDATE`, `DELETE`.  
  - **`query()`** → for `SELECT`, returns a `List<T>`.  

### Example — Insert  
```java
String sql = "INSERT INTO student (id, name, marks) VALUES (6, 'spiderman', 89)";
int rows = jdbcTemplate.update(sql);
System.out.println(rows + " added");
```

### Example — Select with RowMapper  
```java
RowMapper<Student> studentRowMapper = (rs, rowNum) -> {
    Student student = new Student();
    student.setId(rs.getInt("id"));
    student.setName(rs.getString("name"));
    student.setMarks(rs.getString("marks"));
    return student;
};

String sql = "SELECT * FROM student";
List<Student> studentList = jdbcTemplate.query(sql, studentRowMapper);
```

---

## 🎯 Key Learnings  
- **JdbcTemplate** simplifies JDBC operations.  
- **RowMapper** is a functional interface to map SQL result sets → Java Objects.  
- **`schema.sql` & `data.sql`** auto-load DB structure & sample data.  
- Easy **switch from H2 → MySQL** by just:  
  1. Adding driver dependency.  
  2. Configuring DB credentials in `application.properties`.  
- No code change required when switching databases.  

---

## ⚡ application.properties (for MySQL)  
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/testdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

---

## ✅ Final Takeaways  
- Learned **end-to-end integration of Spring Boot with JDBC**.  
- Understood **Repository pattern using JdbcTemplate**.  
- Experienced **DB independence** (H2 ↔ MySQL).  
- Gained clarity on **SQL execution, object mapping, and data retrieval**.  

---
✨ With this, I now have a complete workflow of **Spring JDBC** — from setup to production-ready external DB usage.
