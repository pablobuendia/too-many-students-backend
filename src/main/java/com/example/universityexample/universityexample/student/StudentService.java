package com.example.universityexample.universityexample.student;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "product-cache")
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Cacheable
    public Student getStudent(Long id){
        return studentRepository.findById(id).orElseThrow(() ->
        new RuntimeException("No such student found with id"));
    }

    public Student addStudent(StudentDto studentDto) {
        return studentRepository.save(StudentMapper.INSTANCE.studentDtoToStudent(studentDto));
    }

    @CacheEvict
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @CachePut(key = "#id")
    public Student updateStudent(Long id, StudentDto studentDto) {
        return studentRepository.save(StudentMapper.INSTANCE.studentDtoToStudent(studentDto));
    }
}
