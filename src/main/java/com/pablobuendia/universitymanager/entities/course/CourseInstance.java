package com.pablobuendia.universitymanager.entities.course;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table
@Getter
@Setter
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CourseInstance {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseInstanceGenerator")
  @SequenceGenerator(name = "courseInstanceGenerator", sequenceName = "courseInstanceGenerator", allocationSize = 10)
  private Long id;
  private String professorName;
  private LocalDate year;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "courseId")
  private Course parentCourse;
}
