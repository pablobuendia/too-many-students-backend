package com.example.universityexample.address;

import com.example.universityexample.BaseEntityDto;
import com.example.universityexample.address.city.CityDto;
import lombok.Data;

@Data
public class AddressDto {

    private String id;
    private String lineStreet1;
    private String lineStreet2;
    private BaseEntityDto owner;
    private CityDto city;
}
