package com.example.universitymanager.university;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final UniversityRepository universityRepository;

    public List<UniversityDto> getAllUniversities() {
        return universityRepository.findAll().stream()
                .map(UniversityMapper.INSTANCE::universityToUniversityDto)
                .collect(Collectors.toList());
    }

    public UniversityDto getUniversity(Long id) {
        val university = universityRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No university found for id"));
        return UniversityMapper.INSTANCE.universityToUniversityDto(university);
    }

    public UniversityDto postNewUniversity(UniversityDto universityDto) {
        val response = universityRepository.save(UniversityMapper.INSTANCE.universityDtoToUniversity(universityDto));

        return UniversityMapper.INSTANCE.universityToUniversityDto(response);
    }
}
