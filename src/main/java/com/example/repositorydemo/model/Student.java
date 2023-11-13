package com.example.repositorydemo.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dob;
    private int gender;

    public Student() {
    }

    public Student(Long id, String name, String dob, int gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public int getGender() {
        return gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

}
