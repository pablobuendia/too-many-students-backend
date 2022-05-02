package com.example.universitymanager.address.city;

import com.example.universitymanager.address.country.CountryDto;
import lombok.Data;

@Data
public class CityDto {

    private String id;
    private String name;
    private CountryDto country;
}
