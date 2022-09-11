package com.pablobuendia.universitymanager.entities.student;

import com.pablobuendia.universitymanager.entities.university.University;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentGenerator")
  @SequenceGenerator(name = "studentGenerator", sequenceName = "studentGenerator", allocationSize = 10)
  private Long id;

  @Version
  private Integer version;

  @CreatedDate
  private LocalDateTime created;

  @LastModifiedDate
  private LocalDateTime updated;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @Column(nullable = false)
  private String documentType;

  @Column(nullable = false)
  private String documentNumber;

  @ManyToOne
  @JoinColumn(name = "universityId")
  private University university;

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
          return false;
      }
    Student student = (Student) o;
    return id != null && Objects.equals(id, student.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
