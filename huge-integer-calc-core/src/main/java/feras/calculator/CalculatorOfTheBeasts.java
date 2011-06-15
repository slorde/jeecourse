package feras.calculator;


class CalculatorOfTheBeasts implements Calculator {

	@Override
	public String add(String a, String b) {

		Term leftTerm = new Term(slayLeftZeros(a));
		Term rightTerm = new Term(slayLeftZeros(b));
		
		if (!leftTerm.isMinor() && rightTerm.isMinor())
			return subtract(leftTerm.absoluteValue(), rightTerm.absoluteValue());			
		
		if (leftTerm.isMinor() && !rightTerm.isMinor())
			return subtract(rightTerm.absoluteValue(), leftTerm.absoluteValue());
		
		if (leftTerm.isMinor() && rightTerm.isMinor())
			return "-" + add(rightTerm.absoluteValue(), leftTerm.absoluteValue());		

		String result = "";
		Integer pass = 0;
		while (leftTerm.hasNext() || rightTerm.hasNext()) {
			Integer temp = leftTerm.nextInt() + rightTerm.nextInt() + pass;
			pass = 0;
			if (temp > 9) {
				pass = 1;
				temp -= 10;
			}

			result = temp.toString() + result;
		}
		if (pass > 0)
			result = pass + result;

		return result;
	}

	@Override
	public String subtract(String a, String b) {
		Term leftTerm = new Term(slayLeftZeros(a));
		Term rightTerm = new Term(slayLeftZeros(b));
		
		if (!leftTerm.isMinor() && rightTerm.isMinor())
			return add(leftTerm.absoluteValue(), rightTerm.absoluteValue());
		
		if (leftTerm.isMinor() && rightTerm.isMinor())
			return add(a, rightTerm.absoluteValue());
		
		if (leftTerm.isMinor() && !rightTerm.isMinor())
			return "-" + add(leftTerm.absoluteValue(), rightTerm.absoluteValue());
				
		String minus = "";
		if(!leftTerm.isBigger(rightTerm)){
			Term temp = rightTerm;
			rightTerm = leftTerm;
			leftTerm = temp;
			minus = "-";
		}	

		String result = "";
		Integer borrow = 0;
		while (leftTerm.hasNext() || rightTerm.hasNext()) {
			Integer left = leftTerm.nextInt() - borrow;
			Integer right = rightTerm.nextInt();
			
			borrow = 0;
			if (left < right && leftTerm.hasNext()) {				
				borrow = 1;
				left += 10;
			}
			
			Integer temp = left - right;
			result = temp.toString() + result;
		}

		return minus + slayLeftZeros(result);
	}

	@Override
	public Integer compareTo(String a, String b) {
		String subtractResult = subtract(a, b);
		
		Integer result = 0;
		if (subtractResult.charAt(0) == '-'){
			result = -1;
		} else if( subtractResult.charAt(0) == '0') {
			result = 0;
		} else {
			result = 1;
		}
		
		
		return result;
	}

	private String slayLeftZeros(String s){
		
		String result = s.replaceFirst("[0]*", "");
		return "".equals(result) ? "0" : result;
	}
}
