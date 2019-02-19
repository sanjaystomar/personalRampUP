package org.personal.rampup.designPatterns.structural.decorator;

public abstract class Condiments implements Beverages {

	protected Beverages inBeverages;

	public Condiments(Beverages inBeverages) {
		this.inBeverages = inBeverages;
	}

	public abstract String getDescription();

}
