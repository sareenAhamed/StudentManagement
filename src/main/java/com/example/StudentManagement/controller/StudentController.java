package com.example.StudentManagement.controller;

import com.example.StudentManagement.dto.StudentRequest;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // ✅ Updated GET method with pagination + sorting
    @GetMapping
    public ResponseEntity<Page<Student>> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort
    ) {
        // Extract sorting field + direction
        String sortField = sort[0];
        String sortDirection = sort.length > 1 ? sort[1] : "asc";

        Pageable pageable = PageRequest.of(
                page,
                size,
                sortDirection.equalsIgnoreCase("asc") ?
                        Sort.by(sortField).ascending() :
                        Sort.by(sortField).descending()
        );

        return ResponseEntity.ok(studentService.getAllStudents(pageable));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentRequest request) {
        return ResponseEntity.status(201).body(studentService.createStudent(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequest request
    ) {
        return ResponseEntity.ok(studentService.updateStudent(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
