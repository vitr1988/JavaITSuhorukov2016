package ru.suhorukov.example;

import java.util.ArrayList;
import java.util.List;

public class DynamicLine {

	private int currentIndex = 0;
	private String[] lines;
	private List<String> lineList = new ArrayList<>();
	
	public void append(String str){
//		if (lines.length >= currentIndex){0
//			lines = new String[lines.length + 1];
//			//
//			lines[currentIndex++] = str;
//		}
		lineList.add(str);
	}
	
	public void initElements(int length){
		if (lines != null){
			String[] result = new String[lines.length + 1];
			for (int index = 0; index < lines.length; index++){
				result[index] = lines[index];
			}
			result[lines.length] = "";
			this.lines = result;
		}
		else {
			this.lines = new String[length];
		}
	}
}
