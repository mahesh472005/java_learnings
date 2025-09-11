package org.example;

/*
TO IMPLEMENT THE LEVEL 2 CACHE OF HIBERNATE FOLLOW THESE STEPS :
1. ADD THE J_CACHE, EhCACHE, AND DEPENDENCY MANAGEMENT IN POM.XML
2. USE @Cacheable ANNOTATION FOR STUDENT CLASS
*/
import org.hibernate.Session;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Session session1 = HibernateUtil.getSession();
        Student s1 = session1.find(Student.class, 2);
        System.out.println(s1);
        session1.close();


        Session session2 = HibernateUtil.getSession();
        Student s2 = session2.find(Student.class, 2);
        System.out.println(s2);
        session2.close();
    }
}
