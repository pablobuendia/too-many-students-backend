package com.pablobuendia.universitymanager.university;

import com.pablobuendia.universitymanager.address.Address;
import com.pablobuendia.universitymanager.commons.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@EqualsAndHashCode(callSuper = false)
@Data
public class University extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addressList;
}
