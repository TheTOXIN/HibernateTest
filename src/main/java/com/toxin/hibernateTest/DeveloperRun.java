package com.toxin.hibernateTest;

import java.util.Arrays;
import java.util.List;

public class DeveloperRun {

    public static void main(String[] args) {
        System.out.println("HIBERNATE_TEST");

        DeveloperDAO dao = new DeveloperDAO();

        dao.dropTable();//WARING!!!

        List<Project> projects1 = Arrays.asList(
                new Project("CChat", "Toxin"),
                new Project("WFM", "OptiSystems")
        );

        List<Project> projects2 = Arrays.asList(
                new Project("Graph", "Kostya"),
                new Project("Shedules", "Bublich")
        );

        System.out.println("Adding developers records to the DB");
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
