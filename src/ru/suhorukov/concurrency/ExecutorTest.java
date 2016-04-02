package ru.suhorukov.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {

	public static void main(String[] args) {
//		ExecutorService threadPoll = Executors.newFixedThreadPool(10);
//		for (int i = 0; i < 100; i++){
//			threadPoll.submit(new Runnable(){
//				@Override
//				public void run() {
//					long currTime = System.currentTimeMillis();
//					while (true){
//						if (System.currentTimeMillis() - currTime > 1000){
//							return;
//						}
//						System.out.println("Hello World");
//						try {
//							Thread.sleep(3000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			});
//		}	
		ExecutorService pool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++){
			Future<Long> future = pool.submit(new Callable<Long>(){
				@Override
				public Long call() throws Exception {
					long currTime = System.currentTimeMillis();
					while (true){
						long result = System.currentTimeMillis() - currTime; 
						if (result > 1000){
							return result;
						}
//						System.out.println("Hello World");
						Thread.sleep(3000);
					}
				}
			});
			
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}	
		
		pool.shutdown();
		
//		try {
//			threadPoll.shutdown();
//			if (!threadPoll.isTerminated())
//				threadPoll.awaitTermination(2, TimeUnit.SECONDS);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		finally {
//			threadPoll.shutdownNow();
//		}
		
	}

}
