package second;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	private Socket connection;	
	
	private int port;
	
	private String message;
	
	private boolean running = false;
	
	private Thread run, receive;
	
	public Client(int port) throws IOException, ClassNotFoundException {
		
		this.port = port;
		
		talk("This is Century's test client");
		
		talk("Trying to create client port");
		
		try {
			connection = new Socket("localhost", port);
			
		} catch (IOException e) {
			
			talk("Ehhhhh connection failed dude, check the server ffs");
			
			e.printStackTrace();
		}
		
		talk("Client connection ready!!!!!");
		
		startup();
		
		run = new Thread(this, "Run");
		run.start();
		
		chattingMechanism();
		
		talk("Main Thread started");
		
	}
	
	private void startup() throws IOException, ClassNotFoundException {
		
		streams();
		
		talk("Attempting stable connection on port : " + port + " , at server " +
				connection.getInetAddress().getHostAddress());
		
		
		talk("You are now connected to " + connection.getInetAddress() + " at Port : " 
				+ connection.getPort());
		
		talk("Now you can talk to each other");
		
	}
	
	private void chattingMechanism() throws IOException, ClassNotFoundException {
		
		int status = 0;
		
		while(status != 1) {
			
			message = new Scanner(System.in).nextLine();
			send(message);
			
			talk("Message sent : " + message);
			
			if(running == false)
				closeStreams();
		}
		
	}
	
	public void run() {
		
		running = true;
		
		talk("Client now running");
		
		receive();
		
	}
	
	private void receive() {
		
		
		
		receive = new Thread("Receive") {
			
			String receivedMessage;
			
			public void run() {
				
				while(running) {
					
					try {
						
						receivedMessage = (String) in.readObject();
						
						if(!receivedMessage.equals(null))
							talk("Message received : " + receivedMessage);
						
					} catch (ClassNotFoundException | IOException e) {
						
						e.printStackTrace();
					}
				}
					
			}
			
			
		}; receive.start();

	}
	
	private void streams() throws IOException {
		
		talk("Setting up the output stream");
		
		try {
			
			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();
			
		} catch (IOException e) {
			
			talk("output stream crashed, try initializing input b4 output");
			
			e.printStackTrace();
		}
		
		talk("Setting up the input stream");
		
		in = new ObjectInputStream(connection.getInputStream());
		
		talk("yh yh we know this aint a problem setting up this stream");
		
		talk("Streams are now setup mate!!!, carry on");
		
	}
	
	private void closeStreams() throws IOException {
		
		talk("Closing streams");
		
		out.close();
		out.flush();
		
		in.close();
		
		talk("Streams are now closed up");
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		new Client(1234);
		
	}
	
	public void talk(String text) {
		
		System.out.println(text);
	}
	
	private void send(String message) throws IOException {
		
		out.writeObject(message);
		out.flush();
	}

}
