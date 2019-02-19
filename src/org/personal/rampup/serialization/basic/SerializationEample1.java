package org.personal.rampup.serialization.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.personal.rampup.model.Human;

public class SerializationEample1 {
	
	protected String fun = "sanjay";

	public static void main(String[] args) {

		Human h1 = new Human();
		h1.setHeight(8);
		h1.setWeight(70);
		h1.setComplexion("TAN_BROWN");
		h1.setGender("MALE");

		System.out.println("Human before the Serialization: " + h1.toString());

		// Serialization
		try (FileOutputStream fos = new FileOutputStream("human.ser.txt")) {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(h1);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Deserialization

		try (FileInputStream fis = new FileInputStream("human.ser.txt")) {
			ObjectInputStream ois = new ObjectInputStream(fis);
			Human h2 = (Human) ois.readObject();
			System.out.println("Human after the Deserialization: " + h2.toString());
			ois.close();
		} catch (FileNotFoundException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
