package org.personal.rampup.serialization.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.personal.rampup.model.Car;


public class SerializationExample2 {

	public static void main(String[] args) {
		
		try (FileOutputStream fos = new FileOutputStream("vehicle.ser.txt")) {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Car car1 = new Car(400, 40, "Metal Alloy");
			oos.writeObject(car1);
			System.out.println("Before Serialization : " + car1.toString());
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(FileInputStream fis = new FileInputStream("vehicle.ser.txt")){
			ObjectInputStream ois = new ObjectInputStream(fis);
			System.out.println("Just before readObject");
			Car  car2 = (Car)ois.readObject();
			ois.close();
			System.out.println("After Deserialization : " + car2.toString());
		} catch (FileNotFoundException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
