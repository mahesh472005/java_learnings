package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Implementation of Many to Many Mapping
        Developer d1 = new Developer();
        Developer d2 = new Developer();
        Developer d3 = new Developer();


        Laptop l1 = new Laptop();
        Laptop l2 = new Laptop();
        Laptop l3 = new Laptop();


        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setDeveloper(Arrays.asList(d1,d2));

        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setDeveloper(Arrays.asList(d2,d3));

        l3.setLid(3);
        l3.setBrand("Asus");
        l3.setModel("Strix");
        l3.setDeveloper(Arrays.asList(d1));

        d1.setId(101);
        d1.setName("John wick");
        d1.setLaptop(Arrays.asList(l1,l3));

        d2.setId(102);
        d2.setName("Ballerina");
        d2.setLaptop(Arrays.asList(l1,l2));

        d3.setId(103);
        d3.setName("Heisenberg");
        d3.setLaptop(Arrays.asList(l2));

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(d1);
        session.persist(d2);
        session.persist(d3);
        transaction.commit();

        session.close();

    }

}