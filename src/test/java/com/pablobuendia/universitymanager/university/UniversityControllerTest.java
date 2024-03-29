package com.pablobuendia.universitymanager.university;

import com.pablobuendia.universitymanager.entities.address.AddressRepository;
import com.pablobuendia.universitymanager.entities.address.city.CityRepository;
import com.pablobuendia.universitymanager.entities.address.country.CountryRepository;
import com.pablobuendia.universitymanager.entities.student.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pablobuendia.universitymanager.entities.university.UniversityController;
import com.pablobuendia.universitymanager.entities.university.UniversityDto;
import com.pablobuendia.universitymanager.entities.university.UniversityRepository;
import com.pablobuendia.universitymanager.entities.university.UniversityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        mockMvc.perform(get("/api/v1/university/1"))
                .andExpect(status().isOk());
    }

    @Test
    void whenPostValidInput_thenReturns200() throws Exception {
        UniversityDto dto = UniversityDto.builder().id("1").name("Test").build();

        mockMvc.perform(post("/api/v1/university")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        ArgumentCaptor<UniversityDto> dtoCaptor = ArgumentCaptor.forClass(UniversityDto.class);
        verify(universityService, times(1)).postNewUniversity(dtoCaptor.capture());
        assertThat(dtoCaptor.getValue().getName()).isEqualTo("Test");
    }

    @Test
    void whenPostNullValue_thenReturns400() throws Exception {
        UniversityDto dto = UniversityDto.builder().id("1").name(null).build();

        mockMvc.perform(post("/api/v1/university")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }
}