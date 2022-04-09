package com.example.universityexample.universityexample.student;

import com.example.universityexample.universityexample.address.Address;
import com.example.universityexample.universityexample.address.AddressMapper;
import com.example.universityexample.universityexample.address.AddressRepository;
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
    private final AddressRepository addressRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Cacheable
    public Student getStudent(Long id){
        return studentRepository.findById(id).orElseThrow(() ->
        new RuntimeException("No such student found with id"));
    }

    public StudentDto addStudent(StudentDto studentDto) {
        val savedStudent = studentRepository.save(StudentMapper.INSTANCE.studentDtoToStudent(studentDto));

        val savedAddressList = saveAddressList(studentDto, savedStudent);
        savedStudent.setAddressList(savedAddressList);

        return StudentMapper.INSTANCE.studentToStudentDto(savedStudent);
    }

    private List<Address> saveAddressList(StudentDto studentDto, Student savedStudent) {
        if (studentDto.getAddressList() == null) {
            return null;
        }

        return studentDto.getAddressList().stream()
                .map(AddressMapper.INSTANCE::addressDtoToAddress)
                .map(address -> {
                    address.setStudent(savedStudent);
                    return address;
                })
                .map(addressRepository::save)
                .collect(Collectors.toList());
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
