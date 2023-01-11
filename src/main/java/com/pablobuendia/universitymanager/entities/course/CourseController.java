package com.pablobuendia.universitymanager.entities.course;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "CourseController", description = "Course controller")
public class CourseController {

  private final CourseService courseService;
}
