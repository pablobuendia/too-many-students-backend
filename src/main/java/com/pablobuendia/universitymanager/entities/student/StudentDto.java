package com.pablobuendia.universitymanager.entities.student;

import com.pablobuendia.universitymanager.entities.address.AddressDto;
import com.pablobuendia.universitymanager.entities.university.UniversityDto;
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
