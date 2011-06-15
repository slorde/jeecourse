package feras.test;

import org.junit.Test;

import feras.calculator.CalculatorFactory;

public class TestCalculatorFactory {

	@Test
	public void instantiationTest() {
		CalculatorFactory.newCalculator();// load("feras.calculator.CalculatorOfTheBeasts").newCalculator();
	}
}
