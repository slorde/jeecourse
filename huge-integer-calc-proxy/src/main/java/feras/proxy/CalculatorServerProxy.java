package feras.proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import feras.calculator.Calculator;
import feras.hostRepository.ServerInfo;

public class CalculatorServerProxy implements Calculator {

	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;

	public CalculatorServerProxy() {
		try {
			ServerInfo serverInfo = getServerLocation();
			Socket socket = new Socket(serverInfo.getInetAddress(), serverInfo.getPort());
			oos  = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private ServerInfo getServerLocation() {	
		try {
			Socket locatorSocket = new Socket("127.0.0.1", 8089);		
			ObjectOutputStream locatorOos;
			locatorOos = new ObjectOutputStream(locatorSocket.getOutputStream());
			ObjectInputStream locatorOis = new ObjectInputStream(locatorSocket.getInputStream());
			locatorOos.writeObject(new ServerInfo(null, Calculator.class, null));
			
			return (ServerInfo) locatorOis.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String add(String leftTerm, String rightTerm) {
		try {
			oos.writeObject(new OperationDTO(leftTerm, rightTerm, "+"));
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return readString();
	}

	private String readString(){
		try {
			return (String)ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String subtract(String leftTerm, String rightTerm) {
		try {
			oos.writeObject(new OperationDTO(leftTerm, rightTerm, "-"));
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return readString();
	}

	@Override
	public Integer compareTo(String leftTerm, String rightTerm) {
		try {
			oos.writeObject(new OperationDTO(leftTerm, rightTerm, "="));
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(readString());
	}

	public static void main(String[] args) {		
		CalculatorServerProxy calculatorProxy = new CalculatorServerProxy();
		System.out.println(calculatorProxy.add("1", "1"));		
		System.out.println(calculatorProxy.add("1", "2"));
		System.out.println(calculatorProxy.subtract("1", "1"));
	}
}
