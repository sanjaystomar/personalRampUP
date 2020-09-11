package org.personal.rampup.BacchaInterviewRounds;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JustTesting {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Sanjay", 20000l, 34));
        employeeList.add(new Employee(2, "Somduti", 40000l, 28));
        employeeList.add(new Employee(3, "Abhisehk", 2220000l, 38));
        employeeList.add(new Employee(4, "Deepesh", 220000l, 29));
        employeeList.add(new Employee(5, "Suraj", 50000l, 29));
        employeeList.add(new Employee(6, "Baccha", 70000l, 22));
        employeeList.add(new Employee(7, "Baccha", 7000l, 22));

//        System.out.println(employeeList.get(3).equals(employeeList.get(4)));
//        System.out.println(employeeList.get(5).equals(employeeList.get(6)));

        Collections.sort(employeeList, (e1,e2)-> e1.compareTo(e2));
        List<Student> studentList = getStudentList();
        Collections.sort(studentList, (s1, s2)-> s2.getStudentName().compareTo(s1.getStudentName()));

        System.out.println(studentList);

    }

    public static List<Student> getStudentList(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"Ramu"));
        studentList.add(new Student(2,"Shyam"));
        return studentList;
    }

}

@Data
@AllArgsConstructor
class Student{
    private  int studentId;
    private String studentName;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Employee implements Comparable<Employee> {
    private int employeeId;
    private String employeeName;
    private Long salary;
    private int age;

    @Override
    public int compareTo(Employee o) {
        return this.employeeName.compareTo(o.employeeName);
    }

    @Override
    public boolean equals(Object obj) {
        Employee emp = (Employee) obj;
        if (this.age != emp.age) return false;
        if (!this.employeeName.equals(emp.employeeName)) return false;
        return true;
    }
}