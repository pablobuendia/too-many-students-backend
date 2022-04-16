package com.example.universityexample.university;

import com.example.universityexample.address.AddressDto;
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
