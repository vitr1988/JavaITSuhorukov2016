package ru.suhorukov.net;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpConnection extends Thread {
	
	private Socket sock;
	
	public HttpConnection(Socket socket){
		this.sock = socket;
	}
	
	@Override
	public void run(){
		try {
			System.out.println("Client successfully connect by " + sock.getPort() + " port");
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			writer.write("Socket with port " + sock.getPort() + " sends message 'Hello World!'" );
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
