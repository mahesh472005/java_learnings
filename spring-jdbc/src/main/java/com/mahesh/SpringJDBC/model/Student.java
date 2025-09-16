package com.mahesh.SpringJDBC.model;

import com.mahesh.SpringJDBC.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id;
    private String name;
    private String marks;

    private StudentService studentService;

    public StudentService getStudentService() {
        return studentService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        studentService.addStudent();
        studentService.getStudents();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks='" + marks + '\'' +
                '}';
    }
}
