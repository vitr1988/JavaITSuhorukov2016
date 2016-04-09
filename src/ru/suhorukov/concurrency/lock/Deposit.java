package ru.suhorukov.concurrency.lock;

public class Deposit {

	String accountNumber;
	int restSum;
	
	public Deposit(String number){
		this.accountNumber = number;
		this.restSum = 0;
	}
	
	public int getRestSum() {
		return restSum;
	}
	public void setRestSum(int restSum) {
		this.restSum = restSum;
	}
	
	public void modifyRest(int value){
		this.restSum += value;
	}
}
