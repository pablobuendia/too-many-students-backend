package com.example.universityexample.student;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "product-cache")
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentMapper.INSTANCE::studentToStudentDto)
                .collect(Collectors.toList());
    }

    @Cacheable
    public StudentDto getStudent(Long id){
        val student = studentRepository.findById(id).orElseThrow(() ->
        new RuntimeException("No such student found with id"));
        return StudentMapper.INSTANCE.studentToStudentDto(student);
    }

    public StudentDto addStudent(StudentDto studentDto) {
        val studentEntity = StudentMapper.INSTANCE.studentDtoToStudent(studentDto);

        if (studentEntity.getAddressList() != null) {
            studentEntity.getAddressList()
                    .forEach(address -> address.setOwner(studentEntity));
        }

        return StudentMapper.INSTANCE.studentToStudentDto(studentRepository.save(studentEntity));
    }

    @CacheEvict
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @CachePut(key = "#id")
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        val updatedStudent = studentRepository.save(StudentMapper.INSTANCE.studentDtoToStudent(studentDto));
        return StudentMapper.INSTANCE.studentToStudentDto(updatedStudent);
    }
}
