package ru.suhorukov.concurrency;

import ru.suhorukov.proxy.Automobile;

public class ThreadTest {

	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName());
		System.out.println(thread.getState());
		
		Automobile auto = new Automobile();
		LoggerThread logger = new LoggerThread(auto);
		LoggerThread logger2 = new LoggerThread(auto);
		
		final Thread newThread = new Thread(
			() -> {
				for (int i = 0; i < 1000; i++){
					if (i == 500) break;
				}
				System.out.println("newThread");
			}
		, "newThread");
		
		final Thread newThread1 = new Thread(
				() -> {
					for (int i = 0; i < 1000; i++){
						if (i == 500) break;
					}
					System.out.println("newThread1");
				}
		, "newThread1");
			
		final Thread newThread2 = new Thread(
				() -> {
					for (int i = 0; i < 1000; i++){
						if (i == 500) break;
					}
					System.out.println("newThread2");
				}
			, "newThread2");
		
		logger.start();
		logger2.start();
		newThread.start();
		newThread1.start();
		newThread2.start();
	}

}
