package feras.proxy;

import java.io.Serializable;

public class OperationDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String term1;
	private String term2;
	private String operation;
	
	public OperationDTO(String term1, String term2, String op) {
		this.term1 = term1;
		this.term2 = term2;
		operation = op;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getOperation() {
		return operation;
	}
	public void setTerm1(String term1) {
		this.term1 = term1;
	}
	public String getTerm1() {
		return term1;
	}
	public void setTerm2(String term2) {
		this.term2 = term2;
	}
	public String getTerm2() {
		return term2;
	}		
}
