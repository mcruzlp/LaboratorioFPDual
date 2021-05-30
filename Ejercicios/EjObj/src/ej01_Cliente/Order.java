package ej01_Cliente;

public class Order {
	// Attribute /////////////////////////////
	
	int codOrder;
	//int codEmple;
	//int codClient;
	String dateOrder = "";
	int numArtic;
	int cost = 0;
	
	
	// Methods //////////////////////////////
		// constructor*************************
	public Order(int codOrder, /*int codEmple, int codClient,*/String dateOrder, int numArtic, int cost) {
		super();
		this.codOrder = codOrder;
		this.dateOrder = dateOrder;
		this.numArtic = numArtic;
		this.cost = cost;
	}
		// getter******************************************************************


	public int getCodOrder() {
		return codOrder;
	}


	public String getDateOrder() {
		return dateOrder;
	}


	public int getNumArtic() {
		return numArtic;
	}


	public int getCost() {
		return cost;
	}
	
	    // setter********************************************************************
	
	public void setCodOrder(int codOrder) {
		this.codOrder = codOrder;
	}


	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}


	public void setNumArtic(int numArtic) {
		this.numArtic = numArtic;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	// other methods******************************************************************
	
	@Override
	public String toString() {
		return "Order" + codOrder + ", dateOrder=" + dateOrder + ", numArtic=" + numArtic 
				+ ", cost=" + cost;
	}
	
	public void anula() {
		
	}
	
	public void entrega() {
		
	}
	
	public void devuelve() {
		
	}
	
	
}
	
