package ru.suhorukov.auto;
public class FlyCar extends Automobile {

	public FlyCar(){
		super(1000, 500, .5);
		setMark("Fly Auto");
		super.engine = new Engine(15, 1000, 750);
		int arg = 9;
//		this(1000);
	}
	
	public FlyCar(int speed){
		super(speed, 500, .5);
	}
	
	@Override
	public final void move(){
		System.out.println("Car moves by rocket");
	}
}
