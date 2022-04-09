package com.example.universityexample.universityexample.student;

import com.example.universityexample.universityexample.university.University;
import com.example.universityexample.universityexample.university.UniversityDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student studentDtoToStudent(StudentDto studentDto);

    University universityDtoToUniversity(UniversityDto universityDto);
}
