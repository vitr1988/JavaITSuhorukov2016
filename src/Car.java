
public class Car extends Automobile {

	int passengerCount;

	public Car(){
		super(180, 60, 1.5);
		this.passengerCount = 4;
	}
	
	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
	
	@Override
	public void setHeight(double height){
		if (height > 4){
			passengerCount += 5;
		}
		super.setHeight(height);
	}
	
	public void move(){
		System.out.println("Car moves by wheels");
	}
}