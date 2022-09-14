package com.pablobuendia.universitymanager.entities.address;

import com.pablobuendia.universitymanager.entities.address.city.City;
import com.pablobuendia.universitymanager.entities.student.Student;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressGenerator")
  @SequenceGenerator(name = "addressGenerator", sequenceName = "addressGenerator", allocationSize = 10)
  private Long id;

  @Column(nullable = false)
  private String lineStreet1;

  private String lineStreet2;

  @OneToOne
  @JoinColumn(name = "cityId")
  private City city;

  @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
  @ToString.Exclude
  // Orphan removal guarantees that when the father entity gets deleted, so will happen with this one
  private Student studentOwner;

  @Version
  private Integer version;

  @CreatedDate
  private LocalDateTime created;

  @LastModifiedDate
  private LocalDateTime updated;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Address address = (Address) o;
    return getId() != null && Objects.equals(getId(), address.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
