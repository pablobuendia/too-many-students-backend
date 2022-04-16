package com.example.universityexample.student;

import com.example.universityexample.address.Address;
import com.example.universityexample.university.University;
import com.example.universityexample.university.UniversityDto;
import com.example.universityexample.address.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student studentDtoToStudent(StudentDto studentDto);
    StudentDto studentToStudentDto(Student student);

    // This prevents a recursive StackOverflowError
    @Mapping(target = "owner", ignore = true)
    Address addressDtoToAddress(AddressDto addressDto);
    @Mapping(target = "owner", ignore = true)
    AddressDto addressToAddressDto(Address address);

    University universityDtoToUniversity(UniversityDto universityDto);
    UniversityDto universityToUniversityDto(University university);
}
