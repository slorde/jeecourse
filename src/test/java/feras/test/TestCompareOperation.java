package feras.test;

import junit.framework.Assert;

import org.junit.Test;

import feras.calculador.Calculator;
import feras.calculator.CalculatorDosFeras;


public class TestCompareOperation {
	@Test
	public void testLeftBiggerTerm(){
		Calculator c = new CalculatorDosFeras();
		Integer result = c.compare("10", "0");
		Assert.assertEquals("resultado esperado", new Integer(1), result);
	}
	
	@Test
	public void testRightBiggerTerm(){
		Calculator c = new CalculatorDosFeras();
		Integer result = c.compare("0", "10");
		Assert.assertEquals("resultado esperado", new Integer(-1), result);
	}
	
	@Test
	public void testRigthBiggerTermComplex(){
		Calculator c = new CalculatorDosFeras();
		Integer result = c.compare("15", "18");
		Assert.assertEquals("resultado esperado", new Integer(-1), result);
	}
	
	@Test
	public void testLeftBiggerTermComplex(){
		Calculator c = new CalculatorDosFeras();
		Integer result = c.compare("150", "0");
		Assert.assertEquals("resultado esperado", new Integer(1), result);
	}	
	
	
	@Test
	public void testLeftBiggerTermMoreComplex(){
		Calculator c = new CalculatorDosFeras();
		Integer result = c.compare("1555665656569", "18988989899");
		Assert.assertEquals("resultado esperado", new Integer(1), result);
	}	

	@Test
	public void testRightBiggerTermMoreComplex(){
		Calculator c = new CalculatorDosFeras();
		Integer result = c.compare("99999999", "999999999999999999999");
		Assert.assertEquals("resultado esperado", new Integer(-1), result);
	}
	
	@Test
	public void testEqualsTerms(){
		Calculator c = new CalculatorDosFeras();
		Integer result = c.compare("999999999999999999999", "999999999999999999999");
		Assert.assertEquals("resultado esperado", new Integer(0), result);
	}
	
}
