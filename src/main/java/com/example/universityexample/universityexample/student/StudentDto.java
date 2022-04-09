package com.example.universityexample.universityexample.student;

import com.example.universityexample.universityexample.university.UniversityDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDto {

    private String id;
    private String firstName;
    private String lastName;
    private UniversityDto university;
}
