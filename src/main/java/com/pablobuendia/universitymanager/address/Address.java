package com.pablobuendia.universitymanager.address;

import com.pablobuendia.universitymanager.address.city.City;
import com.pablobuendia.universitymanager.commons.BaseEntity;
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
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String lineStreet1;

    private String lineStreet2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerId", nullable = false)
    private BaseEntity owner;

    @OneToOne
    @JoinColumn(name = "cityId")
    private City city;
}
