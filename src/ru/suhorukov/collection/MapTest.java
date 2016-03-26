package ru.suhorukov.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {

	public static void main(String[] args) {
		Map<TabNumber, Employee> data = new HashMap<>();
		String[] tabNumbers = getTabNumbers(),
				employees = getEmployees();
		for (int index = 0; index < tabNumbers.length; index++){
			data.put(new TabNumber(tabNumbers[index]), new Employee(employees[employees.length - index - 1], index + 5));
		}
		for (Entry<TabNumber, Employee> entry : data.entrySet()){
			System.out.println(entry.getKey() + "- (" + entry.getValue() + ")");
		}
		
//		TabNumber key = new TabNumber("1000");
//		data.put(key, new Employee("Test", -25));
		
		TabNumber tabNumber = new TabNumber("1000");
		Employee emp = null;
		data.put(new TabNumber("-1"), emp);
		
		System.out.println(data.get(new TabNumber("-1")));//null
		
		if (data.containsKey(new TabNumber("-1"))){
			System.out.println(data.get(new TabNumber("-1")));
		}
		
	}
	
	public static String[] getEmployees(){
		return new String[]{"Ivanov Ivan Ivanovich", "Petrov Petr Nikolaevich", "Sidrov Ivan Petrovich", "Soldatova Irina Gennadievna"};
	}

	public static String[] getTabNumbers(){
		return new String[]{"1000", "2000", "5000", "10000"};
	}
}

