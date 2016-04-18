package ru.suhorukov.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest extends Assert {

	private static Calculator calc;
	
	@BeforeClass
	public static void init(){
		calc = new Calculator();
	}
	
	@Test
	public void testSumma(){
		assertEquals(9, calc.summa(5, 4));
		assertEquals(54, calc.summa(50, 4));
		assertEquals(150, calc.summa(150, 0));
	}
	
	@Test
	public void testMinus(){
		assertEquals(1, Calculator.minus(5, 4));
		assertEquals(46, Calculator.minus(50, 4));
		assertEquals(150, Calculator.minus(150, 0));
	}
	
	@Test
	public void testMultiply(){
		assertEquals(20, Calculator.multiply(5, 4));
		assertEquals(200, Calculator.multiply(50, 4));
		assertEquals(0, Calculator.multiply(150, 0));
	}
	
	@Test
	public void testDivision(){
		assertEquals(1, Calculator.division(5, 4));
		assertEquals(12, Calculator.division(50, 4));
//		assertEquals(150, Calculator.division(150, 0));
	}
}
