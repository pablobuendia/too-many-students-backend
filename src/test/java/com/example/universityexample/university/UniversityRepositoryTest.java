package com.example.universityexample.university;

import com.example.universityexample.address.AddressRepository;
import com.example.universityexample.student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UniversityRepositoryTest {

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void testLoadedRepositories() {
        assertThat(universityRepository).isNotNull();
        assertThat(studentRepository).isNotNull();
        assertThat(addressRepository).isNotNull();
    }
}