package working.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient implements Runnable{
	
	private DatagramSocket socket;
	private static Scanner scan;
	
	private int port;
	
	private Thread run, listen, send;
	
	private boolean running = false;
	
	private InetAddress address;
	
	private static String name;
	
	public UDPClient(String address, int port, String name) throws SocketException, UnknownHostException {
		
		socket = new DatagramSocket();
		
		this.address = InetAddress.getByName(address);
		this.port = port;
		UDPClient.name = name;
		
		run = new Thread(this, "Run");
		run.start();
		
		String message = "/c//n/" + name +" /n/" + "/a/" + address + "/a/:/p/" + port + "/p//e/";
		
		send(message.getBytes());
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
					
					talk("Message Receieved : " + message);
				}
			}
			
		}; listen.start();
	}
	
	private void send(final byte[] data) {
		
		send = new Thread("Send") {
			
			public void run() {
				
				DatagramPacket packets = new DatagramPacket(data, data.length, address, port);
				
				try {
					socket.send(packets);
				} catch (IOException e) {
				
					e.printStackTrace();
					
					String message = new String(packets.getData());
					
					talk("Message Sent : " + message);
				}
			}
			
		}; send.start();
	}
	
	public static void main(String[] args) throws SocketException, UnknownHostException {
		
		talk("Attempting connection");
		
		talk("Plz input ur name");
		
		scan = new Scanner(System.in);
		
		name = scan.nextLine();
		
		UDPClient client = new UDPClient("localhost", 1234, name);
		
		talk("You are now connected");
		
		int i = 1;
		
		while(i != 0) {
			
			String message = scan.nextLine();
			
			String[] keywords = {"/p/", "/c/", "/createSV/", "/r/"};
						
			
			for(String key: keywords) {
				
				if(!message.startsWith(key)) {
					
					message = "/m/" + message + "/e/";
					
				} 
			}
					
			client.send(message.getBytes());
			
			
			talk("Message sent : " + message.split("/m/|/e/")[1]);		
		}
		
		scan.close();
	}
	
	private static void talk(String text) {
		System.out.println(text);
	}

}
