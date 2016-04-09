package ru.suhorukov.concurrency.home;

import java.io.FileNotFoundException;
import java.io.Serializable;

public class Deposit implements Serializable {

	private static final long serialVersionUID = 5116374936440848483L;
	
	transient String accountNumber;
	int restSum = 0;
	boolean flag = false;
	
//	Reader reader = new BufferedReader(new FileReader("adsifosi.txt"));
	
	
	public Deposit(String number) throws FileNotFoundException {
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
	
	public void print(){
		System.out.println(accountNumber + " " + restSum);
	}
}

