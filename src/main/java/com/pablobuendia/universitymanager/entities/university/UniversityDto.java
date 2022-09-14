package com.pablobuendia.universitymanager.entities.university;

import com.pablobuendia.universitymanager.entities.address.city.CityDto;
import com.pablobuendia.universitymanager.entities.student.StudentDto;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UniversityDto {

  private String id;
  @NotNull
  private String name;
  private String lineStreet1;
  private String lineStreet2;
  private CityDto city;
  private List<StudentDto> students;

}
