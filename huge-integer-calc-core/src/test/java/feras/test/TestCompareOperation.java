package feras.test;

import junit.framework.Assert;

import org.junit.Test;

import feras.calculator.Calculator;
import feras.calculator.CalculatorFactory;


public class TestCompareOperation {
	@Test
	public void testLeftBiggerTerm(){
		Calculator c = CalculatorFactory.newCalculator();
		Integer result = c.compareTo("10", "0");
		Assert.assertEquals("resultado esperado", new Integer(1), result);
	}
	
	@Test
	public void testRightBiggerTerm(){
		Calculator c = CalculatorFactory.newCalculator();
		Integer result = c.compareTo("0", "10");
		Assert.assertEquals("resultado esperado", new Integer(-1), result);
	}
	
	@Test
	public void testRigthBiggerTermComplex(){
		Calculator c = CalculatorFactory.newCalculator();
		Integer result = c.compareTo("15", "18");
		Assert.assertEquals("resultado esperado", new Integer(-1), result);
	}
	
	@Test
	public void testLeftBiggerTermComplex(){
		Calculator c = CalculatorFactory.newCalculator();
		Integer result = c.compareTo("150", "0");
		Assert.assertEquals("resultado esperado", new Integer(1), result);
	}	
	
	
	@Test
	public void testLeftBiggerTermMoreComplex(){
		Calculator c = CalculatorFactory.newCalculator();
		Integer result = c.compareTo("1555665656569", "18988989899");
		Assert.assertEquals("resultado esperado", new Integer(1), result);
	}	

	@Test
	public void testRightBiggerTermMoreComplex(){
		Calculator c = CalculatorFactory.newCalculator();
		Integer result = c.compareTo("99999999", "999999999999999999999");
		Assert.assertEquals("resultado esperado", new Integer(-1), result);
	}
	
	@Test
	public void testEqualsTerms(){
		Calculator c = CalculatorFactory.newCalculator();
		Integer result = c.compareTo("999999999999999999999", "999999999999999999999");
		Assert.assertEquals("resultado esperado", new Integer(0), result);
	}
	
	@Test
	public void testEqualsTermsWithLeftZeros(){
		Calculator c = CalculatorFactory.newCalculator();
		Integer result = c.compareTo("009", "9");
		Assert.assertEquals("resultado esperado", new Integer(0), result);
	}
	
	@Test
	public void testEqualsTermsWithLeftZerosRightTerm(){
		Calculator c = CalculatorFactory.newCalculator();
		Integer result = c.compareTo("9", "009");
		Assert.assertEquals("resultado esperado", new Integer(0), result);
	}
	
	
}
