package com.pablobuendia.universitymanager.entities.address;

import com.pablobuendia.universitymanager.entities.address.city.CityDto;
import com.pablobuendia.universitymanager.entities.student.Student;
import lombok.Data;

@Data
public class AddressDto {

    private String id;
    private String lineStreet1;
    private String lineStreet2;
    private Student owner;
    private CityDto city;
}
