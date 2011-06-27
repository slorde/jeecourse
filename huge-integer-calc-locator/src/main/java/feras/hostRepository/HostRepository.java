package feras.hostRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class HostRepository {

	private HashMap<Class, ServerInfo> hostByClass = new HashMap<Class, ServerInfo>();

	public HostRepository() {
		try {
			ServerSocket ss = new ServerSocket(8089);
			while (true) {
				Socket socket = ss.accept();

				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

				ServerInfo serverInfo = (ServerInfo) ois.readObject();

				if (serverInfo.getInetAddress() != null) {
					hostByClass.put(serverInfo.getServiceClass(), serverInfo);
				} else {
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(hostByClass.get(serverInfo.getServiceClass()));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new HostRepository();
	}
	

}
