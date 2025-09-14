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

## 🔹 Setter Injection (Using property tags)
Setter Injection uses `<property>` tags to inject dependencies.  

Example:  
```xml
<bean id="student" class="com.mahesh.Student">
    <property name="name" value="Mahesh"/>
    <property name="marks" value="90"/>
</bean>
```

For injecting another class:  
```xml
<bean id="address" class="com.mahesh.Address">
    <property name="city" value="Delhi"/>
</bean>

<bean id="student" class="com.mahesh.Student">
    <property name="name" value="Mahesh"/>
    <property name="address" ref="address"/>
</bean>
```

---

## 🔹 Constructor Injection (Using constructor-arg)
Constructor Injection uses `<constructor-arg>` tags.  

Example:  
```xml
<bean id="student" class="com.mahesh.Student">
    <constructor-arg value="Mahesh"/>
    <constructor-arg value="90"/>
</bean>
```

For injecting a class:  
```xml
<bean id="address" class="com.mahesh.Address">
    <property name="city" value="Delhi"/>
</bean>

<bean id="student" class="com.mahesh.Student">
    <constructor-arg value="Mahesh"/>
    <constructor-arg ref="address"/>
</bean>
```

---

## 🔹 Autowiring (XML-based)
- **byName** → Matches the property name with a bean id.  
- **byType** → Matches the property type with a bean class.  

Example (byName):  
```xml
<bean id="address" class="com.mahesh.Address"/>
<bean id="student" class="com.mahesh.Student" autowire="byName"/>
```

Example (byType):  
```xml
<bean id="addressBean" class="com.mahesh.Address"/>
<bean id="student" class="com.mahesh.Student" autowire="byType"/>
```

---

## 🔹 Primary Bean Concept
When multiple beans of the same type exist, we can mark one as **primary**:  
```java
<!-- Two beans of same type -->
<bean id="devA" class="com.mahesh.DeveloperA" primary="true"/>
<bean id="devB" class="com.mahesh.DeveloperB"/>

```

Spring will prefer `DeveloperA` when autowiring.  

---

## 🔹 Lazy Initialization
- By default, Singleton beans are created at startup.  
- Use `lazy-init="true"` to delay initialization until the bean is requested.  

Example:  
```xml
<bean id="dev" class="com.mahesh.Developer" lazy-init="true"/>
```

🔑 Points to Remember:  
- Singleton + lazy-init → Created only when requested.  
- Prototype beans are always created when requested, lazy-init has no effect.  

---

## 🔹 Inner Beans
Beans can be defined inside another bean definition, useful when they are not shared.  

Example:  
```xml
<bean id="student" class="com.mahesh.Student">
    <property name="address">
        <bean class="com.mahesh.Address">
            <property name="city" value="Delhi"/>
        </bean>
    </property>
</bean>
```

---

## 🚀 Key Takeaways for Interviews
✅ Understand **IOC & DI** — backbone of Spring.  
✅ Be confident in **Setter Injection, Constructor Injection & Autowiring**.  
✅ Explain **Primary, Lazy-init, Inner Beans** clearly.  
✅ Show practical use of `@Component` and `@Autowired`.  
✅ Demonstrate setup using **XML, Annotation, and Java Config**.  

---

🔥 With this knowledge, you can confidently explain **Spring fundamentals** in interviews and showcase **hands-on implementation** to recruiters.  
