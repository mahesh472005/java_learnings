package com.mahesh.SpringJDBC.service;

import com.mahesh.SpringJDBC.model.Student;
import com.mahesh.SpringJDBC.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public void addStudent() {
        studentRepo.save();
    }

    public void getStudents() {
        List<Student> studentList = studentRepo.getAll();
        System.out.println(studentList);
    }
}
