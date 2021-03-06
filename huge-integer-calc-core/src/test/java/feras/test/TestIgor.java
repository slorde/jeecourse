package feras.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import feras.calculator.Calculator;
import feras.calculator.CalculatorFactory;

public class TestIgor {

	private static final String TOO_LARGE_FOR_LONG = "9223372036854775808";

	private static Calculator calc;

	@BeforeClass
	public static void configureCalculator() {
		// If you wanna change the calculator implementation, here's the place
		// to do it.
		calc = CalculatorFactory.newCalculator(); // I'll go with default
															// version
	}

	@Test
	public void compare() {
		assertEquals(-1, compare("1", "2"));
		assertEquals(1, compare("2", "1"));
		assertEquals(0, compare("1", "1"));
		assertEquals(0, compare("0", "0"));
		assertEquals(1, compare("1", "0"));
		assertEquals(-1, compare("0", "1"));
		assertEquals(-1, compare("-1", "1"));
		assertEquals(1, compare("1", "-1"));
		assertEquals(1, compare("-3", "-4"));
		assertEquals(-1, compare("-4", "-3"));
		assertEquals(0, compare(TOO_LARGE_FOR_LONG, TOO_LARGE_FOR_LONG));
		assertEquals(1, compare(TOO_LARGE_FOR_LONG + 1, TOO_LARGE_FOR_LONG));
		assertEquals(-1, compare(TOO_LARGE_FOR_LONG, 1 + TOO_LARGE_FOR_LONG));
		assertEquals(1, compare(TOO_LARGE_FOR_LONG, negate(TOO_LARGE_FOR_LONG)));
		assertEquals(-1,
				compare(negate(TOO_LARGE_FOR_LONG), TOO_LARGE_FOR_LONG));
		assertEquals(0,
				compare(negate(TOO_LARGE_FOR_LONG), negate(TOO_LARGE_FOR_LONG)));
	}

	private int compare(String left, String right) {
		return calc.compareTo(left, right);
	}

	@Test
	public void add() {
		assertEquals("7", add("3", "4"));
		assertEquals("7", add("4", "3"));
		assertEquals("1", add("0", "1"));
		assertEquals("1", add("1", "0"));
		assertEquals("0", add("0", "0"));
		assertEquals("100", add("99", "1"));
		assertEquals("100", add("1", "99"));
		assertEquals("100", add("01", "0099"));
		assertEquals("-98", add("-99", "1"));
		assertEquals("-100", add("-99", "-1"));
		assertEquals("-100", add("-000099", "-01"));
		assertEquals(TOO_LARGE_FOR_LONG, add(TOO_LARGE_FOR_LONG, "0"));
		assertEquals("0", add(TOO_LARGE_FOR_LONG, negate(TOO_LARGE_FOR_LONG)));
		assertEquals("1" + TOO_LARGE_FOR_LONG,
				add(TOO_LARGE_FOR_LONG, "10000000000000000000"));
		assertEquals(
				"-1",
				add(TOO_LARGE_FOR_LONG, TOO_LARGE_FOR_LONG,
						negate(TOO_LARGE_FOR_LONG), negate(TOO_LARGE_FOR_LONG),
						"1", "-2"));
	}

	private String add(String... operands) {
		String result = calc.add(operands[0], operands[1]);
		for (int i = 2; i < operands.length; ++i)
			result = calc.add(result, operands[i]);

		return result.toString();
	}

	@Test
	public void subtract() {
		assertEquals("1", subtract("120", "119"));
		assertEquals("119", subtract("120", "1"));
		assertEquals("-119", subtract("-120", "-1"));
		assertEquals("121", subtract("120", "-1"));
		assertEquals("-121", subtract("-120", "1"));
		assertEquals("0", subtract(TOO_LARGE_FOR_LONG, TOO_LARGE_FOR_LONG));
		assertEquals(
				"0",
				subtract(TOO_LARGE_FOR_LONG, negate(TOO_LARGE_FOR_LONG),
						TOO_LARGE_FOR_LONG, TOO_LARGE_FOR_LONG));
	}

	private String subtract(String... operands) {
		String result = calc.subtract(operands[0], operands[1]);
		for (int i = 2; i < operands.length; ++i)
			result = calc.subtract(result, operands[i]);

		return result;
	}

	private String negate(String value) {
		return "-" + value;
	}

}
