package com.pablobuendia.universitymanager.entities.student;

import com.pablobuendia.universitymanager.entities.university.University;
import com.pablobuendia.universitymanager.entities.university.UniversityDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student studentDtoToStudent(StudentDto studentDto);

    StudentDto studentToStudentDto(Student student);

    University universityDtoToUniversity(UniversityDto universityDto);

    UniversityDto universityToUniversityDto(University university);

}
