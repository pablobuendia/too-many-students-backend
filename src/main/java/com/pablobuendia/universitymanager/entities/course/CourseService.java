package com.pablobuendia.universitymanager.entities.course;

import com.pablobuendia.universitymanager.error.ElementNotFoundException;
import com.pablobuendia.universitymanager.event.CourseCreatedEvent;
import com.pablobuendia.universitymanager.event.Publisher;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "course-cache")
public class CourseService {

  private final CourseRepository courseRepository;
  private final Publisher publisher;

  public List<CourseDto> getAllCourses() {
    return courseRepository.findAll().stream()
        .map(CourseMapper.INSTANCE::courseToCourseDto)
        .collect(Collectors.toList());
  }

  @Cacheable
  public CourseDto getCourse(Long id) {
    val course = courseRepository.findById(id).orElseThrow(() ->
        new ElementNotFoundException("No such course found with id " + id));
    return CourseMapper.INSTANCE.courseToCourseDto(course);
  }

  public CourseDto addCourse(CourseDto courseDto) {
    val savedCourse = saveCourse(courseDto);

    publishNewCreatedCourse(savedCourse);
    return CourseMapper.INSTANCE.courseToCourseDto(savedCourse);
  }

  private Course saveCourse(CourseDto courseDto) {
    val courseEntity = CourseMapper.INSTANCE.courseDtoToCourse(courseDto);

    return courseRepository.save(courseEntity);
  }

  @CacheEvict
  public void deleteCourse(Long id) {
    courseExists(id);

    courseRepository.deleteById(id);
  }

  @CachePut(key = "#id")
  public CourseDto updateCourse(Long id, CourseDto courseDto) {
    courseExists(id);

    val updatedCourse = courseRepository
        .save(CourseMapper.INSTANCE.courseDtoToCourse(courseDto));
    return CourseMapper.INSTANCE.courseToCourseDto(updatedCourse);
  }

  public CourseDto putCourse(Long id, CourseDto courseDto) {
    courseExists(id);

    val updatedCourse = courseRepository
        .save(CourseMapper.INSTANCE.courseDtoToCourse(courseDto));
    return CourseMapper.INSTANCE.courseToCourseDto(updatedCourse);
  }

  private void courseExists(Long id) {
    if (!courseRepository.existsById(id)) {
      throw new ElementNotFoundException("No such course found with id " + id);
    }
  }

  private void publishNewCreatedCourse(Course course) {
    CourseCreatedEvent newEvent = new CourseCreatedEvent(course.getId(), course.getCreated());

    publisher.publishEvent(newEvent);
  }
}
