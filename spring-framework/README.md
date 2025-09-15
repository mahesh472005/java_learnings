# 🌱 Spring Framework — Complete Guide  

Spring is an **ecosystem for building Java applications**.  
It promotes **POJO-based development** and is built on the core principles of:  
- **IOC (Inversion of Control) / DI (Dependency Injection)**
- **AOP(Aspect-Oriented Programming)**  

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

## 🔰 Spring Project Setup (XML-based)
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
## 🔰 Spring Project Setup (Java-based)
1. Create a **Maven Project** with `quick-start` archetype.  
2. Add **Spring Context Dependency** from Maven Repository.  
3. Create your POJO classes (e.g., `Developer`).  
4. Create a Java Configuration class:  
   ```java
   @Configuration
   @ComponentScan("com.mahesh")
   public class AppConfig {}
   ```
5. Load context in `Main`   

```java
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
Developer dev = context.getBean(Developer.class);
dev.code();

```

---

### 🔹 Bean Scopes with Annotations
```java
@Component
@Scope("singleton") // default
class DevSingleton {}

@Component
@Scope("prototype")
class DevPrototype {}
```

- **Singleton** → One instance in container (default).  
- **Prototype** → New instance every `getBean()` call.  

---

### 🔹 Autowiring Styles

#### 1. Field Injection
```java
@Component
class Student {
    @Autowired
    private Address address; // injected automatically
}
```

#### 2. Constructor Injection ✅ (Recommended)
```java
@Component
class Student {
    private Address address;

    @Autowired
    public Student(Address address) {
        this.address = address;
    }
}
```

#### 3. Setter Injection
```java
@Component
class Student {
    private Address address;

    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }
}
```

---

### 🔹 Handling Ambiguity with `@Qualifier`
```java
@Component("addr1")
class AddressA {}

@Component("addr2")
class AddressB {}

@Component
class Student {
    @Autowired
    @Qualifier("addr1")
    private AddressA address;
}
```

---

### 🔹 `@Primary` Annotation
```java
@Component
@Primary
class DeveloperA implements Developer {}

@Component
class DeveloperB implements Developer {}

@Component
class Project {
    @Autowired
    private Developer developer; // DeveloperA preferred
}
```

---

### 🔹 `@Lazy` Initialization
```java
@Component
@Lazy
class Developer {
    public Developer() {
        System.out.println("Developer bean initialized lazily!");
    }
}
```

---

### 🔹 Relationships between Annotations
- `@Component + @Scope("singleton")` → One shared instance.  
- `@Component + @Scope("prototype")` → New instance each time.  
- `@Lazy + @Scope("singleton")` → Singleton created only when needed.  
- `@Primary` works with `@Autowired` to resolve conflicts.  
- `@Qualifier` **overrides** `@Primary` when explicitly used.  

---

## 🔹 Relationship between `@Scope` and `@Value`

### ✨ Key Concept:
- `@Value` injects **literal values** or **properties**.  
- Works across all scopes (singleton, prototype, etc.).  
- Behavior depends on scope lifecycle.  

---

### ✅ Example: Singleton + `@Value`
```java
@Component
@Scope("singleton")
class Developer {
    @Value("Mahesh")
    private String name;

    public String getName() { return name; }
}
```
- Value injected **once** during container init.  
- Every `getBean()` call → same object with same value.  

---

### ✅ Example: Prototype + `@Value`
```java
@Component
@Scope("prototype")
class Developer {
    @Value("Mahesh")
    private String name;

    public String getName() { return name; }
}
```
- Each `getBean()` call → **new object**.  
- `@Value` injects value **fresh each time**.  

---

### 🔑 Key Takeaways
- `@Value` always injects values regardless of scope.  
- **Singleton + @Value** → injected once, reused.  
- **Prototype + @Value** → injected every new object.  
- External properties (`@PropertySource + ${}`) → work same across all scopes.  

---
## 🔹 Summary
1. Flexible configuration: **XML, Annotations, Java-based**  
2. Multiple **bean scopes** with lifecycle differences  
3. Supports all DI styles (**constructor, setter, field**)  
4. Conflict resolution via **@Primary** & **@Qualifier**  
5. Lazy loading with **@Lazy**, values via **@Value**  

---

## 🚀 Key Takeaways for Interviews
1. **IOC & DI** → Backbone of Spring  
2. **Constructor injection** (preferred) vs Setter/Field  
3. Resolve ambiguity using **@Primary / @Qualifier**  
4. Explain **bean scopes, lazy-init, inner beans** clearly  
5. Be confident with setup using **XML, Annotation, Java Config**  

---
✅ Perfect for last-minute **interview revision**!
  
