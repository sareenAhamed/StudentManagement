package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.StudentRequest;
import com.example.StudentManagement.model.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(StudentRequest request);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Long id, StudentRequest request);
    void deleteStudent(Long id);
}
