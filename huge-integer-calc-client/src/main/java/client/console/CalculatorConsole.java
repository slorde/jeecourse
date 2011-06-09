package client.console;
import feras.calculator.CalculatorFactory;

public class CalculatorConsole {

	public static void main(String[] args) {
		
		if (args.length != 3) {
			System.out.println("Usage: CalculatorConsole number operator number \n fuking asshole!");
			return;
		}
		String result = "";
		switch (args[1].charAt(0)) {
		case '+':		
			result = CalculatorFactory.newCalculator().add(args[0], args[2]);
			break;
		case '-':
			result = CalculatorFactory.newCalculator().subtract(args[0], args[2]);
			break;
		case '=':
			result = CalculatorFactory.newCalculator().compareTo(args[0], args[2]).toString();
			break;

		default:
			System.out.println("Congratulations! You've manage to input a wrong operator. \n Only accept: '+' '-' '=' ");
			break;
		}
		
		System.out.println(result);
	}
	
}
