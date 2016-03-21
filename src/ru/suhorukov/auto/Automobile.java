package ru.suhorukov.auto;

public abstract class Automobile extends Object implements Moveable {

	private int maxVelocity;
	private int speed;
	private double height;
	private String mark = null;
	public static int orderNumber = 0;
	static int[] array = new int[25];
	Object[][] characteristics = new Object[3][5];
	protected Engine engine;
	
	static {
		for (int i = 0; i < array.length; i++){
			array[i] = i * i;
		}
	}
	
	{
		for (int i = 0; i < characteristics.length; i++){
			Object[] element = characteristics[i];
			for (int j = 0; j < element.length; j++){
				characteristics[i][j] = (i + 1) * (j + 1);
			}
		}
	}
	
	private Automobile(){
	}
	
	public Automobile(int velocity, int currentSpeed, double height){
		this.maxVelocity = velocity;
		this.setSpeed(currentSpeed);
		this.setHeight(height);
		orderNumber++;
	}
	
	public int getMaxVelocity() {
		return maxVelocity;
	}
	public void setMaxVelocity(int maxVelocity) {
		this.maxVelocity = maxVelocity;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setHeigth(Automobile anotherAuto){
		class Cleaner {
			void clean() {
				System.out.println("Очистка автомобиля");
			}
		}
		new Cleaner().clean();
		this.setHeight(anotherAuto.getHeight());
	}
	public void crash(){
		class Eraser {
			void destroy() {
				System.out.println("Уничтожили автомобиль");
			}
		}
		class Cleaner {
			void clean() {
				System.out.println("Очистка автомобиля");
			}
		}
		maxVelocity = 0;
		speed = 0;
		height = 0;
		new Eraser().destroy();
		new Cleaner().clean();
	}
	
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
		mark = "Lada Niva";
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
//		if (obj.getClass().equals(Cargo.class)){
		if (obj instanceof Automobile){
			Automobile auto = (Automobile) obj;
//			Automobile auto2 = new Automobile();
			if (this.maxVelocity == auto.maxVelocity &&
					this.speed == auto.speed && 
						this.height == auto.height && (this.mark != null) &&
							this.mark.equals(((Automobile) obj).mark)){
				return true;
			}
		}
		
		return result;
	}
	
	public Object[][] getCharactistics(){
		return characteristics;
	}
	
	public void print(){
		String result = "";
		result += "[";
		result += "MaxVelocity = " + getMaxVelocity();
		result += ", Speed = " + getSpeed();
		result += ", Height = " + getHeight();
		result += ", Mark = " + (getMark() == null ? "Не определена" : getMark()); // "null"
		result += ", Index = " + INDEX;
		result += "]";
		System.out.println(result);
	}
	
	class Engine {
		double volume;
		int horsePower;
		int moment;
		
		public Engine(double volume, int hPower, int mom){
			setVolume(volume);
			setHorsePower(hPower);
			setMoment(mom);
		}
		
		public double getVolume() {
			return volume;
		}
		public void setVolume(double volume) {
			this.volume = volume;
		}
		public int getHorsePower() {
			return horsePower;
		}
		public void setHorsePower(int horsePower) {
			this.horsePower = horsePower;
		}
		public int getMoment() {
			return moment;
		}
		public void setMoment(int moment) {
			this.moment = moment;
		}
	}
}
