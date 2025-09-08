package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student obj = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name : ");
        String name = sc.nextLine();

        System.out.print("Enter marks : ");
        int marks = sc.nextInt();
        obj.setName(name); obj.setMarks(marks);

        SessionFactory sf = new Configuration().addAnnotatedClass(org.example.Student.class).configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(obj);
        transaction.commit();
        System.out.println("Row has been created");
        sf.close();
    }
}