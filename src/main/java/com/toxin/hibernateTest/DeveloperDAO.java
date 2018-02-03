package com.toxin.hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeveloperDAO {
    private static SessionFactory sessionFactory =
            new Configuration().configure().buildSessionFactory();


    public void removeDeveloper(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction;

        transaction = session.beginTransaction();

        Developer developer = session.get(Developer.class, id);
        session.delete(developer);

        transaction.commit();
        session.close();
    }

    public void updateDeveloper(int id, int salary) {
        Session session = sessionFactory.openSession();
        Transaction transaction;

        transaction = session.beginTransaction();

        Developer developer = session.get(Developer.class, id);
        developer.setSalary(salary);
        session.update(developer);

        transaction.commit();
        session.close();
    }

    public List<Developer> listDevelopers() {
        Session session = sessionFactory.openSession();
        Transaction transaction;

        transaction = session.beginTransaction();

        List<Developer> developers= session.createQuery("FROM Developer").list();

        transaction.commit();
        session.close();

        return developers;
    }

    public void addDeveloper(String firstName, String lastName, String specialty, int salary) {
        Session session = sessionFactory.openSession();
        Transaction transaction;

        transaction = session.beginTransaction();

        Developer developer = new Developer(firstName, lastName, specialty, salary);
        session.save(developer);

        transaction.commit();
        session.close();
    }

    public void dropTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction;

        transaction = session.beginTransaction();

        session.createSQLQuery("DELETE FROM developers").executeUpdate();

        transaction.commit();
        session.close();
    }
}
