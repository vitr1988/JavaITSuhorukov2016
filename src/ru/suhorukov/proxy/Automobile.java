package ru.suhorukov.proxy;

public class Automobile implements Moveable, Capable {

	@Override
	public boolean capable() {
		System.out.println("capable()");
		return false;
	}

	@Override
	public void move() {
		System.out.println("move()");
	}

	@Override
	public void move(int distance) {
		System.out.println("move(distance:" + distance + ")");
	}

}
