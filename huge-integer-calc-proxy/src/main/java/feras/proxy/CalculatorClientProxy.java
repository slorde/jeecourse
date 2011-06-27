package feras.proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import feras.calculator.CalculatorFactory;

public class CalculatorClientProxy implements Runnable {
	private Socket socket;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;

	public CalculatorClientProxy(Socket socket) {
		this.socket = socket;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			while (true) {			
				OperationDTO operation = (OperationDTO) ois.readObject();
				System.out.println(String.format("Socket: %d operation %s %s %s", socket.getPort(), operation.getTerm1(), operation.getOperation(), operation.getTerm2()));
				
				String result = "";				
				switch (operation.getOperation().charAt(0)) {
				case '+':		
					result = CalculatorFactory.newCalculator().add(operation.getTerm1(), operation.getTerm2());
					break;
				case '-':
					result =CalculatorFactory.newCalculator().subtract(operation.getTerm1(), operation.getTerm2());
					break;
				case '=':
					result =CalculatorFactory.newCalculator().compareTo(operation.getTerm1(), operation.getTerm2()).toString();
				}
				
				System.out.println(result);
				oos.writeObject(result);
				threadSleep(2000);
			}
		} catch (SocketException e) {
			System.out.println("Socket " + socket.getPort() + " closed "
					+ e.getMessage());
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void threadSleep(Integer mili) {
		try {
			Thread.sleep(mili);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
