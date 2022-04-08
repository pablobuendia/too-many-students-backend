package com.example.universityexample.universityexample.student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    List<Student> findAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentID}")
    Student getCustomerByID(@PathVariable("studentID") String studentID) {
        log.info("g=fetching customer with id {}", studentID);
        return studentService.getStudent(Long.getLong(studentID));
    }

    @PostMapping
    Student postNewStudent(Student newStudent) {
        log.info("Saving new customer");
        return studentService.addStudent(newStudent);
    }

    @PatchMapping("/{studentID}")
    Student updateNewStudent(@PathVariable("studentID") String studentID, Student student) {
        log.info("Saving new customer");
        return studentService.updateStudent(studentID, student);
    }
}
