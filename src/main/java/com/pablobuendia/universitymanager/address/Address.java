package com.pablobuendia.universitymanager.address;

import com.pablobuendia.universitymanager.address.city.City;
import com.pablobuendia.universitymanager.student.Student;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressGenerator")
    @SequenceGenerator(name = "addressGenerator", sequenceName = "ADDRESS_GENERATOR", allocationSize = 10)
    private Long id;

    @Column(nullable = false)
    private String lineStreet1;

    private String lineStreet2;

    @OneToOne
    @JoinColumn(name = "cityId")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    // Orphan removal guarantees that when the father entity gets deleted, so will happen with this one
    private Student studentOwner;

    @Version
    private Integer version;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Address address = (Address) o;
        return getId() != null && Objects.equals(getId(), address.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
