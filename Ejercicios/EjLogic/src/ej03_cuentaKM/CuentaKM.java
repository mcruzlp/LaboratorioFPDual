package ej03_cuentaKM;

public class CuentaKM{
	
	private static int totalViajes = 0;

	public static int getTotalViajes() {
		return totalViajes;
	}
	
	private int kilometraje;
	
	public int getKilometraje() {
		return kilometraje;
	}
	
	public void recorre(int km) {
		kilometraje += km;
		totalViajes ++;
	}

	/**
	 * @param kilometraje
	 */
	public CuentaKM(int kilometraje) {
		super();
		this.kilometraje = kilometraje;
	}
	
	
}
