package com.pablobuendia.universitymanager.university;

import com.pablobuendia.universitymanager.address.city.City;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "universityGenerator")
    @SequenceGenerator(name = "universityGenerator", sequenceName = "UNIVERSITY_GENERATOR", allocationSize = 10)
    private Long id;

    @Version
    private Integer version;

    @CreatedDate
    private ZonedDateTime created;

    @LastModifiedDate
    private ZonedDateTime updated;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String lineStreet1;

    private String lineStreet2;

    @OneToOne
    @JoinColumn(name = "cityId")
    private City city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        University that = (University) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
