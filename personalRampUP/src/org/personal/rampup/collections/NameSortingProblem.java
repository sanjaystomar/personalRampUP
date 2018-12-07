package org.personal.rampup.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NameSortingProblem {
    public static void main(String args[]) {
        List<NamedEmployee> namedEmployeeList = new ArrayList<>();
        namedEmployeeList.add(new NamedEmployee("sanjay", "tomar"));
        namedEmployeeList.add(new NamedEmployee("rakesh", "katkam"));
        namedEmployeeList.add(new NamedEmployee("ravi", "singh"));
        namedEmployeeList.add(new NamedEmployee("santosh", ""));
        namedEmployeeList.add(new NamedEmployee("abhinav", "pandey"));
        namedEmployeeList.add(new NamedEmployee("abhinav", ""));
        namedEmployeeList.add(new NamedEmployee("benjamin", "zuleski"));
        namedEmployeeList.add(new NamedEmployee("shubham", "Agarwal"));
        namedEmployeeList.add(new NamedEmployee("shubham", ""));
        namedEmployeeList.add(new NamedEmployee("zullool", "ansari"));

        /*  Normal Lambda and stream usage!!
        namedEmployeeList
                .stream()
                .sorted((e1, e2) -> e1.getLastName().compareTo(e2.getLastName()))
                .forEach(System.out::println);
        */

//      Using custom comparator.
//      Collections.sort(namedEmployeeList, new NameComparator());

        /*  Using Collections.sort and providing comparator using Lambda.*/
        Collections.sort(namedEmployeeList, (e1, e2) -> {

            if (!e1.getLastName().isEmpty() && !e2.getLastName().isEmpty()) {
                return e1.getLastName().compareTo(e2.getLastName());
            } else if (!e1.getLastName().isEmpty()) {
                return -1;
            } else if (!e2.getLastName().isEmpty()) {
                return +1;
            } else {
                return e2.getFirstName().compareTo(e1.getFirstName());
            }
        });

        namedEmployeeList
                .stream()
                .forEach(System.out::println);
    }
}

class NamedEmployee {
    private String firstName = "";

    private String lastName = "";

    public NamedEmployee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "NamedEmployee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

class NameComparator implements Comparator<NamedEmployee> {

    @Override
    public int compare(NamedEmployee e1, NamedEmployee e2) {
        int count = 0;
        if (!e1.getLastName().isEmpty() && !e2.getLastName().isEmpty()) {
            return e1.getLastName().compareTo(e2.getLastName());
        } else if (!e1.getLastName().isEmpty() && e2.getLastName().isEmpty()) {
            return -1;
        } else if (!e2.getLastName().isEmpty() && e1.getLastName().isEmpty()) {
            return 1;
        } else {
            return e1.getFirstName().compareTo(e2.getFirstName());
        }
    }

}
