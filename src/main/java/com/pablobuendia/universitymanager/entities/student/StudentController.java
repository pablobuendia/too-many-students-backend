package com.pablobuendia.universitymanager.entities.student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    log.debug("Fetching all customers");
    return studentService.getAllStudents();
  }

  @GetMapping("/{studentID}")
  StudentDto getCustomerByID(
      @Parameter(description = "Student ID") @PathVariable("studentID") String studentID) {
    log.debug("fetching customer with id {}", studentID);
    return studentService.getStudent(Long.parseLong(studentID));
  }

  @PostMapping
  StudentDto postNewStudent(@RequestBody StudentDto newStudent) {
    log.debug("Saving new customer");
    return studentService.addStudent(newStudent);
  }

  @PatchMapping("/{studentID}")
  StudentDto updateNewStudent(@PathVariable("studentID") String studentID,
      @RequestBody StudentDto student) {
    log.debug("Updating customer with id {}", studentID);
    return studentService.updateStudent(Long.parseLong(studentID), student);
  }

  @DeleteMapping("/{studentID}")
  void deleteStudent(@PathVariable("studentID") String studentID) {
    log.debug("Deleting customer with id {}", studentID);
    studentService.deleteStudent(Long.parseLong(studentID));
  }
}
