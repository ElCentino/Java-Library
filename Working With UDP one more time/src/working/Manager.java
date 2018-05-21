package working;

import java.net.InetAddress;

public class Manager {
	
	public String name;
	public InetAddress address;
	public int port;
	public int attempts;
	
	private int ID;
	
	public Manager(String name, InetAddress address, int port, int ID) {
		
		this.name = name;
		this.address = address;
		this.port = port;
		this.ID = ID;
	}
	
	public int getID() {
		
		return ID;
	}

}
