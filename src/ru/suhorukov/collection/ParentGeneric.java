package ru.suhorukov.collection;

import ru.suhorukov.auto.FlyCar;

public class ParentGeneric<T extends FlyCar> {

	T carExample;
	
	public ParentGeneric(T car){
		this.carExample = car;
	}
	
	public void printCar(){
		carExample.print();
	}
}
