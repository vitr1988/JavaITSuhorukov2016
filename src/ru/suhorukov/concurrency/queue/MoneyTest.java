package ru.suhorukov.concurrency.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MoneyTest {

	private final static int TOTAL_COUNT = 6;
	
	public static void main(String[] args) {
		Deposit clientDeposit = new Deposit("4284541242456654");
		clientDeposit.setRestSum(10000); 
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2 * TOTAL_COUNT);
		Thread viewThread = new Thread(new ViewActualData(clientDeposit, queue));
		for (int i = 0; i < TOTAL_COUNT; i++){
			Thread salaryThread = new Thread(new Salary(clientDeposit, queue));
			Thread spenderThread = new Thread(new Spender(clientDeposit, 3000, queue));
			
			salaryThread.start();
			spenderThread.start();
		}
		viewThread.start();
	}
	
	static class Salary implements Runnable {
		
		private Deposit deposit;
		
		public static final int AMOUNT = 30000;

		BlockingQueue<Integer> queue;
		
		public Salary(Deposit dep, BlockingQueue<Integer> queue){
			this.deposit = dep;
			this.queue = queue;
		}
		
		@Override
		public void run() {
			try {
				int plus = AMOUNT;
				deposit.modifyRest(plus);
				queue.put(plus);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}			
		}
	}
	
	static class Spender implements Runnable {
		
		private Deposit deposit;
		private int summa;
		private BlockingQueue<Integer> queue;

		public Spender(Deposit dep, int summa, BlockingQueue<Integer> queue){
			this.deposit = dep;
			this.summa = summa;
			this.queue = queue;
		}
		
		@Override
		public void run() {
			try {
				int minus = -1 * summa;
				deposit.modifyRest(minus);
				queue.take();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	static class ViewActualData implements Runnable {

		Deposit dep;
		BlockingQueue<Integer> queue;
		
		public ViewActualData(Deposit clientDeposit, BlockingQueue<Integer> queue) {
			this.dep = clientDeposit;
			this.queue = queue;
		}

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			try {
				while(true) {
					if (queue.isEmpty()) {
						System.out.println(this.dep.getRestSum());
						return;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
}


