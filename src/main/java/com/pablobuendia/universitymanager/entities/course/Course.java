package com.pablobuendia.universitymanager.entities.course;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseGenerator")
  @SequenceGenerator(name = "courseGenerator", sequenceName = "courseGenerator", allocationSize = 10)
  private Long id;

  private String name;
  private String degree;
  private Integer credits;
  private Double passingGrade;

  @OneToMany(mappedBy = "parentCourse", fetch = FetchType.LAZY)
  private List<CourseInstance> instances;
}
