package org.personal.rampup.model;

/**
 * @author sanja
 * If parent is implementing serializable all childs implicitly are serializable. 
 */
public class Man extends Human {
	
	public Man(boolean hasBeardIn, float bodyMassRatioIn) {
		this.bodyMassRatio = bodyMassRatioIn;
		this.hasBeard = hasBeardIn;
	}

	private static final long serialVersionUID = 2409522178802735972L;
	
	private boolean hasBeard;
	
	private float bodyMassRatio;

	public boolean isHasBeard() {
		return hasBeard;
	}

	public void setHasBeard(boolean hasBeard) {
		this.hasBeard = hasBeard;
	}

	public float getBodyMassRatio() {
		return bodyMassRatio;
	}

	public void setBodyMassRatio(float bodyMassRatio) {
		this.bodyMassRatio = bodyMassRatio;
	}

	@Override
	public String toString() {
		return "Man [hasBeard=" + hasBeard + ", bodyMassRatio=" + bodyMassRatio + "]" + super.toString();
	}
	
	
}
