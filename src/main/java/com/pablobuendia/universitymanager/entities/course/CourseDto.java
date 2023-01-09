package com.pablobuendia.universitymanager.entities.course;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDto {

  private Long id;
  private String name;
  private String degree;
  private Integer credits;
  private Double passingGrade;
}
