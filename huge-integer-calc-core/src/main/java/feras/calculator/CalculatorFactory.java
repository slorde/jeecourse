package feras.calculator;



public abstract class CalculatorFactory {

	private CalculatorFactory() {}

	public static Calculator newCalculator() {
		return new CalculatorOfTheBeasts();
	}

}
