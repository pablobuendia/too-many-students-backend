package com.pablobuendia.universitymanager.entities.student;

import com.pablobuendia.universitymanager.error.ElementNotFoundException;
import com.pablobuendia.universitymanager.event.Publisher;
import com.pablobuendia.universitymanager.event.UserCreatedEvent;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "student-cache")
public class StudentService {

  private final StudentRepository studentRepository;
  private final Publisher publisher;

  public List<StudentDto> getAllStudents() {
    return studentRepository.findAll().stream()
        .map(StudentMapper.INSTANCE::studentToStudentDto)
        .collect(Collectors.toList());
  }

  @Cacheable
  public StudentDto getStudent(Long id) {
    val student = studentRepository.findById(id).orElseThrow(() ->
        new ElementNotFoundException("No such student found with id " + id));
    return StudentMapper.INSTANCE.studentToStudentDto(student);
  }

  public StudentDto addStudent(StudentDto studentDto) {
    val savedStudent = saveStudent(studentDto);

    publishNewCreatedStudent(savedStudent);
    return StudentMapper.INSTANCE.studentToStudentDto(savedStudent);
  }

  private Student saveStudent(StudentDto studentDto) {
    val studentEntity = StudentMapper.INSTANCE.studentDtoToStudent(studentDto);

    return studentRepository.save(studentEntity);
  }

  @CacheEvict
  public void deleteStudent(Long id) {
    checkStudentExists(id);

    studentRepository.deleteById(id);
  }

  @CachePut(key = "#id")
  public StudentDto updateStudent(Long id, StudentDto studentDto) {
    checkStudentExists(id);

    val updatedStudent = studentRepository
        .save(StudentMapper.INSTANCE.studentDtoToStudent(studentDto));
    return StudentMapper.INSTANCE.studentToStudentDto(updatedStudent);
  }

  public StudentDto putStudent(Long id, StudentDto studentDto) {
    checkStudentExists(id);

    val updatedStudent = studentRepository
        .save(StudentMapper.INSTANCE.studentDtoToStudent(studentDto));
    return StudentMapper.INSTANCE.studentToStudentDto(updatedStudent);
  }

  public List<StudentDto> getAllStudentsOrderedByLastName() {
    return studentRepository
        .findAllByOrderByLastNameAsc().stream()
        .map(StudentMapper.INSTANCE::studentToStudentDto)
        .collect(Collectors.toList());
  }

  private void checkStudentExists(Long id) {
    if (!studentRepository.existsById(id)) {
      throw new ElementNotFoundException("No such student found with id " + id);
    }
  }

  private void publishNewCreatedStudent(Student student) {
    UserCreatedEvent newEvent = new UserCreatedEvent(student.getId(), student.getCreated());

    publisher.publishEvent(newEvent);
  }
}
