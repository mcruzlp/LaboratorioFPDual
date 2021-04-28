package ej03_cuentaKM;

public class Ej03_cuentaKM {

	public static void main(String[] args) {
		
		CuentaKM cocheLuis = new CuentaKM(0);
		CuentaKM cocheJuan = new CuentaKM(0);

		cocheLuis.recorre(30);
		cocheJuan.recorre(40);
		
		System.out.println("El coche de Luis ha recorrido " + cocheLuis.getKilometraje() + " km");
		System.out.println("El coche de Juan ha recorrido " + cocheJuan.getKilometraje() + " km");
		System.out.println("Se han realizado " + CuentaKM.getTotalViajes() + " viajes");
	}

}
