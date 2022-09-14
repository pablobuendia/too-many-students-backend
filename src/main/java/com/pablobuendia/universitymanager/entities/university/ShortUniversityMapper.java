package com.pablobuendia.universitymanager.entities.university;

import com.pablobuendia.universitymanager.entities.student.Student;
import com.pablobuendia.universitymanager.entities.student.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShortUniversityMapper {

  ShortUniversityMapper INSTANCE = Mappers.getMapper(ShortUniversityMapper.class);

  @Mappings({@Mapping(target = "students", expression = "java(null)")})
  University universityDtoToUniversity(UniversityDto universityDto);

  @Mappings({@Mapping(target = "students", expression = "java(null)")})
  UniversityDto universityToUniversityDto(University university);

  @Mappings({@Mapping(target = "university", expression = "java(null)")})
  Student studentDtoToStudent(StudentDto studentDto);

  @Mappings({@Mapping(target = "university", expression = "java(null)")})
  StudentDto studentToStudentDto(Student student);
}
