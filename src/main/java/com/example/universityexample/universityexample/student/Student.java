package com.example.universityexample.universityexample.student;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@AllArgsConstructor
public class Student {

    @Id
    private String id;
    private String name;
    private String lastName;

}
