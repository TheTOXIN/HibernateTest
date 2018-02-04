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

        for (Developer dev : developers) {
            System.out.println(dev);
            for (Object obj : dev.getProjects()) {
                Project proj = (Project) obj;
                System.out.println(proj);
            }
            System.out.println();
        }

        transaction.commit();
        session.close();

        return developers;
    }

    public void addDeveloper(Developer developer) {
        Session session = sessionFactory.openSession();
        Transaction transaction;

        transaction = session.beginTransaction();

        Developer dev = developer;
        dev.setProjects(developer.getProjects());
        session.save(dev);

        transaction.commit();
        session.close();
    }

    public void dropTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction;

        transaction = session.beginTransaction();

        session.createSQLQuery("DELETE FROM developers").executeUpdate();
        session.createSQLQuery("DELETE FROM projects").executeUpdate();

        transaction.commit();
        session.close();
    }

    public void addProjects(List<Project> projects) {
        Session session = sessionFactory.openSession();
        Transaction transaction;

        transaction = session.beginTransaction();

        for (Project project : projects) {
            Project proj = project;
            proj.setCompany(project.getCompany());
            session.save(proj);
        }

        transaction.commit();
        session.close();
    }
}
