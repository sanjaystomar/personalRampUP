package org.personal.rampup.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.personal.rampup.model.EmployeeModel;

public class ExternalizableExampleWrite {

	public static void main(String[] args) {
		EmployeeModel em = new EmployeeModel("Sanjay", 31, "Software Engineering", "SAL2");
		System.out.println(em.toString());
		try(FileOutputStream fos = new FileOutputStream("ExternalizableExmp.ser.txt")){
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(em);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(FileInputStream fis = new FileInputStream("ExternalizableExmp.ser.txt")){
			ObjectInputStream oos = new ObjectInputStream(fis);
			EmployeeModel em2 = (EmployeeModel)oos.readObject();
			System.out.println(em2.toString());
		} catch (FileNotFoundException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
