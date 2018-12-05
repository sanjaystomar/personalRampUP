package org.personal.rampup.model;

public class GenericEmployee {

    private String name;

    private String designation;

    private int age;

    public GenericEmployee() {
    }

    public GenericEmployee(String name, String designation, int age) {
        this.name = name;
        this.designation = designation;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "GenericEmployee{" +
                "name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", age=" + age +
                '}';
    }
}
