package org.personal.rampup.designPatterns.structural.decorator.baseProduct;

import org.personal.rampup.designPatterns.structural.decorator.Beverages;

public class HouseBlend implements Beverages {

	@Override
	public String getDescription() {
		return "House Blend";
	}

	@Override
	public double getCost() {
		System.out.println("Cost of House Blend : " + 5.0);
		return 5.0;
	}

}
