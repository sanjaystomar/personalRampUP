package org.personal.rampup.designPatterns.structural.decorator.decorators;

import org.personal.rampup.designPatterns.structural.decorator.Beverages;
import org.personal.rampup.designPatterns.structural.decorator.Condiments;

public class Latte extends Condiments {

	public Latte(Beverages inBeverages) {
		super(inBeverages);
//		System.out.println("Adding Latte");
	}

	@Override
	public String getDescription() {
		System.out.println(" : adding latte");
		return inBeverages.getDescription() + ", latte";
	}

	@Override
	public double getCost() {
		return inBeverages.getCost() + 1.0;
	}

}
