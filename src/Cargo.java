
public class Cargo extends Automobile {

	boolean hasAdditionalVehicle = false;
	long maxPossibleWeight = 0;
	String destinationName = null; 
	
	public Cargo(){
		super(120, 40, 3);
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
}
