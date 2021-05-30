/**
*
* Ejercicio 4.
* 
* Hacer una clase que reciba una palabra e imprima un saludo con esta palabra.
* Ejemplo: si se recibe como parámetro la palabra “mundo”, se debe imprimir
* “Hola Mundo”.
* 
*/


package ej04_holamundo;

import java.util.Scanner;

public class Ej04_holamundo {

	public static void main(String[] args) {
		
		System.out.print("Introduzca una palabra: ");
		Scanner s = new Scanner(System.in);
		String palabra = s.nextLine();
		
		Saluda misaludo = new Saluda(palabra);
		
		System.out.println(misaludo);
	}

}
