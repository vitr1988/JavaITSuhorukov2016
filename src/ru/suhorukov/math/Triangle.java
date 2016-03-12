package ru.suhorukov.math;

public class Triangle extends Figure {

	private double height, side;
	
	public Triangle(double height, double side){
		this.height = height;
		this.side = side;
	}
	
	@Override
	double calclulateSquare() {
		return 0.5 * height * side;
	}

}
