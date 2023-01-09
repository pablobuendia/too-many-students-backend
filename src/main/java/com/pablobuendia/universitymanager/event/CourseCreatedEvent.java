package com.pablobuendia.universitymanager.event;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(fluent = true)
@Getter
public class CourseCreatedEvent {

  private Long name;
  private LocalDateTime updated;
}
