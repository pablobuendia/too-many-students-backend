package com.pablobuendia.universitymanager.entities.address.country;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table
@ToString
@RequiredArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countryGenerator")
  @SequenceGenerator(name = "countryGenerator", sequenceName = "countryGenerator", allocationSize = 10)
  private Long id;

  @Version
  private Integer version;

  @CreatedDate
  private LocalDateTime created;

  @LastModifiedDate
  private LocalDateTime updated;

  @Column(nullable = false, unique = true)
  private String name;

}
