package ru.suhorukov.auto;

public class Car extends Automobile {

	int passengerCount;

	public Car(){
		super(180, 60, 1.5);
		this.passengerCount = 4;
		super.engine = new Engine(1.6, 150, 250);
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
	
	@Override
	public String toString(){
		String result = "";
		result += "[";
		result += "MaxVelocity = " + getMaxVelocity();
		result += ", Speed = " + getSpeed();
		result += ", Height = " + getHeight();
		result += ", Mark = " + (getMark() == null ? "Не определена" : getMark()); // "null"
		result += ", PassengerCount = " + getPassengerCount();
		result += "]";
				
		return result;	
	}
}