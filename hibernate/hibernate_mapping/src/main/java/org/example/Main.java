package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        //Implementation of One to One Mapping
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Rog");

        Developer d1 = new Developer();
        d1.setId(101);
        d1.setName("John wick");
        d1.setLaptop(l1);

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(l1);
        session.persist(d1);
        transaction.commit();
        session.close();

    }

}