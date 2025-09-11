package org.example;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        // Query 1: Retrieve all Students
        Query query1 = session.createQuery("FROM Student", Student.class);
        List<String> result1 = query1.getResultList();
        System.out.println(result1);

        // Query 2: Retrieve specific Student by ID
        System.out.print("Enter the ID to retrieve data: ");
        int id = sc.nextInt();

        Query query2 = session.createQuery("SELECT s.name, s.marks FROM Student s WHERE s.id = ?1");
        query2.setParameter(1, id);
        List<Object[]> result2 = query2.getResultList();

        for (Object[] row : result2) {
            System.out.println("Name: " + row[0] + ", Marks: " + row[1]);
        }

        // Query 3: Group Students by Marks
        Query query3 = session.createQuery("SELECT s.marks, COUNT(s.marks) FROM Student s GROUP BY s.marks");
        List<Object[]> result3 = query3.getResultList();

        System.out.println("\nMarks   Count of Students");
        for (Object[] row : result3) {
            System.out.println(row[0] + "       " + row[1]);
        }

        transaction.commit();
        session.close();
    }
}
