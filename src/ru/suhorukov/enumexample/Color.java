package ru.suhorukov.enumexample;

public enum Color {
	RED(1), YELLOW(2), GREEN(3);
	
	Color(int index){
		this.colorIndex = index;
	}
	
	int colorIndex;

	public String asStr(){
		switch(colorIndex) {
			case 1 : return "red";
			case 2 : return "yellow";
			case 3 : 
			default: return "green";
		}
	}
}
