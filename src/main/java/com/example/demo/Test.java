package com.example.demo;

import com.example.demo.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {


    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AplikacjaPostgreSQL");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

        entityManager.getTransaction().begin();
       Students ania = entityManager.merge(new Students("Anna","Kot",18,"9379473984",new Address("Polska","58-999","Wrocław","Jakas","67/7"),"973784"));

        University pwr = entityManager.merge(new University("Pwr"));
        Teacher teacher = entityManager.merge(new Teacher("Adam","Nowak","Doctor","8783787",new Address("Polska","58-999","Wrocław","Jakas","67/7")));
        Classes mathematic = entityManager.merge(new Classes("mathematic"));

       ania.setUniversity(pwr);
        ania.addClasses(mathematic);
        teacher.setUniversity(pwr);

       mathematic.addStudents(ania);

        pwr.addTeacher(teacher);
        pwr.addStudents(ania);

        entityManager.merge(ania);
        entityManager.merge(pwr);
        entityManager.merge(teacher);
        entityManager.merge(mathematic);

        entityManager.getTransaction().commit();

        University university = entityManager.find(University.class, pwr.getId());
        System.out.println(university);


    }


}
