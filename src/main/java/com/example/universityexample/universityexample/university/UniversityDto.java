package com.example.universityexample.universityexample.university;

import com.example.universityexample.universityexample.address.AddressDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UniversityDto {

    private String id;
    private String name;
    private List<AddressDto> addressList;
}
