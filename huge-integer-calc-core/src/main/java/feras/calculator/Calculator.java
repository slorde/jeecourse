package feras.calculator;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {

	String add(String string, String string2) throws RemoteException;
	String subtract(String string, String string2) throws RemoteException;
	Integer compareTo(String string, String string2) throws RemoteException;

}
