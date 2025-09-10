package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nChoose the Operation to perform : ");
            System.out.println("1. Create\n2. Read\n3. Update\n4. Delete\n5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> create();
                case 2 -> read();
                case 3 -> update();
                case 4 -> delete();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Choose only from the given options!");
            }
        } while (choice != 5);

        sc.close();
    }

    private static void create() {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter marks: ");
            int marks = sc.nextInt();

            Student student = new Student();
            student.setName(name);
            student.setMarks(marks);

            session.persist(student);
            transaction.commit();
            System.out.println("✅ Student has been created: " + student.toString());
        }
    }

    private static void read() {
        try (Session session = HibernateUtil.getSession()) {
            System.out.print("Enter id to retrieve details: ");
            int id = sc.nextInt();
            Student s = session.find(Student.class, id);

            if (s != null) {
                System.out.println("✅ Student Found: " + s.toString());
            } else {
                System.out.println("❌ Student not found with the given ID.");
            }
        }
    }

    private static void update() {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            System.out.print("Enter the id to update marks: ");
            int sid = sc.nextInt();
            Student s = session.find(Student.class, sid);

            if (s != null) {
                System.out.print("Enter the new marks: ");
                int newMarks = sc.nextInt();
                s.setMarks(newMarks);
                session.merge(s);
                System.out.println("✅ Marks updated successfully.");
            } else {
                System.out.println("❌ Student not found with the given id.");
            }

            transaction.commit();
        }
    }

    private static void delete() {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            System.out.print("Enter the id to delete: ");
            int d_id = sc.nextInt();
            Student s = session.find(Student.class, d_id);

            if (s != null) {
                session.remove(s);
                System.out.println("✅ Student deleted successfully.");
            } else {
                System.out.println("❌ Student does not exist!");
            }

            transaction.commit();
        }
    }
}
