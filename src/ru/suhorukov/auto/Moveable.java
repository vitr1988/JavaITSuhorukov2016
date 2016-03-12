package ru.suhorukov.auto;

public interface Moveable {
	
	public final static int INDEX = 0;

	public abstract void move();
	
	default void print(){
		System.out.println("Print this object");
	}
}
