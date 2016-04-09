package ru.suhorukov.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ru.suhorukov.concurrency.home.Deposit;

public class SerializationTest {

	public static void main(String[] args) {
		serialize();
		deserialize();
	}

	private static void serialize() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				System.getProperty("user.dir") + "/src/ru/suhorukov/io/test.ser"))){
			Deposit deposit = new Deposit("454546545678");
			Deposit newDeposit = new Deposit("4545465454545");
			Deposit fixDeposit = new Deposit("45454654578787");
			
			deposit.setRestSum(15000);
			newDeposit.setRestSum(50000);
			fixDeposit.setRestSum(100000);	
			
			oos.writeObject(deposit);
			oos.writeInt(1);
			oos.writeBoolean(true);
			oos.writeObject(newDeposit);
			oos.writeObject(fixDeposit);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void deserialize() {
		try(ObjectInputStream oos = new ObjectInputStream(new FileInputStream(
				System.getProperty("user.dir") + "/src/ru/suhorukov/io/test.ser"))){
			Deposit deposit = (Deposit) oos.readObject();
			int index = oos.readInt();
			boolean flag = oos.readBoolean();
			Deposit newDeposit = (Deposit) oos.readObject();
			Deposit fixDeposit = (Deposit) oos.readObject();
			deposit.print();
			System.out.println(index);
			System.out.println(flag);
			newDeposit.print();
			fixDeposit.print();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

