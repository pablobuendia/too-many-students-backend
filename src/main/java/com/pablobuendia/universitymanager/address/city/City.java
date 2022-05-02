package com.pablobuendia.universitymanager.address.city;

import com.pablobuendia.universitymanager.commons.BaseEntity;
import com.pablobuendia.universitymanager.address.country.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class City extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "countryId", nullable = false)
    private Country country;
}
