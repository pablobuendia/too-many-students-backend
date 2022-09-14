package com.pablobuendia.universitymanager.entities.student;

import com.pablobuendia.universitymanager.entities.university.University;
import com.pablobuendia.universitymanager.entities.university.UniversityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

  StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

  Student studentDtoToStudent(StudentDto studentDto);

  StudentDto studentToStudentDto(Student student);

  @Mappings({@Mapping(target = "students", expression = "java(null)")})
  University universityDtoToUniversity(UniversityDto universityDto);

  @Mappings({@Mapping(target = "students", expression = "java(null)")})
  UniversityDto universityToUniversityDto(University university);

}
