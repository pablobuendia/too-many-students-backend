package com.pablobuendia.universitymanager.address.city;

import com.pablobuendia.universitymanager.address.country.CountryDto;
import lombok.Data;

@Data
public class CityDto {

    private String id;
    private String name;
    private CountryDto country;
    private String created;
    private String updated;
}
