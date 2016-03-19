import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import jdk.nashorn.internal.runtime.regexp.joni.Option;

public class WrapperTest {

	public static void main(String[] args) {
		int id = 10;
		Integer index = new Integer(25);
		int summa = (int) index + 10;//35
		System.out.println(summa);
		index = null;
		Integer index2 = Integer.valueOf(25);
		System.out.println(index2.floatValue()/2);
		Integer index3 = 25;
		int n = index == null ? 0 : index;//null
		
		if (n > 100){
			System.out.println("Index is more than one hundred!");
		}
		else {
			System.out.println("Index is less than one hundred!");
		}
		
		System.out.println(Integer.valueOf(5) == Integer.valueOf(5));
		System.out.println(Integer.valueOf(205) == Integer.valueOf(205));
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		Double d = Double.valueOf(1.2);
		Double d2 = Double.parseDouble("1.5");
		Character c = 'а';
		System.out.println((int) c);
		
		Boolean b = null;
		boolean f = false;
//		if (b == true){
		if (Boolean.TRUE.equals(b)){
			
		}
		BigInteger big = new BigInteger("10454545642123154215451548421544524548545454854854441");
		System.out.println(big.add(BigInteger.valueOf(1000)));
		
		BigDecimal bigD = new BigDecimal("54285278597285724585728957249852552.47265426578246578246578246527855265265724");
		BigDecimal bigD2 = new BigDecimal(0.1, MathContext.UNLIMITED);
		BigDecimal bigD3 = new BigDecimal("0.1");
		
		System.out.println(bigD2);
		System.out.println(bigD3);
	}

}

