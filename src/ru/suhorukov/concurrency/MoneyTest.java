package ru.suhorukov.concurrency;

public class MoneyTest {

	private static int runnableThreadCount = 0;
	private final static int TOTAL_COUNT = 6;
	
	
	public static void main(String[] args) {
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
	}
	
	static class Salary implements Runnable {
		
		private Deposit deposit;
		
		public static final int AMOUNT = 30000;

		public Salary(Deposit dep){
			this.deposit = dep;
		}
		
		@Override
		public void run() {
			synchronized (this.deposit) {
				runnableThreadCount++;
				deposit.modifyRest(AMOUNT);
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

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			synchronized (dep) {
				if (runnableThreadCount != 2 * TOTAL_COUNT) {
					try {
						this.dep.wait();
					} catch (InterruptedException e) {
//						e.printStackTrace();
					}
				}
				System.out.println(this.dep.getRestSum());
			}
		}
		
	}
}
