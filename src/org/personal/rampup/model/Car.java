package org.personal.rampup.model;

import java.io.Serializable;

import org.personal.rampup.constants.CarType;

/**
 * @author sanja If parent is not serializable but child is the behaviour is
 *         different. in this scenario while serializing the inherited
 *         attributes has a default values as it doesnot participate in
 *         serialization but for deserialization it follows a INSTANCE CONTROL
 *         FLOW to provide the values for the inherited attributes.
 */
public class Car extends Vehicle implements Serializable {

	public Car(int topSpeedIn, int fuelTankCapacityIn, String chasisMaterialIn) {
		super(234, CarType.LIMOGIN, "Deisel");
		this.topSpeed = topSpeedIn;
		this.fuelTankCapacity = fuelTankCapacityIn;
		this.chasisMaterial = chasisMaterialIn;
	}
	
	public Car() {
		super(234, CarType.LIMOGIN, "Deisel");
//		System.out.println(this.toString());
	}

	private static final long serialVersionUID = 6189101101785492280L;

	private int topSpeed;

	private int fuelTankCapacity;

	private String chasisMaterial;

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}

	public int getFuelTankCapacity() {
		return fuelTankCapacity;
	}

	public void setFuelTankCapacity(int fuelTankCapacity) {
		this.fuelTankCapacity = fuelTankCapacity;
	}

	public String getChasisMaterial() {
		return chasisMaterial;
	}

	public void setChasisMaterial(String chasisMaterial) {
		this.chasisMaterial = chasisMaterial;
	}

	@Override
	public String toString() {
		return "Car [topSpeed=" + topSpeed + ", fuelTankCapacity=" + fuelTankCapacity + ", chasisMaterial="
				+ chasisMaterial + "]" + super.toString();
	}

	// Code for specific implementations

}
