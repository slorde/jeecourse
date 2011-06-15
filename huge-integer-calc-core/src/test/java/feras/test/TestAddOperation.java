package feras.test;

import junit.framework.Assert;

import org.junit.Test;

import feras.calculator.Calculator;
import feras.calculator.CalculatorFactory;


public class TestAddOperation {

	@Test
	public void testAddSimplestOperation(){
		Calculator c = createCalculator();
		String result = c.add("1", "0");
		Assert.assertEquals("resultado esperado", "1", result);
	}

	private Calculator createCalculator() {
		Calculator c = CalculatorFactory.newCalculator(); //load("feras.calculator.CalculatorOfTheBeasts").newCalculator();
		return c;
	}
	
	@Test
	public void testAddSimpleOperation(){
		Calculator c = createCalculator();
		String result = c.add("1", "1");
		Assert.assertEquals("resultado esperado", "2", result);
	}
	
	@Test
	public void testAddLessSimpleOperation(){
		Calculator c = createCalculator();
		String result = c.add("9", "1");
		Assert.assertEquals("resultado esperado", "10", result);
	}
	
	@Test
	public void testAddABitComplexOperation(){
		Calculator c = createCalculator();
		String result = c.add("99", "1");
		Assert.assertEquals("resultado esperado", "100", result);
	}
	
	@Test
	public void testAddAComplexOperation(){
		Calculator c = createCalculator();
		String result = c.add("12345", "987654321111");
		Assert.assertEquals("resultado esperado", "987654333456", result);
	}

	@Test
	public void testAddAFreakinComplexOperation(){
		Calculator c = createCalculator();
		String result = c.add("12345564645465546546654456654654546654546465654546456454545664456456445645456456456456456", 
							  "98765432111145691237890417895409871598875128901234571293841329804712390237849023234198074312223872314234978");
		Assert.assertEquals("resultado esperado", "98765432111145691250235982540875418145529585555889117948387795459258846692394687690654519957680328770691434", result);
	}
	
}
