package com.pablobuendia.universitymanager.entities.course;

import java.time.LocalDateTime;
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
import javax.persistence.Version;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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

  @Version
  private Integer version;

  @CreatedDate
  private LocalDateTime created;

  @LastModifiedDate
  private LocalDateTime updated;

  private String name;
  private String degree;
  private Integer credits;
  private Double passingGrade;

  @OneToMany(mappedBy = "parentCourse", fetch = FetchType.LAZY)
  private List<CourseInstance> instances;
}
