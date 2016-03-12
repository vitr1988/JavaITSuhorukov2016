package ru.suhorukov.math;

public class Rectangle extends Figure {

	private double length, width;
	
	public Rectangle(double a, double b){
		this.length = a;
		this.width = b;
	}
	
	@Override
	double calclulateSquare() {
		return this.length * this.width;
	}

}
