package ru.suhorukov.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class UtilTest {

	public static void main(String[] args) {
		System.out.println(Math.random() * 100);
		System.out.println(Math.round(12.4));
		System.out.println(Math.round(12.51));
		System.out.println(Math.round(12.49));
		
//		10000.563 = 10001
//		45000.178 = 45000
		
		List<Integer> list =  new ArrayList<>(Arrays.asList(1, 2, 3));
		List<Integer> dest = new ArrayList<>(list.size());
		Collections.copy(list, dest);
		
		Locale locale = Locale.getDefault();
		System.out.println(locale.getLanguage() + "_" + locale.getCountry() + "_" + locale.getVariant());
		
		Locale.setDefault(Locale.US);
		ResourceBundle resource = ResourceBundle.getBundle("ru.suhorukov.util.resourceText", locale);
		System.out.println(resource.getString("label1.text"));
	}

}
