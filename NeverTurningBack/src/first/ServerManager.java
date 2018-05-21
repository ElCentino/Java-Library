package first;

import java.net.InetAddress;

public class ServerManager {
	
	public String name;
	public InetAddress address;
	public int port;
	
	private final int ID;
	
	public ServerManager(String name, InetAddress address, int port, final int ID) {
		
		this.name = name;
		this.address = address;
		this.port = port;
		this.ID = ID;
	}
	
	public int getID() {
		return ID;
	}

}
