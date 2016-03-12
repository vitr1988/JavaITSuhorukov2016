package ru.suhorukov.enumexample;

public class Spetafor {

	Color color = Color.RED;
	
	public boolean availableWalking(){
		return Color.GREEN.equals(color);
	}
	
	public void changeColor(String str){
		switch(str){
			case "red" :  color = Color.RED; break;
			case "yellow" :  color = Color.YELLOW; break;
			case "green" :  
			default : color = Color.GREEN; break;
		}
		String colorStr = color.asStr();
		Color color = Enum.valueOf(Color.class, "RED");
		color.toString();
	}
}
