package feras.test;

import junit.framework.Assert;

import org.junit.Test;

import feras.calculador.Calculator;
import feras.calculator.CalculatorDosFeras;


public class TestBasicOperations {
	
	@Test
	public void testSubtractPNOperation(){
		Calculator c = new CalculatorDosFeras();
		String result = c.subtract("1", "-1");
		Assert.assertEquals("resultado esperado", "2", result);			
	}
	
	@Test
	public void testSubtractNNOperation(){
		Calculator c = new CalculatorDosFeras();
		String result = c.subtract("-1", "-1");
		Assert.assertEquals("resultado esperado", "0", result);			
	}
	
	@Test
	public void testSubtractNPOperation(){
		Calculator c = new CalculatorDosFeras();
		String result = c.subtract("-1", "1");
		Assert.assertEquals("resultado esperado", "-2", result);			
	}
	
	@Test
	public void testSubtractPPOperation(){
		Calculator c = new CalculatorDosFeras();
		String result = c.subtract("1", "1");
		Assert.assertEquals("resultado esperado", "0", result);			
	}
	
	@Test
	public void testAddPNOperation(){
		Calculator c = new CalculatorDosFeras();
		String result = c.add("1", "-1");
		Assert.assertEquals("resultado esperado", "0", result);			
	}
	
	@Test
	public void testAddNNOperation(){
		Calculator c = new CalculatorDosFeras();
		String result = c.add("-1", "-1");
		Assert.assertEquals("resultado esperado", "-2", result);			
	}
	
	@Test
	public void testAddNPOperation(){
		Calculator c = new CalculatorDosFeras();
		String result = c.add("-1", "1");
		Assert.assertEquals("resultado esperado", "0", result);			
	}
	
	@Test
	public void testAddPPOperation(){
		Calculator c = new CalculatorDosFeras();
		String result = c.add("1", "1");
		Assert.assertEquals("resultado esperado", "2", result);			
	}
}
