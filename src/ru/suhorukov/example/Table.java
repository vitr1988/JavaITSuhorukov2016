package ru.suhorukov.example;

public class Table {

	private String[] data;
	protected int rowCount, columnCount;
	
	public void fillData(){
		data = new String[3];
		data[0] = "red";
		data[1] = "yellow";
		data[2] = "green";
	}
}
