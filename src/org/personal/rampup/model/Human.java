package org.personal.rampup.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Human implements Serializable {
	
	public Human() {
		System.out.println("No Args Constructor Executed!!");
	}
	
	public Human(float heightIn, String genderIn, float weightIn, String complexionIn) {
		this.height = heightIn;
		this.gender = genderIn;
		this.weight = weightIn;
		this.complexion = complexionIn;
		System.out.println("Argument Constructor Executed!!");
	}

	private static final long serialVersionUID = 8108375895328347469L;

	private float height;

	private transient String gender;

	private float weight;

	private transient String complexion;

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getComplexion() {
		return complexion;
	}

	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}

	private void writeObject(ObjectOutputStream oos) {
		try {
			System.out.println("Inside writeObject Method!!");
			oos.defaultWriteObject();
			String genderToWrite = "";
			if (gender.equals("TRANSGENDER")) {
				genderToWrite = "UNKNOWN";
			} else if (gender.equals("MALE")) {
				genderToWrite = "MALE";
			} else
				genderToWrite = "FEMALE";
			
			oos.writeObject(genderToWrite);
			oos.writeObject("BLACK");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void readObject(ObjectInputStream ois) {
		try {
			System.out.println("Inside readObject Method!!");
			ois.defaultReadObject();
			gender = (String) ois.readObject();
			complexion = (String) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}
	
	private Object readResolve() {
		System.out.println("Inside readResolve Method!!");
//		return new Human(6, "MALE", 80, "OLIVE_SKIN");
		return new Man(true, 87.6F);
	}
	
	private Object writeReplace() {
		System.out.println("Inside writeReplace Method!!");
		return new Human(6, "MALE", 80, "OLIVE_SKIN");
	}

	@Override
	public String toString() {
		return "Human [height=" + height + ", gender=" + gender + ", weight=" + weight + ", complexion=" + complexion
				+ "]";
	}
	
	

}
