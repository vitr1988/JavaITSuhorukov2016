package ru.suhorukov.collection;

public class Employee {
	
	public String name;
	public int experience;

	public Employee(String name, int experience) {
		this.name = name;
		this.experience = experience;
	}

	@Override
	public String toString() {
		return this.name + " : " + this.experience;
	}
}
