package com.pablobuendia.universitymanager.entities.course;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {

  CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

  Course courseDtoToCourse(CourseDto courseDto);

  CourseDto courseToCourseDto(Course course);
}
