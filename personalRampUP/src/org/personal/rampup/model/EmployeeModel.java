package org.personal.rampup.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class EmployeeModel implements Externalizable {
	
	public EmployeeModel () {
		System.out.println("Executing Default Constructor!!");
	}
	
	public EmployeeModel(String name, int age, String department, String designation) {
		super();
		this.name = name;
		this.age = age;
		this.department = department;
		this.designation = designation;
	}

	private static final long serialVersionUID = 7L; 

	private String name;

	private int age;

	private String department;

	private String designation;

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "EmployeeModel [name=" + name + ", age=" + age + ", department=" + department  + ", designation=" + designation + "]";
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(designation);
		out.writeInt(age);
		out.writeObject(name);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		designation = (String)in.readObject();
		age = in.readInt();
		name = (String)in.readObject();
	}
	
	private Object readResolve() {
		setDesignation("SAL1");
		return this;
	}
	

}
