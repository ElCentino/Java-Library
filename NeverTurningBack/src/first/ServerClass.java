package first;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClass extends Thread{
	
	private static final int port = 1234;
	
	private ServerSocket server;
	private Socket connection;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	
	public ServerClass() {
		
		try {
			init();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	private void init() throws IOException {
		
		server = new ServerSocket(port);
		
		boolean running = true;
		
		connection = server.accept();
		
		new Thread(this,"Connection Thread").start();
	}
	
	public void run() {
		
		 {
				
				
					while(true) {
						
						try {
							
							
							
							out = new ObjectOutputStream(connection.getOutputStream());
							out.flush();
							
							in = new ObjectInputStream(connection.getInputStream());
							
							System.out.println(new String(in.readObject().toString()));
							
							
							
						} catch (IOException | ClassNotFoundException e) {
							
							e.printStackTrace();
						}
					}
				
		
			}
	}
	
	public static void main(String[] args) {
		
		new ServerClass();
	}
	
}