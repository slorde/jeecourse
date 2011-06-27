package client.console;
import feras.calculator.CalculatorFactory;

public class CalculatorConsole {

	public static void main(String[] args) {
		
		if (args.length != 3) {
			System.out.println("Usage: CalculatorConsole number operator number \n fuking asshole!");
			return;
		}
		
		System.out.println(executeOperation(args[0], args[2], args[1]));
	}

	public static String executeOperation(String term1, String term2, String operation) {
		switch (operation.charAt(0)) {
		case '+':		
			return CalculatorFactory.newCalculator().add(term1, term2);			
		case '-':
			return CalculatorFactory.newCalculator().subtract(term1, term2);			
		case '=':
			return CalculatorFactory.newCalculator().compareTo(term1, term2).toString();			

		default:
			return "Congratulations! You've manage to input a wrong operator. \n Only accept: '+' '-' '=' ";
		}
	}
	
}
