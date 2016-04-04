package ru.suhorukov.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Deposit {

	String accountNumber;
	AtomicInteger restSum;
	
	public Deposit(String number){
		this.accountNumber = number;
		this.restSum = new AtomicInteger(0);
	}
	
	public int getRestSum() {
		return restSum.get();
	}
	public void setRestSum(int restSum) {
		this.restSum.set(restSum);
	}
	
	public void modifyRest(int value){
		this.restSum.set(this.restSum.addAndGet(value));
	}
}
