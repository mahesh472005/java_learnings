package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(org.example.Student.class)
            .configure()
            .buildSessionFactory();
    public static Session getSession()
    {
        return sessionFactory.openSession();
    }
}
