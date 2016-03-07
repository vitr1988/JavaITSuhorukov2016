
public class FlyCar extends Automobile {

	public FlyCar(){
		super(1000, 500, .5);
	}
	
	@Override
	public final void move(){
		System.out.println("Car moves by rocket");
	}
}
