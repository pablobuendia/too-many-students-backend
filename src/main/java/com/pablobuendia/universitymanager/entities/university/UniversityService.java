package com.pablobuendia.universitymanager.entities.university;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniversityService {

  private final UniversityRepository universityRepository;

  public List<UniversityDto> getAllUniversities() {
    return universityRepository.findAll().stream()
        .map(ShortUniversityMapper.INSTANCE::universityToUniversityDto)
        .collect(Collectors.toList());
  }

  public UniversityDto getUniversity(Long id) {
    val university = universityRepository.findById(id).orElseThrow(() ->
        new RuntimeException("No university found for id"));
    return ShortUniversityMapper.INSTANCE.universityToUniversityDto(university);
  }

  public UniversityDto getUniversityWithStudents(Long id) {
    val university = universityRepository.retrieveById(id).orElseThrow(() ->
        new RuntimeException("No university found for id"));
    return UniversityMapper.INSTANCE.universityToUniversityDto(university);
  }


  public UniversityDto postNewUniversity(UniversityDto universityDto) {
    val response = universityRepository.save(
        UniversityMapper.INSTANCE.universityDtoToUniversity(universityDto));

    return ShortUniversityMapper.INSTANCE.universityToUniversityDto(response);
  }

}
