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
import org.springframework.web.bind.annotation.PutMapping;
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
    log.debug("Fetching all students");
    return studentService.getAllStudentsOrderedByLastName();
  }

  @GetMapping("/{studentId}")
  StudentDto getStudentById(
      @Parameter(description = "Student ID") @PathVariable String studentId) {
    log.debug("fetching student with id {}", studentId);
    return studentService.getStudent(Long.parseLong(studentId));
  }

  @PostMapping
  StudentDto postNewStudent(@RequestBody StudentDto newStudent) {
    log.debug("Saving new customer");
    return studentService.addStudent(newStudent);
  }

  @PatchMapping("/{studentId}")
  StudentDto updateStudent(@PathVariable String studentId,
      @RequestBody StudentDto student) {
    log.debug("Updating customer with id {}", studentId);
    return studentService.updateStudent(Long.parseLong(studentId), student);
  }

  @PutMapping("/{studentId}")
  StudentDto patchStudent(@PathVariable String studentId, @RequestBody StudentDto studentDto) {
    log.debug("Putting document with id {}", studentId);
    return studentService.putStudent(Long.parseLong(studentId), studentDto);
  }

  @DeleteMapping("/{studentId}")
  void deleteStudent(@PathVariable String studentId) {
    log.debug("Deleting customer with id {}", studentId);
    studentService.deleteStudent(Long.parseLong(studentId));
  }
}
