package com.example.universityexample.universityexample.university;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final UniversityRepository universityRepository;

    List<University> getAllUniversities() {
        return universityRepository.findAll();
    }
}
