package org.personal.rampup.designPatterns.structural.decorator.baseProduct;

import org.personal.rampup.designPatterns.structural.decorator.Beverages;

public class Decaf implements Beverages{

	@Override
	public String getDescription() {
		return "Decaf";
	}

	@Override
	public double getCost() {
		System.out.println("Cost of decaf : " + 4.5);
		return 4.5;
	}
}
