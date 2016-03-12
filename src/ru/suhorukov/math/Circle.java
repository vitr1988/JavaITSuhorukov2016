package ru.suhorukov.math;

public class Circle extends Figure {

	private double radius;
	
	public Circle(double r){
		this.radius = r;
	}
	
	@Override
	double calclulateSquare() {
		return Math.PI * Math.pow(radius, 2);
	}

}
