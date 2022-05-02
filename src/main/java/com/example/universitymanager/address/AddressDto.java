package com.example.universitymanager.address;

import com.example.universitymanager.commons.BaseEntityDto;
import com.example.universitymanager.address.city.CityDto;
import lombok.Data;

@Data
public class AddressDto {

    private String id;
    private String lineStreet1;
    private String lineStreet2;
    private BaseEntityDto owner;
    private CityDto city;
}
