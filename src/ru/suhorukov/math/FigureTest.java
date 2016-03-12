package ru.suhorukov.math;

public class FigureTest {

	public static void main(String[] args) {
		
		Figure[] figures = {
			new Rectangle(5, 12), new Triangle(10, 15), new Circle(20)	
		};
		
		for (Figure fig :  figures){
			System.out.println(fig.calclulateSquare());
		}
	}

}
