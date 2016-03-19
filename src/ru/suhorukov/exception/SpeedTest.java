package ru.suhorukov.exception;

public class SpeedTest {

	public static void main(String[] args) {
		int speed1 = 190, speed2 = 200, speed3 = 250, speed4 = 100;
//		throw new SpeedExceedException(speed1);
//		throw new SpeedExceedException(speed2);
//		throw new SpeedExceedException(speed3);
		
		try {
			throw new SpeedExceedException(speed4);
		}
		catch(SpeedExceedException e){
			int speed = e.getCurrentSpeed();
		}
		
	}
}
