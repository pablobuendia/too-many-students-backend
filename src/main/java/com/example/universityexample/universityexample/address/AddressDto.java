package com.example.universityexample.universityexample.address;

import com.example.universityexample.universityexample.student.StudentDto;
import lombok.Data;

@Data
public class AddressDto {

    private String id;
    private String lineStreet1;
    private String lineStreet2;
    private StudentDto student;
}
