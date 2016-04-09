package ru.suhorukov.concurrency.home;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MoneyTest {

	private static int runnableThreadCount = 0;
	private final static int TOTAL_COUNT = 600;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Deposit clientDeposit = new Deposit("4284541242456654");
		clientDeposit.setRestSum(10000); 
		Thread viewThread = new Thread(new ViewActualData(clientDeposit));
		for (int i = 0; i < TOTAL_COUNT; i++){
			Thread salaryThread = new Thread(new Salary(clientDeposit));
			Thread spenderThread = new Thread(new Spender(clientDeposit, 3000));
			
			salaryThread.start();
			spenderThread.start();
		}
		viewThread.start();
		
		
		ExecutorService waitService = Executors.newSingleThreadExecutor();
		Future<Integer> result = waitService.submit(new Callable<Integer>(){
			@Override
			public Integer call() throws Exception {
				Thread.sleep(2000);
				return 25 + 15;
			}
		});
		System.out.println(result.get());
	}
	
	static class Salary implements Runnable {
		
		private Deposit deposit;
		
		public static final int AMOUNT = 30000;
		
		ThreadLocal<Integer> index;

		public Salary(Deposit dep){
			this.deposit = dep;
			 index = new ThreadLocal<Integer>(){
				@Override
				public Integer initialValue(){
					return 0; 
				}
			};
			index.set(new Random().nextInt(15000));
		}
		
		@Override
		public void run() {
			synchronized (this.deposit) {
				runnableThreadCount++;
				deposit.modifyRest(AMOUNT);
				System.out.println("Salary Index : " + index.get());
				if (runnableThreadCount == 2 * TOTAL_COUNT){
					this.deposit.notify();
				}
			}			
		}
	}
	
	static class Spender implements Runnable {
		
		private Deposit deposit;
		private int summa;

		public Spender(Deposit dep, int summa){
			this.deposit = dep;
			this.summa = summa;
		}
		
		@Override
		public void run() {
			synchronized (deposit) {
				runnableThreadCount++;
				deposit.modifyRest(-1 * summa);
				if (runnableThreadCount == 2 * TOTAL_COUNT){
					this.deposit.notify();
				}
			}
		}
	}
	
	static class ViewActualData implements Runnable {

		Deposit dep;
		
		public ViewActualData(Deposit clientDeposit) {
			this.dep = clientDeposit;
		}

		@Override
		public void run() {
			synchronized (dep) {
				if (runnableThreadCount != 2 * TOTAL_COUNT) {
					try {
						this.dep.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(this.dep.getRestSum());
			}
		}
		
	}
}

