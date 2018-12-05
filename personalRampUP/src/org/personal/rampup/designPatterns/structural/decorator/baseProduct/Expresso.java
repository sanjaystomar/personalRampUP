package org.personal.rampup.designPatterns.structural.decorator.baseProduct;

import org.personal.rampup.designPatterns.structural.decorator.Beverages;

public class Expresso implements Beverages{

	@Override
	public String getDescription() {
		return "Expresso";
	}

	@Override
	public double getCost() {
		System.out.println("Cost of Expresso : " + 5.0);
		return 5.0;
	}
}
