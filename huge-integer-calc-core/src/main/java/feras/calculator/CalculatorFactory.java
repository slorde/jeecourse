package feras.calculator;


public class CalculatorFactory {

	private static Class<Calculator> currentImpl;
	
	static {
		
		try {
			currentImpl = (Class<Calculator>) Class.forName("feras.calculator.CalculatorOfTheBeasts");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public static Calculator newCalculator() {
		try {
			return currentImpl.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
