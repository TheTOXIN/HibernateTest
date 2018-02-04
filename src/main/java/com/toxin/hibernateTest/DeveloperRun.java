package com.toxin.hibernateTest;

import java.util.Arrays;
import java.util.List;

public class DeveloperRun {

    public static void main(String[] args) {
        System.out.println("HIBERNATE_TEST");

        DeveloperDAO dao = new DeveloperDAO();

        dao.dropTable();//WARING!!!

        Company company1 = new Company("OptiSystems");
        Company company2 = new Company("Toxin");

        List<Project> projects1 = Arrays.asList(
                new Project("CChat", company1),
                new Project("WFM", company1)
        );

        List<Project> projects2 = Arrays.asList(
                new Project("Graph", company2),
                new Project("Shedules", company2)
        );

        System.out.println("Adding developers records to the DB");
        dao.addProjects(projects1);
        dao.addProjects(projects2);
        dao.addDeveloper(new Developer("Yuri", "Belousov", "Java", 1000000, projects1));
        dao.addDeveloper(new Developer("Vlad", "Alibastrov", "HTML", 100500, projects2));
        dao.addDeveloper(new Developer("Kostya", "Popaschgin", "GUMNO", 228));
        dao.addDeveloper(new Developer("TEST", "TEST", "TEST", 0));
        System.out.println("==============================\n");

        List<Developer> developers = dao.listDevelopers();

        System.out.println("Removing and update TEST developer");
        //dao.removeDeveloper(4);
        //dao.updateDeveloper(3, 0);
        System.out.println("==============================\n");

    }
}
