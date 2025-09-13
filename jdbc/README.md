# ⚡JDBC  
- Establishing connection with MySQL using `DriverManager`
- Performing **CRUD** operations with `PreparedStatement`
- Using `ResultSet` for data retrieval
- Best practices (`try-with-resources`)
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