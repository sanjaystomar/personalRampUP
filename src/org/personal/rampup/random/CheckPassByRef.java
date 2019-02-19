package org.personal.rampup.random;

public class CheckPassByRef {

	
	
	public static void main(String[] args) {
		CheckPassByRef checkPassByRef = new CheckPassByRef();
		Model model = new Model("Sanjay", 10);
		System.out.println(model.toString());
		checkPassByRef.changeValue(model);
		int i =10;
		System.out.println(i + "###########");
		checkPassByRef.changePrimitiveValue(i);
		System.out.println(i + "###########");
		System.out.println(model.toString());
	}
	
	public void changeValue(Model model) {
		model.modelName = "RAM";
		System.out.println("Change values called!!");
	}
	
	public void changePrimitiveValue(int i) {
		i++;
	}
	
	

}

class Model{
	
	public Model(String modelNameIn, int quantityIn) {
		this.modelName = modelNameIn;
		this.quantity = quantityIn;
	}
	public String modelName;
	
	public int quantity;

	@Override
	public String toString() {
		return "Model [modelName=" + modelName + ", quantity=" + quantity + "]";
	}
	
}
