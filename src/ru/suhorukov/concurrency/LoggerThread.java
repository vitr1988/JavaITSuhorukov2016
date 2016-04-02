package ru.suhorukov.concurrency;

import ru.suhorukov.proxy.Automobile;

public class LoggerThread extends Thread {
	
	private Automobile auto;
	
	public LoggerThread(Automobile a){
		this.auto = a;
		setName("logger");
	}
	

	@Override
	public void run(){
		long initTime = System.currentTimeMillis();
		
		while(true){
			// run in 5 seconds
			if (System.currentTimeMillis() - initTime > 5000) {
				return;
			}
			System.out.println(getName() + " : HelloWorld");
			auto.move();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
