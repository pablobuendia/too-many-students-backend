package com.example.universityexample.universityexample.address.country;

import com.example.universityexample.universityexample.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Country extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;
}
