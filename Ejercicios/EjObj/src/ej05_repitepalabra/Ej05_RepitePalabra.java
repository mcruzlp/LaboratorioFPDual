/**
*
* Ejercicio 5.
* 
* Hacer una clase que reciba 2 parámetros, el primero debe ser una palabra
* y el Segundo un numero. Imprimir en pantalla la palabra tantas veces el
* número indique.
* 
*/

package ej05_repitepalabra;

import java.util.Scanner;

public class Ej05_RepitePalabra {

	public static void main(String[] args) {
		System.out.print("Introduzca una palabra: ");
		Scanner s = new Scanner(System.in);
		String palabra = s.nextLine();
		
		System.out.print("Introduzca cuántas veces quiere que se repita la palabra: ");
		int numRep = Integer.parseInt(s.nextLine());
		
		RepitePalabra mifrase = new RepitePalabra(palabra, numRep);
		
		System.out.println(mifrase);
	}

}
