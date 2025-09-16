package com.mahesh.SpringJDBC;

import com.mahesh.SpringJDBC.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
/*
* create a project using start.spring.io
* while creation add h2 database dependency
* then create the model, service and repository layers
* autowire wherever necessary
* import jdbcTemplate class in repository
* to import the jdbcTemplate class, you need this dependency ;
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
* create the schema.sql, and data.sql in the resources folder
* use jdbcTemplate.update() for updating the student table
* use jdbctemplate.query() for select queries, but note that
  it takes two parameters, one is sql query, the other is
  RowMapper which is a Functional interface, in which you
  have to implement the rowMap method, where you write the
  logic and return the Student object
* jdbcTemplate.query() returns a List<T>. collect it using list and display
Spring Jdbc using external drivers :
* add the suitable external database dependency in pom.xml, I used MySQL
* in the application.properties, configure it
* thats it, no need to change any of the code
* now we can access the mysql student table
 */
@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringJdbcApplication.class, args);

        Student student = applicationContext.getBean(Student.class);
	}

}
