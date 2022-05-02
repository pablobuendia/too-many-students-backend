package com.pablobuendia.universitymanager.student;

import com.pablobuendia.universitymanager.address.AddressDto;
import com.pablobuendia.universitymanager.university.UniversityDto;
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
