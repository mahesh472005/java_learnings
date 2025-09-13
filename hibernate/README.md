# ⚡Hibernate 
- Hibernate configuration and setup
- Entity mapping with annotations and XML
- CRUD operations (`persist`, `get`, `update`, `delete`)
- Relationships / Mappings:
  - One-to-One
  - One-to-Many & Many-to-One
  - Many-to-Many
---

## 🔹 Hibernate Implementation – Steps

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