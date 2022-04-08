package com.example.universityexample.universityexample;

import com.example.universityexample.universityexample.student.Student;
import com.example.universityexample.universityexample.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class UniversityExampleApplication implements CommandLineRunner {

	private final StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(UniversityExampleApplication.class, args);
	}

	@Override
	public void run(String... args) {
		studentRepository.save(new Student("1", "pablo", "buendia"));
		studentRepository.save(new Student("2", "maria", "rodriguez"));
		studentRepository.save(new Student("3", "juana", "perez"));
	}

}
