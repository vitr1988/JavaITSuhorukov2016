package ru.suhorukov.exception;

public class SpeedExceedException extends RuntimeException {

	private int currentSpeed;
	private String error;
	public static final int MAX_SPEED = 180;
	
	public SpeedExceedException(int speed){
		if (speed > MAX_SPEED)
			this.currentSpeed = speed;
		else {
			this.currentSpeed = 0;
		}
	}
	public SpeedExceedException(int speed, String text){
		this(speed);
		this.error = text;
	}
	
	@Override
	public String toString(){
		if (error != null) return error;
		
		if (currentSpeed == 0) return "";
		return "Вы превысили допустимую максимальную скорость " + MAX_SPEED + " км/ч. За Вами выехали полиция.\n" +
				"Ваша текущая скорость составляет " + currentSpeed + " км/ч";
	}
	public int getCurrentSpeed() {
		return currentSpeed;
	}
}
