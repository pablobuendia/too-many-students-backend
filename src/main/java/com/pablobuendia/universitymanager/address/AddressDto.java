package com.pablobuendia.universitymanager.address;

import com.pablobuendia.universitymanager.commons.BaseEntityDto;
import com.pablobuendia.universitymanager.address.city.CityDto;
import lombok.Data;

@Data
public class AddressDto {

    private String id;
    private String lineStreet1;
    private String lineStreet2;
    private BaseEntityDto owner;
    private CityDto city;
}
