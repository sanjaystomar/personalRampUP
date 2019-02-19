package org.personal.rampup.designPatterns.structural.decorator;

import org.personal.rampup.designPatterns.structural.decorator.baseProduct.Decaf;
import org.personal.rampup.designPatterns.structural.decorator.baseProduct.Expresso;
import org.personal.rampup.designPatterns.structural.decorator.decorators.Latte;
import org.personal.rampup.designPatterns.structural.decorator.decorators.Mocha;

public class PrepareCoffe {

	public static void main(String[] args) {
		Beverages decafWithLatteDoubleMocha = new Decaf();
		decafWithLatteDoubleMocha = new Latte(decafWithLatteDoubleMocha);
		decafWithLatteDoubleMocha = new Mocha(new Mocha(decafWithLatteDoubleMocha));
		System.out.println("Final Cost for the " + decafWithLatteDoubleMocha.getDescription() + " : "
				+ decafWithLatteDoubleMocha.getCost() + " $");

		System.out.println("####################################################");
		Beverages expressoMocha = new Expresso();
		expressoMocha = new Mocha(expressoMocha);
		System.out.println(
				"Final Cost for the " + expressoMocha.getDescription() + " : " + expressoMocha.getCost() + " $");

	}

}
