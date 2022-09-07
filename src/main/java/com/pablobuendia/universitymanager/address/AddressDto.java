package com.pablobuendia.universitymanager.address;

import com.pablobuendia.universitymanager.address.city.CityDto;
import com.pablobuendia.universitymanager.student.Student;
import lombok.Data;

@Data
public class AddressDto {

    private String id;
    private String lineStreet1;
    private String lineStreet2;
    private Student owner;
    private CityDto city;
}
