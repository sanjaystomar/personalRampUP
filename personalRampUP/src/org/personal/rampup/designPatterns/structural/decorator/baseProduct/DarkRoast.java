package org.personal.rampup.designPatterns.structural.decorator.baseProduct;

import org.personal.rampup.designPatterns.structural.decorator.Beverages;

public class DarkRoast implements Beverages{

	@Override
	public String getDescription() {
		return "Dark ROAST";
	}

	@Override
	public double getCost() {
		System.out.println("Cost of Dark Roast : " + 4.0);
		return 4.0;
	}

}
