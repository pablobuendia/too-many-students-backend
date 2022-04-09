package com.example.universityexample.universityexample;

import com.example.universityexample.universityexample.address.Address;
import com.example.universityexample.universityexample.address.AddressRepository;
import com.example.universityexample.universityexample.student.Student;
import com.example.universityexample.universityexample.student.StudentRepository;
import com.example.universityexample.universityexample.university.University;
import com.example.universityexample.universityexample.university.UniversityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class UniversityExampleApplication implements CommandLineRunner {

	private final StudentRepository studentRepository;
	private final UniversityRepository universityRepository;
	private final AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(UniversityExampleApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("Entering sample data through CommandLineRunner");

		val uni = University.builder().name("MIT").build();
		universityRepository.save(uni);

		val addressPablo = Address.builder().lineStreet1("Belgrano 111").build();
		val addressMaria = Address.builder().lineStreet1("Guemes 111").build();
		val addressJuana = Address.builder().lineStreet1("Paz 111").build();
		addressRepository.saveAll(List.of(addressPablo, addressMaria, addressJuana));

		studentRepository.save(Student.builder().firstName("Pablo").lastName("Buendia").university(uni).build());
		studentRepository.save(Student.builder().firstName("Maria").lastName("Rodriguez").university(uni).build());
		studentRepository.save(Student.builder().firstName("Juana").lastName("Perez").university(uni).build());
	}

}
