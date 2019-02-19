package org.personal.rampup.cloning;

public class TestCloneable {
    public static void main(String[] args) {
        Employee e = new Employee("Ram");
        try {
            System.out.println(e.getClone());

        } catch (CloneNotSupportedException e1) {
            e1.printStackTrace();
        }

    }


}


// implements Cloneable {  This will cause the CloneNotSupportedException
class Employee implements Cloneable {

    public Employee(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }

    public Employee getClone() throws CloneNotSupportedException {
        return (Employee) clone();
    }
}
