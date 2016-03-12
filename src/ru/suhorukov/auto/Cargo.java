package ru.suhorukov.auto;
public class Cargo extends Automobile {

	boolean hasAdditionalVehicle = false;
	long maxPossibleWeight = 0;
	String destinationName = null; 
	
	public static final int MAX_WEIGHT = 10000; //kg
	
	public Cargo(){
		super(120, 40, 3);
		super.engine = new Engine(5, 500, 150);
	}
	
	public boolean isHasAdditionalVehicle() {
		return hasAdditionalVehicle;
	}
	public void setHasAdditionalVehicle(boolean hasAdditionalVehicle) {
		this.hasAdditionalVehicle = hasAdditionalVehicle;
	}
	public long getMaxPossibleWeight() {
		return maxPossibleWeight;
	}
	public void setMaxPossibleWeight(long maxPossibleWeight) {
		this.maxPossibleWeight = maxPossibleWeight;
	}
	public void move(){
		System.out.println("Car moves by wheels");
	}
	
	public static String cargo2String(Cargo c){
		return c.toString();
	}
}
