package com.example.universityexample.universityexample.student;

import com.example.universityexample.universityexample.address.AddressDto;
import com.example.universityexample.universityexample.university.UniversityDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StudentDto {

    private String id;
    private String firstName;
    private String lastName;
    private UniversityDto university;
    private List<AddressDto> addressList;
}
