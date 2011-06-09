package feras.test;

import junit.framework.Assert;

import org.junit.Test;

import feras.calculator.Calculator;
import feras.calculator.CalculatorFactory;


public class TestBasicOperations {
	
	@Test
	public void testSubtractPNOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.subtract("1", "-1");
		Assert.assertEquals("resultado esperado", "2", result);			
	}
	
	@Test
	public void testSubtractNNOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.subtract("-1", "-1");
		Assert.assertEquals("resultado esperado", "0", result);			
	}
	
	@Test
	public void testSubtractNPOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.subtract("-1", "1");
		Assert.assertEquals("resultado esperado", "-2", result);			
	}
	
	@Test
	public void testSubtractPPOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.subtract("1", "1");
		Assert.assertEquals("resultado esperado", "0", result);			
	}
	
	@Test
	public void testAddPNOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.add("1", "-1");
		Assert.assertEquals("resultado esperado", "0", result);			
	}
	
	@Test
	public void testAddNNOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.add("-1", "-1");
		Assert.assertEquals("resultado esperado", "-2", result);			
	}
	
	@Test
	public void testAddNPOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.add("-1", "1");
		Assert.assertEquals("resultado esperado", "0", result);			
	}
	
	@Test
	public void testAddPPOperation(){
		Calculator c = CalculatorFactory.newCalculator();
		String result = c.add("1", "1");
		Assert.assertEquals("resultado esperado", "2", result);			
	}
}
