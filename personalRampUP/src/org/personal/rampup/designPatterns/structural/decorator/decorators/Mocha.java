package org.personal.rampup.designPatterns.structural.decorator.decorators;

import org.personal.rampup.designPatterns.structural.decorator.Beverages;
import org.personal.rampup.designPatterns.structural.decorator.Condiments;

public class Mocha extends Condiments {

	public Mocha(Beverages inBeverages) {
		super(inBeverages);
//		System.out.println(" Adding Mocha");
	}

	@Override
	public String getDescription() {
		System.out.println(" : adding Mocha");
		return inBeverages.getDescription() + ", Mocha ";
	}

	@Override
	public double getCost() {
		return inBeverages.getCost() + 1.5;
	}
	
	

}
