package org.personal.rampup.customloaded;

public class GinnyPig {
private String name = "sanjay";

private int age = 31;

public String getName() {
        return name;
        }

public void setName(String name) {
        this.name = name;
        }

public int getAge() {
        return age;
        }

public void setAge(int age) {
        this.age = age;
        }

@Override
public String toString() {
        return "GinnyPig{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
        }
        }

