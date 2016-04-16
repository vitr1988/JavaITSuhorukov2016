package ru.suhorukov.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 7000), 2000);
			Scanner scanner = new Scanner(socket.getInputStream());
			while(scanner.hasNext()){
				String line = scanner.nextLine();
				System.out.println(line);
			}
			scanner.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
