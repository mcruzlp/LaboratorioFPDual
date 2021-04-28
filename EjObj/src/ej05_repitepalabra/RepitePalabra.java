package ej05_repitepalabra;

public class RepitePalabra {
	//Attributes////////////////////////////////////////////
	
	String palabra = "";
	int numRep;
	
	//Methods///////////////////////////////////////////////

	public RepitePalabra(String palabra, int numRep) {
		this.palabra = palabra;
		this.numRep = numRep;
	}

	@Override
	public String toString() {
		String mifrase = palabra + "\t";
		for	(int i = 0; i < numRep; i++) {
			mifrase += palabra + "\t";
		}
		return mifrase;
	}
	
	
	
}
