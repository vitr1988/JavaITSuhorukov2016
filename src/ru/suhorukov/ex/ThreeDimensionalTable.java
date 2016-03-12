package ru.suhorukov.ex;

import java.io.Serializable;

import ru.suhorukov.example.Table;

public class ThreeDimensionalTable extends Table implements Serializable {

	int index = -1; 
	
	public ThreeDimensionalTable(){
		rowCount = 25;
		columnCount = 10;
	}
}
