package com.example.universityexample.universityexample.student;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class Student {

    @Id
    private String id;
    private String name;
    private String lastName;

}
