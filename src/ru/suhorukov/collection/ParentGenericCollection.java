package ru.suhorukov.collection;

import ru.suhorukov.auto.Car;
import ru.suhorukov.auto.FlyCar;
import ru.suhorukov.auto.UFO;

public class ParentGenericCollection {

	public static void main(String[] args) {
		ParentGeneric<FlyCar> car = new ParentGeneric<FlyCar>(new FlyCar());
		ParentGeneric<UFO> ufo = new ParentGeneric<UFO>(new UFO());
//		ParentGeneric<Car> carCar = new ParentGeneric<Car>(new Car());
	}

}
