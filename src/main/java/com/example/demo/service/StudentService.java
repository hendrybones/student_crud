package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllEmployees();
    void saveStudent(Student student);
    Student getStudentByI(Long id);
    void deleteStudentById(Long id);
}
