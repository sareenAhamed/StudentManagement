package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.StudentRequest;
import com.example.StudentManagement.exception.ResourceNotFoundException;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.StudentRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student createStudent(StudentRequest request) {
        Student student = new Student(
                request.getName(),
                request.getEmail(),
                request.getCourse(),
                request.getAge()
        );
        return studentRepo.save(student);
    }

    // ✅ Added pagination implementation
    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepo.findAll(pageable);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID " + id));
    }

    @Override
    public Student updateStudent(Long id, StudentRequest request) {
        Student student = getStudentById(id);

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setCourse(request.getCourse());
        student.setAge(request.getAge());

        return studentRepo.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepo.delete(student);
    }
}
