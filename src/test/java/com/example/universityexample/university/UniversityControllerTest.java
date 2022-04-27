package com.example.universityexample.university;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@ExtendWith(MockitoExtension.class)
class UniversityControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniversityControllerTest.class);

    @Mock
    private UniversityRepository universityRepository;

    @Mock
    private UniversityService universityService;

    @InjectMocks
    private UniversityController universityController;

    @BeforeEach()
    void initUseCase() {
        LOGGER.info("Before each, init the use case");
    }

    @Test
    void getAllUniversities() {
        universityController.getAllUniversities();
    }

    @Test
    void getUniversity() {
        universityController.getUniversity("1");
    }

    @Test
    void postNewUniversity() {
    }
}