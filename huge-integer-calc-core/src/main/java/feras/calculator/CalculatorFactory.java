package feras.calculator;

import java.rmi.RemoteException;



public abstract class CalculatorFactory {

	private CalculatorFactory() {}

	public static Calculator newCalculator() {
		try {
			return new CalculatorOfTheBeasts();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
