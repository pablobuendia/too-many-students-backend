package com.example.universityexample.universityexample.address.city;

import com.example.universityexample.universityexample.BaseEntity;
import com.example.universityexample.universityexample.address.country.Country;
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
