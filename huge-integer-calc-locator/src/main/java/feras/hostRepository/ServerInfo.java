package feras.hostRepository;

import java.io.Serializable;
import java.net.InetAddress;

public class ServerInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private InetAddress inetAddress;
	private Class serviceClass;
	private Integer port;
	
	public void setServiceClass(Class serviceClass) {
		this.serviceClass = serviceClass;
	}
	public Class getServiceClass() {
		return serviceClass;
	}
	public void setInetAddress(InetAddress inetAddress) {
		this.inetAddress = inetAddress;
	}
	public InetAddress getInetAddress() {
		return inetAddress;
	}
	
	public void setPort(Integer port) {
		this.port = port;
	}
	public Integer getPort() {
		return port;
	}

	public ServerInfo(InetAddress inetAddress, Class serviceClass, Integer port) {
		this.inetAddress = inetAddress;
		this.serviceClass = serviceClass;
		this.port = port;
	}
	
	
	
	
}
