
public class HelloWorld {

	public static void main(String[] arguments) {
		int length = arguments.length;
		if (length == 2){
			System.out.println(Integer.decode(arguments[0]) + 
					Integer.decode(arguments[1]));
		}
		else {
			System.out.println("Excepted two arguments!");
		}
//		System.out.println("Hello 2016 Year!!!");		
	}

}
