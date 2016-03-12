package ru.suhorukov.auto;

public class UFO extends FlyCar {
	
	final int index; 

	public UFO(){
		super();
		index = 0;
		int a = 1000;
	}
	
	public UFO(int ind){
		super();
		index = ind;
	}
	
	public void fly(){
//		index = 10;
		System.out.println("Car moves by rocket");
	}
	
	@Override
	public boolean equals(Object obj){
		boolean result = super.equals(obj);
		if (result) {
			if (obj instanceof UFO){
				UFO ufo = (UFO) obj;
				return ufo.index == this.index;
			}
		}
		return result;	
	}
}
