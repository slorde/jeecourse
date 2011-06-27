package feras.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import feras.calculator.Calculator;
import feras.hostRepository.ServerInfo;
import feras.proxy.CalculatorClientProxy;

public class CalculatorServer {

	private ServerSocket ss = null;
	
	public CalculatorServer() {
		try {
			ss = new ServerSocket(8092);			
			
			registerService();						
			
			while (true) {
				Socket socket = ss.accept();
				System.out.println("Start communication with socket " + socket.getPort());
				newThreadForCommunicationWithSocket(socket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void registerService() throws UnknownHostException,
			IOException {
		Socket locatorSocket = new Socket("127.0.0.1", 8089);
		ObjectOutputStream oos = new ObjectOutputStream(locatorSocket.getOutputStream());
		oos.writeObject(new ServerInfo(ss.getInetAddress(), Calculator.class, 8089));
	}

	private void newThreadForCommunicationWithSocket(final Socket socket) {
		Thread t = new Thread(new CalculatorClientProxy(socket));
		t.start();
	}

	public static void main(String[] args) {
		new CalculatorServer();
	}
}
