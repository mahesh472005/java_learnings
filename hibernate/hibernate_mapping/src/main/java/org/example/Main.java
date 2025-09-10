package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Implementation of One to Many & Many To One Mapping
        Developer d2 = new Developer();
        Laptop l2 = new Laptop();
        Laptop l3 = new Laptop();

        l2.setLid(1);
        l2.setBrand("Asus");
        l2.setModel("Rog");
        l2.setDeveloper(d2);

        l3.setLid(2);
        l3.setBrand("Dell");
        l3.setModel("XPS");
        l3.setDeveloper(d2);

        d2.setId(102);
        d2.setName("Ballerina");
        d2.setLaptop(Arrays.asList(l2,l3));

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(l2);
        session.persist(l3);
        session.persist(d2);
        transaction.commit();

    }

}