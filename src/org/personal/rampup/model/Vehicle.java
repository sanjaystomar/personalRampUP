package org.personal.rampup.model;

import org.personal.rampup.constants.CarType;

public class Vehicle {
	public Vehicle() {
		System.out.println("Default constructor called!!");
	}
	
	public Vehicle(int horsePowerIn, CarType carType, String engineTypeIn) {
		System.out.println("Argumented constructor called!!");
	}

	private int horsePower = 200;

	private CarType carType;

	private String engineType = "Deisel";

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	@Override
	public String toString() {
		return "Vehicle [horsePower=" + horsePower + ", carType=" + carType + ", engineType=" + engineType + "]";
	}

}

