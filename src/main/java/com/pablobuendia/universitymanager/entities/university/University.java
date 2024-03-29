package com.pablobuendia.universitymanager.entities.university;

import com.pablobuendia.universitymanager.entities.address.city.City;
import com.pablobuendia.universitymanager.entities.student.Student;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class University {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "universityGenerator")
  @SequenceGenerator(name = "universityGenerator", sequenceName = "universityGenerator", allocationSize = 10)
  private Long id;

  @Version
  private Integer version;

  @CreatedDate
  private LocalDateTime created;

  @LastModifiedDate
  private LocalDateTime updated;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false)
  private String lineStreet1;

  private String lineStreet2;

  @OneToOne
  @JoinColumn(name = "cityId")
  private City city;

  @OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
  private List<Student> students;

}
