package com.pablobuendia.universitymanager.address;

import com.pablobuendia.universitymanager.address.city.City;
import com.pablobuendia.universitymanager.commons.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table
public class Address extends BaseEntity {

    @Column(nullable = false)
    private String lineStreet1;

    private String lineStreet2;

    @OneToOne
    @JoinColumn(name = "cityId")
    private City city;
}
