package com.example.universityexample.universityexample.university;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/university")
@RequiredArgsConstructor
@Slf4j
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping
    public List<University> getAllUniversities() {
        return universityService.getAllUniversities();
    }
}
