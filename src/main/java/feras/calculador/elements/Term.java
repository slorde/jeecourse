package feras.calculador.elements;

public class Term {

	private String representation;
	private Integer index = 0;
	private Boolean isMinor = false;
	
	public Term(String term){
		if (term.startsWith("-")) {
			isMinor = true;
		}
		representation = term.replaceFirst("-", "");
		
		index = term.length() - 1;
	}	
	public Integer nextInt(){		
		
		if (!this.hasNext())
			return 0;		
		
		return Integer.parseInt(Character.valueOf(representation.charAt(index--)).toString());
	}
	
	public boolean hasNext(){
		return index >= 0;
	}
	
	public boolean isBigger(Term t){
		return size() >= t.size();
	}
	
	public int size(){
		return representation.length();
	}
	
	@Override
	public String toString() {
		return representation;
	}
		
	public String absoluteValue() {
		return representation;
	}
	
	public Boolean isMinor(){
		return isMinor;
	}
	
}