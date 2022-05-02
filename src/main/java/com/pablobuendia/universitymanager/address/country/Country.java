package com.pablobuendia.universitymanager.address.country;

import com.pablobuendia.universitymanager.commons.BaseEntity;
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
