package com.pablobuendia.universitymanager.address.city;

import com.pablobuendia.universitymanager.address.country.Country;
import com.pablobuendia.universitymanager.commons.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table
public class City extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "countryId", nullable = false)
    private Country country;
}
