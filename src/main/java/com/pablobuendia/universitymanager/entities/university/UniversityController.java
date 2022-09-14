package com.pablobuendia.universitymanager.entities.university;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/university")
@RequiredArgsConstructor
@Slf4j
public class UniversityController {

  private final UniversityService universityService;

  @GetMapping
  public List<UniversityDto> getAllUniversities() {
    return universityService.getAllUniversities();
  }

  @GetMapping("/{universityID}")
  public UniversityDto getUniversity(@PathVariable String universityID) {
    Instant start = Instant.now();
    val result = universityService.getUniversity(Long.parseLong(universityID));
    Instant end = Instant.now();
    Duration timeElapsed = Duration.between(start, end);
    //System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");
    return result;
  }

  @GetMapping("/{universityID}/students")
  public UniversityDto getUniversityWithStudents(@PathVariable String universityID) {
    Instant start = Instant.now();
    val result = universityService.getUniversityWithStudents(Long.parseLong(universityID));
    Instant end = Instant.now();
    Duration timeElapsed = Duration.between(start, end);
    //System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");
    return result;
  }

  @PostMapping
  public UniversityDto postNewUniversity(@Valid @RequestBody UniversityDto newUniversity) {
    return universityService.postNewUniversity(newUniversity);
  }
}
