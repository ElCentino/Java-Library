package working;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UDPServer implements Runnable{
	
	private DatagramSocket socket;
	private Scanner scan;
	
	private final int port = 1234;
	
	private Thread run, listen, send;
	
	private boolean running = false;
	
	private static List<Manager> clients = new ArrayList<Manager>();
	
	public UDPServer() throws SocketException {
		
		talk("Server Up");
		
		socket = new DatagramSocket(port);
		
		run = new Thread(this,"Run");
		run.start();
		
		scan = new Scanner(System.in);
	}
	
	public void run() {
		
		running = true;
		
		listen();
	}
	
	private void listen() {
		
		listen = new Thread("Listener") {
			
			public void run() {
				
				while(running) {
					
					byte[] data = new byte[1024];
					
					DatagramPacket packets = new DatagramPacket(data, data.length);
					
					try {
						socket.receive(packets);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
					String message = new String(packets.getData());
					
					try {
						processMessage(packets, message);
					} catch (UnknownHostException e) {
						
						e.printStackTrace();
					}
				}
			}
			
		}; listen.start();
	}
	
	private void send(final byte[] data, InetAddress address, int port) {
		
		send = new Thread("Send") {
			
			public void run() {
				
				DatagramPacket packets = new DatagramPacket(data, data.length, address, port);
				
				try {
					socket.send(packets);
				} catch (IOException e) {
				
					e.printStackTrace();

				}
			}
			
		}; send.start();
	}
	
	private void processMessage(DatagramPacket packet, String message) throws UnknownHostException { 
		
		String clientName = "";
		
		if(message.startsWith("/c/")) {
			
			int ID = Identifier.getIdentifier();
			
			clientName = message.split("/n/|/n/")[1];
			
			clients.add(new Manager(clientName, packet.getAddress(), packet.getPort(), ID));
			
			talk(clientName + "Connected from : " + packet.getAddress() + ", with port : " + packet.getPort() + 
					" and ID : " + ID);
			
		} else if(message.startsWith("/m/")) {
			
			message = message.split("/m/|/e/")[1];
			
			for(Manager client: clients) {
				
				if(packet.getPort() == client.port) {
					
					clientName = client.name;
					break;
				}
			}
			
			message = "Message from : " + clientName + ", Message : " + message;
			
			sendToAll(message);
			
		} else if(message.startsWith("/p/")) {
	
			System.out.println("called");

		}
	}
	
	private void talk(String text) {
		
		System.out.println(text);
		
	}
	
	private void sendToAll(String message) {
		
		for(int i = 0; i < clients.size(); i++) {
			
			send(message.getBytes(), clients.get(i).address, clients.get(i).port);
		}
		
		talk("Message sent : " + message);
	}
	
	public static void main(String[] args) throws SocketException {
		
		UDPServer server = new UDPServer();
		
		int z = 1;
		
		while(z != 0) {
			
			String message = server.scan.nextLine();
			
			server.sendToAll(message);
			
		}
		
		server.scan.close();
	}

}
