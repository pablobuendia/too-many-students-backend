package com.example.universityexample.universityexample.address.city;

import com.example.universityexample.universityexample.address.country.CountryDto;
import lombok.Data;

@Data
public class CityDto {

    private String id;
    private String name;
    private CountryDto country;
}
