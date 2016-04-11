package ru.suhorukov.random;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println(rand.nextInt());
		System.out.println(rand.nextFloat());
		System.out.println(rand.nextBoolean());
		
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		
		runtime.exit(0);
	}

}
