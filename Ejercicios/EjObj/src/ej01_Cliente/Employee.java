package ej01_Cliente;

public class Employee {
	
	// Attribute /////////////////////////////
	
	int codEmple;
	String nomEmple = "";
	String tlfEmple = "";
	
	
	// Methods //////////////////////////////
	
		// constructor*************************
	public Employee(int codEmple, String nomEmple, String tlfEmple) {
		super();
		this.codEmple = codEmple;
		this.nomEmple = nomEmple;
		this.tlfEmple = tlfEmple;
	}

		// getter ************************************************

	public int getCodEmple() {
		return codEmple;
	}


	public String getNomEmple() {
		return nomEmple;
	}


	public String getTlfEmple() {
		return tlfEmple;
	}

		// setter ******************************************************************
	public void setCodEmple(int codEmple) {
		this.codEmple = codEmple;
	}


	public void setNomEmple(String nomEmple) {
		this.nomEmple = nomEmple;
	}


	public void setTlfEmple(String tlfEmple) {
		this.tlfEmple = tlfEmple;
	}
		
	    // other methods************************
	
	public void atiente() {
		
	}
	
	public void repone() {
		
	}
	
	public void descansa() {
		
	}
}
