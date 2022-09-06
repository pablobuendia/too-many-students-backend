package com.pablobuendia.universitymanager.address.country;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countryGenerator")
    @SequenceGenerator(name = "countryGenerator", sequenceName = "COUNTRY_GENERATOR", allocationSize = 10)
    private Long id;

    @Version
    private Integer version;

    @CreatedDate
    private ZonedDateTime created;

    @LastModifiedDate
    private ZonedDateTime updated;

    @Column(nullable = false, unique = true)
    private String name;
}
