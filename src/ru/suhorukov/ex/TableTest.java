package ru.suhorukov.ex;

import java.util.Date;
//import ru.suhorukov.Table;

import ru.suhorukov.example.Table;

public class TableTest {

	public static void main(String[] args) {
		Table table = new Table();
//		table.rowCount = 25;
//		table.columnCount = 10;
		table.fillData();
		String str = "";
		Table tableAnother = new Table();
		Date date = new Date();
		
		Table table3 = new Table();
		
		ThreeDimensionalTable table3D = new ThreeDimensionalTable();
		table3D.index = 0;
	}

}
