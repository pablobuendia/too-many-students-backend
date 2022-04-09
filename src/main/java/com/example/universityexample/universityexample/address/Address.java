package com.example.universityexample.universityexample.address;

import com.example.universityexample.universityexample.student.Student;
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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String lineStreet1;

    private String lineStreet2;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;
}
