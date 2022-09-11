package com.pablobuendia.universitymanager.entities.address.city;

import com.pablobuendia.universitymanager.entities.address.country.Country;
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


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cityGenerator")
  @SequenceGenerator(name = "cityGenerator", sequenceName = "cityGenerator", allocationSize = 10)
  private Long id;

  @Version
  private Integer version;

  @CreatedDate
  private LocalDateTime created;

  @LastModifiedDate
  private LocalDateTime updated;

  @Column(nullable = false, unique = true)
  private String name;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "countryId", nullable = false)
  private Country country;

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
          return false;
      }
    City city = (City) o;
    return getId() != null && Objects.equals(getId(), city.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
