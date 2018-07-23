package com.example.demo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import  java.util.Set;

@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "university")
    private Set<Students> studentsSet = new HashSet<>();
    @OneToMany(mappedBy = "university")
    private Set<Teacher> teacherSet = new HashSet<>();

    private University(){};


    public void addStudents(Students students){
        studentsSet.add(students);
    }
    public void addTeacher(Teacher teacher){
        teacherSet.add(teacher);
    }


    public University(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Students> printList(){
        return studentsSet;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentsSet=" + studentsSet +
                ", teacherSet=" + teacherSet +
                '}';
    }
}
