package ru.suhorukov.net;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketTest {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(7000);
			System.out.println("Server listens the port 7000");
			while (true)
				new HttpConnection(server.accept()).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (server != null){
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
