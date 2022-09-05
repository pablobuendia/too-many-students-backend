package com.pablobuendia.universitymanager.address.city;

import com.pablobuendia.universitymanager.address.country.Country;
import com.pablobuendia.universitymanager.commons.BaseEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class City extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "countryId", nullable = false)
    private Country country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        City city = (City) o;
        return getId() != null && Objects.equals(getId(), city.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
