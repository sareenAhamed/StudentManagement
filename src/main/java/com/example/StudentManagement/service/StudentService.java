package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.StudentRequest;
import com.example.StudentManagement.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    Student createStudent(StudentRequest request);

    // ✅ Updated for pagination
    Page<Student> getAllStudents(Pageable pageable);

    Student getStudentById(Long id);
    Student updateStudent(Long id, StudentRequest request);
    void deleteStudent(Long id);
}
