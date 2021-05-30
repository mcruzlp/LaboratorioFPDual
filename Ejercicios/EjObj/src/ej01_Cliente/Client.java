package ej01_Cliente;

public class Client {
	// Attribute /////////////////////////////
	int codClient;
	String nomClient = "";
	String apeClient = "";
	String dniClient = "";
	String tlfClient = "";

	// Methods //////////////////////////////
	// constructor*************************

	public Client(int codClient, String nomClient, String apeClient, String dniClient, String tlfClient) {
		super();
		this.codClient = codClient;
		this.nomClient = nomClient;
		this.apeClient = apeClient;
		this.dniClient = dniClient;
		this.tlfClient = tlfClient;
	}
	// getter***************************************************************

	public int getCodClient() {
		return codClient;
	}



	public String getNomClient() {
		return nomClient;
	}



	public String getApeClient() {
		return apeClient;
	}



	public String getDniClient() {
		return dniClient;
	}



	public String getTlfClient() {
		return tlfClient;
	}
	
	// setter ****************************************************************


	public void setCodClient(int codClient) {
		this.codClient = codClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public void setApeClient(String apeClient) {
		this.apeClient = apeClient;
	}

	public void setDniClient(String dniClient) {
		this.dniClient = dniClient;
	}

	public void setTlfClient(String tlfClient) {
		this.tlfClient = tlfClient;
	}


	// other methods******************************************************************

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public void compra() {

	}

	public void devuelve() {

	}

	public void encarga() {

	}

	public void anula () {
		
	}
}
