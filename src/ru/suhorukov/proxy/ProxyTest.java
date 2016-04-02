package ru.suhorukov.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		Automobile auto = new Automobile();
		Object autoProxy = createProxy(auto);
		if (autoProxy instanceof Capable){
			((Capable)autoProxy).capable();
		}
		if (autoProxy instanceof Moveable){
			((Moveable)autoProxy).move();
			((Moveable)autoProxy).move(1000);
		}
		
		Bycicle bycicle = new Bycicle();
		Object bycicleProxy = createProxy(bycicle);
		if (bycicleProxy instanceof Moveable){
			((Moveable)autoProxy).move();
			((Moveable)autoProxy).move(1000);
		}
	}
	
	public static Object createProxy(Object obj){
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				new Class<?>[]{Capable.class, Moveable.class}, new ProxyInvocationHandler(obj));
	}
	
	static class ProxyInvocationHandler implements InvocationHandler {

		private Object parentObject;
		
		public ProxyInvocationHandler(Object o){
			this.parentObject = o;
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (method.getName().equals("move")){
				System.out.println("Start method " + method.getName());
				long currTime = System.currentTimeMillis();
				Object result = method.invoke(parentObject, args);
				System.out.println("Time handling of method " + method.getName() + " is " + 
							(System.currentTimeMillis() - currTime) +  " miliseconds");
				return result;
			}
			else if (method.getName().equals("capable")){
				System.out.println("Start checking");
				Object result = method.invoke(parentObject, args);
				System.out.println("Stop checking");
				return result;
			}
			return null;
		}
		
	}
}
