# 🌐 Spring Boot MVC  

This project demonstrates **Spring Boot MVC with Controllers, Views, and Request handling**.  
It covers multiple ways of passing data between Controller ↔ View using **HttpServletRequest, HttpSession, RequestParam, Model, and ModelAndView**.  

## 🔹 What is MVC?
**MVC (Model-View-Controller)** is a **design pattern** used in web development:
- **Model** → Manages the data and business logic.
- **View** → Represents the UI (JSP, Thymeleaf, etc.).
- **Controller** → Handles requests, processes input, and coordinates between Model & View.

### ✅ Why is it needed?
- Separates **concerns** (data, UI, logic).
- Makes code **modular, testable, and maintainable**.
- Allows UI and business logic to **evolve independently**.

### 🔹 How does it help?
- Reusability of code across different layers.
- Simplifies debugging and development.
- Improves scalability for larger applications.

### 🕒 When should we use it?
- When building **web applications** that need clear separation between UI and logic.
- Whenever multiple teams work on **different layers** (frontend/backend).
- When scalability and maintainability are critical.
---

## 🚀 Project Setup  
- Created a Spring Boot project using **[start.spring.io](https://start.spring.io/)**.  
- Added **Spring Web dependency** for MVC features.  
- Organized code into **Controller layer + JSP views**.  

---

## 📦 Dependencies Used  
```xml
<!-- Spring Boot Starter Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- JSP and Servlet API (Jakarta EE) -->
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>

<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <scope>provided</scope>
</dependency>
```

---

## 🏗️ Controller — HomeController.java  
- **Mapping Home Page**  
```java
@RequestMapping("/")
public String home() {
    return "index";
}
```

---

## 🔄 Ways to Pass Data (Session Handling)  

### 1️⃣ Using `HttpServletRequest` + `HttpSession`  
```java
@RequestMapping("result")
public String result(HttpServletRequest request, HttpSession session) {
    int n1 = Integer.parseInt(request.getParameter("num1"));
    int n2 = Integer.parseInt(request.getParameter("num2"));
    session.setAttribute("result", n1+n2);
    return "result.jsp";
}
```

### 2️⃣ Using Direct Parameters  
```java
@RequestMapping("result")
public String result(int num1, int num2, HttpSession session) {
    session.setAttribute("result", num1+num2);
    return "result.jsp";
}
```

### 3️⃣ Using `@RequestParam`  
```java
@RequestMapping("result")
public String result(@RequestParam("num1") int n1, @RequestParam("num2") int n2, HttpSession session) {
    session.setAttribute("result", n1+n2);
    return "result.jsp";
}
```

### 4️⃣ Using `@RequestParam` + `Model`  
```java
@RequestMapping("result")
public String result(@RequestParam("num1") int n1, @RequestParam("num2") int n2, Model model) {
    model.addAttribute("result", n1+n2);
    return "result.jsp";
}
```

⚡ Note: Here, session variable `result` will be `null` since **Model is used instead of Session**.  

---

## 🖼️ Views Without `.jsp` Extension  
- Configure **prefix & suffix** in `application.properties`:  
```properties
spring.mvc.view.prefix=/views/
spring.mvc.view.suffix=.jsp
```  

- Now return only `"result"` or `"index"` instead of `"result.jsp"`.  

---

## 🔀 Using `ModelAndView` (Both Data + View)  
```java
@RequestMapping("result")
public ModelAndView result(@RequestParam("num1") int n1, @RequestParam("num2") int n2, ModelAndView mv) {
    mv.addObject("result", n1+n2);
    mv.setViewName("result");
    return mv;
}
```

✅ `ModelAndView` provides **both model data & view name** in a single object.  

---
## 4. Using @ModelAttribute

#### ✅ What is `@ModelAttribute`?

-   It is used to **bind request parameters to a model object**
    automatically.\
-   It helps reduce boilerplate `set` calls (Spring handles it
    internally).\
-   It can be applied at:
    -   **Method Level** → To add common attributes to `Model`.\
    -   **Parameter Level** → To bind request data into an object.

------------------------------------------------------------------------

### 🔹 Case 1: Adding Common Attributes

``` java
@ModelAttribute("tech")
public String tech() {
    return "java";
}
```

Here, "tech" is added to the Model for every request.

Any JSP/Thymeleaf page can access it using `${tech}`.

------------------------------------------------------------------------

### 🔹 Case 2: Binding Request Parameters to Object (Explicit)

``` java
@RequestMapping("/addStudent")
public String addStudent(@ModelAttribute("student1") Student student) {
    return "result";
}
```

When user submits a form, request parameters (like id, name, marks) are
auto-set into the Student object.

`student1` is the name by which the object will be available in JSP.

------------------------------------------------------------------------

### 🔹 Case 3: Binding Request Parameters to Object (Implicit --- Recommended)

``` java
@RequestMapping("/addStudent")
public String addStudent(Student student) {
    return "result";
}
```

Even without explicitly writing `@ModelAttribute`, Spring assumes it is
present.

Cleaner and preferred way.

------------------------------------------------------------------------

### How `@ModelAttribute` Helps

-   Removes boilerplate code for setting properties.
-   Makes form handling very easy.
-   Eliminates the need for manually extracting
    `request.getParameter()`.
-   Provides a seamless link between form inputs and model objects.


## 🎯 Key Learnings  
- **Multiple ways** to pass request data (HttpServletRequest, Session, RequestParam, Model, ModelAndView).  
- **Model** → only stores data for view.  
- **Session** → persists data across multiple requests.  
- **ModelAndView** → combines both data + view in one object.  
- Using **prefix/suffix** removes `.jsp` extension in controller returns.  
- **@ModelAttribute**:
  - Can be used at **method level** to add common attributes for every request.  
  - Can be used at **parameter level** to bind form/request data directly into objects.  
  - Removes boilerplate `set` methods and eliminates need for `request.getParameter()`.  
  - Provides a **seamless link** between form inputs and model objects.  

---

## ✅ Final Takeaways  
- Learned **Spring Boot MVC request mapping**.  
- Explored **all possible ways to pass data from Controller to View**.  
- Understood **differences between Model, Session, and ModelAndView**.  
- Learned how to configure **view prefix/suffix** for cleaner code.  
- Understood how **@ModelAttribute simplifies form handling** by auto-binding request parameters to objects.  
- Learned that **implicit usage of @ModelAttribute** is cleaner and preferred in Spring MVC.  

---

✨ With this, I now have a complete workflow of **Spring Boot MVC** — from controller mapping to dynamic JSP views, with efficient form handling using **@ModelAttribute**.
