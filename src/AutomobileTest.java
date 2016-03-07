
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
	}

}
