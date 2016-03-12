package ru.suhorukov;

public class Point {

	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public static int calculateDistance(Point p1, Point p2){
		int coordX1 = p1.x;
		int coordY1 = p1.y;
		
		int coordX2 = p2.x;
		int coordY2 = p2.y;
		
		return -1;
	}
	
	public int[] generateArray(){
		int[] a = new int[25];
		for (int i = 0 ; i < a.length; i++){
			a[i] = i * i;
		}
		return a;
	}
}
