package feras.test;

import junit.framework.Assert;

import org.junit.Test;

import feras.calculator.Calculator;
import feras.calculator.CalculatorFactory;


public class TestSubtractOperation {
	
	@Test
	public void testSubtractSimplestOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.subtract("1", "0");
		Assert.assertEquals("resultado esperado", "1", result);
	}
	
	@Test
	public void testSubtractStillASimpleOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.subtract("1", "1");
		Assert.assertEquals("resultado esperado", "0", result);
	}
	
	@Test
	public void testSubtractSomeSimpleOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.subtract("100", "100");
		Assert.assertEquals("resultado esperado", "0", result);
	}
	
	@Test
	public void testSubtractNotSoSimpleOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.subtract("13", "5");
		Assert.assertEquals("resultado esperado", "8", result);
	}
	
	@Test
	public void testSubtractALittleComplexOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.subtract("1", "2");
		Assert.assertEquals("resultado esperado", "-1", result);
	}
		
	@Test
	public void testSubtractMoreComplexOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.subtract("100", "200");
		Assert.assertEquals("resultado esperado", "-100", result);
	}
	
	@Test
	public void testSubtractMoreComplexOperation2(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.subtract("10", "99");
		Assert.assertEquals("resultado esperado", "-89", result);
	}
	
	@Test
	public void testSubtractComplexOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.subtract("878797887", "782221");
		Assert.assertEquals("resultado esperado", "878015666", result);	
	}
	
	@Test
	public void testSubtractFuckingComplexOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.subtract("878797887", "7822219898989889");
		Assert.assertEquals("resultado esperado", "-7822219020192002", result);
	}
	
}
