package com.example.demo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surName;
    private int age;
    private String telephone;
    @Embedded
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private Index index;
    @ManyToOne
    private University university;
    @ManyToMany
    Set<Classes> classesSet = new HashSet<>();

    public void setUniversity(University university) {
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public Students(String name, String surName, int age, String telephone, Address address, String indeks) {

        this.name = name;
        this.surName = surName;
        this.age = age;
        this.telephone = telephone;
        this.address = address;
        this.index = new Index(indeks);
    }

private Students(){};

    public void  setIndex(Index inx){
        this.index = inx;
    }

    public Index getIndex() {
        return index;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", address=" + address +
                '}';
    }

    public void  addClasses(Classes classes){
        classesSet.add(classes);
    }
}
