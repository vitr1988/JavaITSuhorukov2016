
public abstract class Automobile {

	private int maxVelocity;
	private int speed;
	private double height;
	private String mark;
	
	public Automobile(){
	}
	
	public Automobile(int velocity, int currentSpeed, double height){
		this.maxVelocity = velocity;
		this.setSpeed(currentSpeed);
		this.setHeight(height);
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
		this.setHeight(anotherAuto.getHeight());
	}
	public void crash(){
		maxVelocity = 0;
		speed = 0;
		height = 0;
	}
	public abstract void move();
	
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
		mark = "Lada Niva";
	}
}
