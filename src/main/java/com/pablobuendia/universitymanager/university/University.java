package com.pablobuendia.universitymanager.university;

import com.pablobuendia.universitymanager.commons.BaseEntity;
import com.pablobuendia.universitymanager.address.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class University extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Address> addressList;
}
