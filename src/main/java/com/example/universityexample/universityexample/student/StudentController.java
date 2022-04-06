package com.example.universityexample.universityexample.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student postNewStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }
}
