package ru.suhorukov.enumexample;

import ru.suhorukov.auto.Automobile;
import ru.suhorukov.auto.Car;
import ru.suhorukov.auto.Cargo;
import ru.suhorukov.auto.FlyCar;

public enum CarType {

	LIGHT(new Car()), CARGO(new Cargo()), FLY(new FlyCar());
	
	CarType(Automobile car){
		this.auto = car;
	}
	
	Automobile auto;
}
