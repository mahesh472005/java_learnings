# 🌱 Spring Framework — Complete Guide  

Spring is an **ecosystem for building Java applications**.  
It promotes **POJO-based development** and is built on the core principles of:  
- **IOC (Inversion of Control)**  
- **DI (Dependency Injection)**  

---

## 🔹 Core Concepts
- Any object managed by Spring is called a **Bean**.  
- **ApplicationContext** → Central interface to access beans.  
- `getBean()` → Fetches bean objects from the container.  
- *Ways to Configure Spring*:  
  - **XML-based**  
  - **Java-based**  
  - **Annotation-based**  

---

## 🔹 Spring vs Spring Boot
| Feature            | Spring Framework | Spring Boot |
|--------------------|------------------|-------------|
| Setup & Config     | Manual, verbose  | Auto-configured |
| Dependency Mgmt    | Needs XML/Java config | Starter dependencies |
| Production-ready   | Extra effort     | Built-in features (Actuator, Embedded Server) |

---

## 🔹 Spring Project Setup (XML-based)
1. Create a **Maven Project** with `quick-start` archetype.  
2. Add **Spring Context Dependency** from Maven Repository.  
3. Create a class (e.g., `Developer`).  
4. In `resources`, create `spring.xml`.  
5. Configure beans:  
   ```xml
   <bean id="dev" class="com.mahesh.Developer" />
   ```
6. Load beans in `Main`:  
   ```java
   ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
   Developer dev = context.getBean("dev", Developer.class);
   dev.code();
   ```

---

## 🔹 Dependency Injection & Autowiring
- `@Component` → Marks class as a Spring-managed bean.  
- `@Autowired` → Automatically injects dependencies.  

Example:  
```java
@Component
class Developer {
    public void code() {
        System.out.println("Coding...");
    }
}

@Component
class Project {
    @Autowired
    private Developer developer;

    public void start() {
        developer.code();
    }
}
```

---

## 🔹 Spring XML Configuration Example
`spring.xml`  
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="dev" class="com.mahesh.Developer"/>
</beans>
```

---

## 🔹 Bean Scopes
- **Singleton** *(Default)*  
  - One instance shared across the container.  
  - Multiple `getBean()` calls return **same object**.  

- **Prototype**  
  - New instance created **every time** `getBean()` is called.  
  - Multiple `getBean()` calls return **different objects**.  

---

## 🚀 Key Takeaways for Interviews
✅ Understand **IOC & DI** — backbone of Spring.  
✅ Be confident in **Bean Scopes** & **ApplicationContext**.  
✅ Explain **Spring vs Spring Boot** differences clearly.  
✅ Demonstrate setup using **XML, Annotation, and Java Config**.  
✅ Show practical use of `@Component` and `@Autowired`.  

---

