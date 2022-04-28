package com.example.universityexample.university;

import com.example.universityexample.address.AddressDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UniversityDto {

    private String id;
    private String name;
    private List<AddressDto> addressList;
}
