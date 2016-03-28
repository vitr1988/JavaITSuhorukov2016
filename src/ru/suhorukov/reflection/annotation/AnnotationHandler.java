package ru.suhorukov.reflection.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationHandler {

	public static void handle(Class<?> cl){
		Object obj = null;
		try {
			obj = cl.newInstance();
			for (Method m : cl.getMethods()){
				if (m.isAnnotationPresent(LogAnnotate.class)){
					LogAnnotate an = m.getAnnotation(LogAnnotate.class);
					if (an.ignore()) continue;
					
					long currentTime = System.currentTimeMillis();
					m.invoke(obj);
					System.out.println(an.name() + "-" + an.logLevel() + " - " + m.getName() + 
							" - executionTime : " + (System.currentTimeMillis() - currentTime) + " in ms ");
				}
				
	//			LogAnnotate an = 
	//			if (an != null){
	//				
	//			}
			}
			
			for (Constructor c : cl.getConstructors()){
				LogAnnotate an = (LogAnnotate) c.getAnnotation(LogAnnotate.class);
				if (an != null) {
					long currentTime = System.currentTimeMillis();
					Object testObject = c.newInstance();
					System.out.println(an.name() + "-" + an.logLevel() + " - " +  
							" - executionTime : " + (System.currentTimeMillis() - currentTime) + " in ms ");
				}
			}
		
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
