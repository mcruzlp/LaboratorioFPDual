package ej04_holamundo;

public class Saluda {


	String palabra = "";
	
	public Saluda(String palabra) {
		this.palabra = palabra;
	}

	@Override
	public String toString() {
		return "Hola, " + palabra;
	}
	
	
	
}
