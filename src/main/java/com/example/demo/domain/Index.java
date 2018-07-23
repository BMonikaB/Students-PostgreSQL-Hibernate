package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Index {

    @Id
    private int id;
    private String numerOfIndex;

    @OneToOne(mappedBy = "index")
    private Students students;

    Index(String numerOfIndex){
        this.numerOfIndex = numerOfIndex;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    private Index(){

    }

    public Index(int id, String numerOfIndex) {
        this.id = id;
        this.numerOfIndex = numerOfIndex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumerOfIndex() {
        return numerOfIndex;
    }

    public void setNumerOfIndex(String numerOfIndex) {
        this.numerOfIndex = numerOfIndex;
    }

    @Override
    public String toString() {
        return "Index{" +
                "id=" + id +
                ", numerOfIndex='" + numerOfIndex + '\'' +
                '}';
    }
}
