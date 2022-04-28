package com.example.universityexample.university;

import com.example.universityexample.address.AddressRepository;
import com.example.universityexample.address.city.CityRepository;
import com.example.universityexample.address.country.CountryRepository;
import com.example.universityexample.student.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UniversityController.class)
class UniversityControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniversityControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UniversityService universityService;

    @MockBean
    private UniversityRepository universityRepository;

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private AddressRepository addressRepository;

    @MockBean
    private CityRepository cityRepository;

    @MockBean
    private CountryRepository countryRepository;

    @BeforeEach()
    void initUseCase() {
        LOGGER.info("Before each, init the use case");
    }

    @Test
    void getAllUniversities() throws Exception {
        mockMvc.perform(get("/api/v1/university"))
                .andExpect(status().isOk());
    }

    @Test
    void getUniversity() throws Exception {
        
    }

    @Test
    void postNewUniversity() {

    }
}