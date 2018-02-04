package com.toxin.hibernateTest;

import java.util.List;

public class Developer {

    private int id;

    private String firstName;

    private String lastName;

    private String specialty;

    private int salary;

    private List projects;

    public Developer() {

    }

    public Developer(String firstName, String lastName, String specialty, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.salary = salary;
    }

    public Developer(String firstName, String lastName, String specialty, int salary, List projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.salary = salary;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List getProjects() {
        return projects;
    }

    public void setProjects(List projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", salary=" + salary +
                '}';
    }
}
