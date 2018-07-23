package com.example.demo.domain;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surName;
    private String academicTitle;
    private String telephone;
    @Embedded
    private Address address;
    @ManyToOne
    University university;

    public void setUniversity(University university) {
        this.university = university;
    }

    private Teacher(){};


    public Teacher(String name, String surName, String academicTitle, String telephone, Address address) {
        this.name = name;
        this.surName = surName;
        this.academicTitle = academicTitle;
        this.telephone = telephone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", academicTitle='" + academicTitle + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address=" + address +
                '}';
    }
}
