package ru.ivanov.testtask;

import java.util.Vector;

public class DataStructure {

	private Vector<String> columnNames;
	private Vector<Vector<Object>> data;
	
	public DataStructure(Vector<String> columnNames, Vector<Vector<Object>> data) {
		this.columnNames = columnNames;
		this.data = data;
	}
	public Vector<String> getColumnNames() {
		return columnNames;
	}
	public Vector<Vector<Object>> getData() {
		return data;
	}
	
	
}
