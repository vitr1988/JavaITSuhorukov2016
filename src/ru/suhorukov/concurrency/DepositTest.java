package ru.suhorukov.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DepositTest {

	public static void main(String[] args) {
		Deposit clientDeposit = new Deposit("4284541242456654");
		clientDeposit.setRestSum(10000); 
		
		ReentrantLock lock = new ReentrantLock();
		for (int i = 0; i < 6; i++){
			Thread salaryThread = new Thread(new Salary(clientDeposit, lock));
			Thread spenderThread = new Thread(new Spender(clientDeposit, 3000, lock));
//			Thread viewThread = new Thread(new ViewActualData(clientDeposit, lock));
			salaryThread.start();
			spenderThread.start();
//			viewThread.start();
		}
		System.out.println(clientDeposit.getRestSum());	
	}
	
	static class Salary implements Runnable {
		
		private Deposit deposit;
		
		public static final int AMOUNT = 30000;
		private Lock lock;

		public Salary(Deposit dep, Lock lock){
			this.deposit = dep;
			this.lock = lock;
		}
		
		@Override
		public void run() {
			
			if (lock.tryLock()) {
				deposit.modifyRest(AMOUNT);
				lock.unlock();
			}
			
		}
	}
	
	static class Spender implements Runnable {
		
		private Deposit deposit;
		private int summa;
		private Lock lock;

		public Spender(Deposit dep, int summa, Lock lock){
			this.deposit = dep;
			this.summa = summa;
			this.lock = lock;
		}
		
		@Override
		public void run() {
//			synchronized (deposit) {
//			}
			
			if (lock.tryLock()){
				deposit.modifyRest(-1 * summa);
				lock.unlock();
			}
			
			
		}
	}
	
	static class ViewActualData implements Runnable {

		Deposit dep;
		private Lock lock;
		
		public ViewActualData(Deposit clientDeposit, Lock lock) {
			this.dep = clientDeposit;
			this.lock = lock;
		}

		@Override
		public void run() {
//			try {
//				while (lock.tryLock()){
//					System.out.println(this.dep.getRestSum());
//				}
//			}
//			finally {
//				lock.unlock();
//			}
			
			if (lock.tryLock()){
				System.out.println(this.dep.getRestSum());
				lock.unlock();
			}
		}
		
	}
}
