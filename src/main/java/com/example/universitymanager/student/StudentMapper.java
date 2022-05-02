package com.example.universitymanager.student;

import com.example.universitymanager.address.Address;
import com.example.universitymanager.university.University;
import com.example.universitymanager.university.UniversityDto;
import com.example.universitymanager.address.AddressDto;
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
