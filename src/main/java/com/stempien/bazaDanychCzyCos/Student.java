package com.stempien.bazaDanychCzyCos;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String firstName;
    @Column(nullable = false)
    String lastName;
    @Column(unique = true)
    Integer age;
    Boolean isMale;

    public Student() {
    }

    public Student(String firstName, String lastName, Integer age, Boolean isMale) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMale = isMale;
    }
}
