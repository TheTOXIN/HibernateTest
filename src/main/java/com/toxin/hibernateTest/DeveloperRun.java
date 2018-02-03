package com.toxin.hibernateTest;

import java.util.List;

public class DeveloperRun {

    public static void main(String[] args) {
        System.out.println("HIBERNATE_TEST");

        DeveloperDAO dao = new DeveloperDAO();

        dao.dropTable();//WARING!!!

        System.out.println("Adding developers records to the DB");
        dao.addDeveloper("Yuri", "Belousov", "Java", 1000000);
        dao.addDeveloper("Vlad", "Alibastrov", "HTML", 100500);
        dao.addDeveloper("Kostya", "Popaschgin", "GUMNO", 228);
        dao.addDeveloper("TEST", "TEST", "TEST", 0);
        System.out.println("==============================\n");

        System.out.println("List of developers");
        List<Developer> developers = dao.listDevelopers();
        for (Developer developer : developers) {
            System.out.println(developer);
        }
        System.out.println("==============================\n");

        System.out.println("Removing and update TEST developer");
        dao.removeDeveloper(4);
        dao.updateDeveloper(3, 0);
        System.out.println("==============================\n");

        System.out.println("RESULT List of developers");
        developers = dao.listDevelopers();
        for (Developer developer : developers) {
            System.out.println(developer);
        }
        System.out.println("==============================\n");
    }
}
