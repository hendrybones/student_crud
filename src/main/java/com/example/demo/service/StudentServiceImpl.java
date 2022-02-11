package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllEmployees() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);

    }

    @Override
    public Student getStudentByI(Long id) {
        Optional<Student> optional=studentRepository.findById(id);
        Student student=null;
        if (optional.isPresent()){
            student=optional.get();
        }
        else {
            throw  new RuntimeException("Employee not found for id: " + id);
        }
        return student;
    }

    @Override
    public void deleteStudentById(Long id) {
        this.studentRepository.deleteById(id);


    }
}
