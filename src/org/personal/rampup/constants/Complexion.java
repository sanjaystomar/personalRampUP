package org.personal.rampup.constants;

public enum Complexion {
	
	LIGHT_SKIN ("always burn", "never tans"),
	FAIR_SKIN ("usually burns", "tans"),
	MEDIUM_SKIN ("may burn", "tans well"),
	OLIVE_SKIN ("rarely burn", "tans well"),
	TAN_BROWN_SKIN ("rarely burn", "tans well");
	
	private Complexion(String burnBehaviour, String tanBehaviour) {
		this.burns = burnBehaviour;
		this.tans = tanBehaviour;
	}
	
	String burns;
	
	String tans;
	

}
