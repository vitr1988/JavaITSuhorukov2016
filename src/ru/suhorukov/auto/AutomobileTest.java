package ru.suhorukov.auto;

import java.util.Arrays;
import static ru.suhorukov.auto.Automobile.*;
import static ru.suhorukov.auto.Cargo.cargo2String;
import static ru.suhorukov.auto.Cargo.MAX_WEIGHT;

public class AutomobileTest {

	public static void main(String[] args) {
		Automobile ladaKalina = new Car();
		ladaKalina.setHeight(1.5);
		ladaKalina.setMaxVelocity(180);
		ladaKalina.setSpeed(60);
		
		Automobile jeepCherokee = new Car();
		jeepCherokee.setHeight(3);
		jeepCherokee.setMaxVelocity(240);
		jeepCherokee.setSpeed(120);
		
		Automobile nissan = new Car();
		nissan.setMaxVelocity(220);
		nissan.setHeight(1.6);
		nissan.setSpeed(80);
		
		Automobile volvoTruck = new Cargo();
		volvoTruck.setMaxVelocity(220);
		volvoTruck.setHeight(1.6);
		volvoTruck.setSpeed(80);
		
		Automobile futureCar = new FlyCar();
		futureCar.setMaxVelocity(1220);
		futureCar.setHeight(.5);
		futureCar.setSpeed(500);
		
//		Automobile[] cars = new Automobile[4];
//		cars[0] = ladaKalina;
//		cars[1] = jeepCherokee;
//		cars[2] = ladaKalina;
//		cars[4] = jeepCherokee;
		Automobile[] cars = new Automobile[]{
			ladaKalina, jeepCherokee, nissan, volvoTruck, futureCar
		};
		for (Automobile car : cars){
			car.setHeight(10);
		}
		System.out.println(((Car) nissan).getPassengerCount());
//		Automobile a = new Car();
//		Car c = (Car) a;
//		c.setPassengerCount(10);
//		System.out.println(a.equals(c));
		
		Automobile niva = new Car();
		String nivaBrand = "Niva";
		niva.setMark(nivaBrand);
		niva.setHeigth(jeepCherokee);
		System.out.println(nivaBrand);
		System.out.println(jeepCherokee.getMark());
		
//		Automobile car = new FlyCar();
//		car.move();
		
		for (Automobile car : cars){
//			if (car instanceof Car){
//				((Car) car).move();
//			}
//			else if (car instanceof Cargo){
//				((Cargo) car).move();
//			}
//			else if (car instanceof FlyCar){
//				((FlyCar) car).move();
//			}
			car.move();
		}
		
		double coordinateA[][] = new double[25][2];
		coordinateA[0] = new double[]{2, 3};
		coordinateA[1] = new double[]{15, 25};
		coordinateA[2] = new double[]{12, 13};
		coordinateA[1] = new double[]{15, 25};
		
		Object o = new String();
		Object o1 = new UFO();
		
		boolean flag = new String() == new String(); //flag = false;
		System.out.println(new UFO() == new UFO()); // false
		System.out.println(new UFO().equals(new UFO())); // true
		System.out.println(new UFO().equals(new UFO(10))); // false
		
		System.out.println(new Car().toString());
		
		System.out.println(orderNumber);
		
		System.out.println(Arrays.toString(array));
		
		Object[][] array = niva.getCharactistics();
		for (int index = 0; index < array.length; index++){
			System.out.print(Arrays.toString(array[index]));
		}
		
		double[] doubleArray = {1., 2., 3, 10.5};
		double[] doubleArray2;
		doubleArray2 = new double[4];
		doubleArray2[0] = 1.;
		doubleArray2[1] = 2.;
		doubleArray2[2] = 3;
		doubleArray2[3] = 10.5;
		
		double[][] doubleArray3 = {{1., 2., 3, 10.5}, {1.4, 5.2, 3.5}};
		doubleArray3[0] = new double[] {1., 2., 3, 10.5};
		double[][] doubleArray4 = new double[2][3];
		doubleArray4[0] = new double[]{1.4, 1.2, 5.2, 6.7};
		System.out.println("-------");
		for (double[] arr: doubleArray4){
			System.out.println(Arrays.toString(arr));
		}
		
		System.out.println(cargo2String((Cargo) volvoTruck));
		System.out.println(MAX_WEIGHT + 1500);
//		ufo.crash();
		
		Moveable vehicle = new Car();
		vehicle.move();
		vehicle.print();
		
		Moveable[] interfaceCars = {
			ladaKalina, jeepCherokee, nissan, volvoTruck, futureCar
		};
		for (Moveable car : interfaceCars){
			car.move();
		}
	}

}
