package com.pablobuendia.universitymanager.student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "StudentController", description = "Student controller")
public class StudentController {

    private final StudentService studentService;

    @Operation(summary = "Get all students", description = "Get all students, including addresses and university")
    @GetMapping
    List<StudentDto> findAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentID}")
    StudentDto getCustomerByID(@Parameter(description = "Student ID") @PathVariable("studentID") String studentID) {
        log.info("g=fetching customer with id {}", studentID);
        return studentService.getStudent(Long.parseLong(studentID));
    }

    @PostMapping
    StudentDto postNewStudent(@RequestBody StudentDto newStudent) {
        log.info("Saving new customer");
        return studentService.addStudent(newStudent);
    }

    @PatchMapping("/{studentID}")
    StudentDto updateNewStudent(@PathVariable("studentID") String studentID, @RequestBody StudentDto student) {
        log.info("Updating customer with id {}", studentID);
        return studentService.updateStudent(Long.parseLong(studentID), student);
    }

    @DeleteMapping("/{studentID}")
    void deleteStudent(@PathVariable("studentID") String studentID) {
        log.info("Deleting customer with id {}", studentID);
        studentService.deleteStudent(Long.parseLong(studentID));
    }
}
