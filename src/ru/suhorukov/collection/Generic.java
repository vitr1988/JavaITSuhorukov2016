package ru.suhorukov.collection;

public class Generic<T> {

	T field1;
	T field2;
	
	int order;
	
	public T summa(){
		return (T) (field1.toString() + field2.toString()); 
	}
}
