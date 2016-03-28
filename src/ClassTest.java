import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

public class ClassTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Date date = new Date();
		date.getDate();
		
		Class<?> clascString = "".getClass();
		Class<?> classString = String.class;
		try {
			Class<?> classByNameString = Class.forName("java.lang.String");
			Class<?> classByClassLoaderString = ClassTest.class.getClassLoader().loadClass("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Class<?> tabNumberClass = Class.forName("ru.suhorukov.collection.TabNumber");
//			Object object = tabNumberClass.newInstance();
//			Constructor<?> contstructor = tabNumberClass.getConstructor(Integer.class);
			Constructor<?> contstructor = tabNumberClass.getConstructor(String.class);
			Object object = contstructor.newInstance("10000");
			System.out.println(object);
			
			Field tabNumberField = tabNumberClass.getDeclaredField("tabNumber");
			tabNumberField.setAccessible(true);
			
			Field orderIdFiled = tabNumberClass.getDeclaredField("orderId");
			orderIdFiled.setAccessible(true);
			
			System.out.println("Tab Number :" + tabNumberField.get(object));
			System.out.println("Order ID :" +  orderIdFiled.get(object));
			
			System.out.println("----");
			for (Method method : tabNumberClass.getMethods()){
				System.out.println(method);
			}
			System.out.println("----");
			for (Method method : tabNumberClass.getDeclaredMethods()){
				System.out.println(method);
			}
			System.out.println("----");
			for (Method method : tabNumberClass.getSuperclass().getDeclaredMethods()){
				System.out.println(method);
			}
			
			
			Class<?> parentClass = tabNumberClass.getSuperclass();
			while (parentClass != null){
				parentClass = parentClass.getSuperclass();
				//TODO: изучаете структуру родительского класса!
			}
			
			Method method = tabNumberClass.getDeclaredMethod("checkTabNumber");
			method.setAccessible(true);
			System.out.println(method.invoke(object));
			
			
		} catch (Throwable e){
			e.printStackTrace();
		}
		
//		print();
//		print(1);
//		print(new int[]{1, 2, 3});
//		print(1, 3, 5, 6, 8);
	}

	public ClassTest(String... strs){
		
	}
	
//	public void print(int index){
//		System.out.println(index);
//	}
//	
//	public void print(int[] index){
//		for (int in : index)
//		System.out.println(in);
//	}
//	
//	public void print(){
//		System.out.println();
//	}
	
	public static void print(Object... is){
		if (is.length == 0){
			System.out.println();
		}
		else if (is.length == 1){
			System.out.println(is[0]);
		}
		else {
			for (Object in : is){
				System.out.println(in);
			}
		}
	}
}

