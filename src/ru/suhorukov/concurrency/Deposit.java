package ru.suhorukov.concurrency;

public class Deposit {

	String accountNumber;
	int restSum;
	
	public Deposit(String number){
		this.accountNumber = number;
		this.restSum = 0;
	}
	
	public synchronized int getRestSum() {
		return restSum;
	}
	public synchronized void setRestSum(int restSum) {
		this.restSum = restSum;
	}
	
	public synchronized void modifyRest(int value){
		setRestSum(getRestSum() + value);
	}
}
