package feras.calculator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Calculator c = (Calculator) Naming.lookup("//localhost:1099/Calculator");
		
		System.out.println("1 + 2 = " + c.add("1", "2"));
		
	}
	
}
