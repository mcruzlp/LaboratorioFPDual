package ej06_imprime;

import java.util.Scanner;
/**
*
* Ejercicio 6.
* 
* Hacer una clase que imprima todos los parámetros que reciba de forma
* concatenada en una sola línea.
* 
*/
public class Ej06_imprime {

	public static void main(String[] args) {
		
		boolean finDatos;
		

	    Scanner s = new Scanner(System.in);

	    do {
	      check = true;

	      System.out.print("Introduzca un número par: ");//condición que se pide
	      numIntroducido = Integer.parseInt(s.nextLine());

	      if (numIntroducido % 2 != 0) { //condición que hay que comprobar
	        System.out.println("Lo siento. El número no es par.");
	        System.out.println("Vuelva a intentarlo.");
	        check = false;
	      }
	    } while (!check);
		
		imprime linea = new imprime();
		System.out.println(linea);

	}
	
	public static void compruebaSiDatoCorrecto(int num) {
	    
	    boolean check;
	    int numIntroducido;

	    Scanner s = new Scanner(System.in);

	    do {
	      check = true;

	      System.out.print("Introduzca un número par: ");//condición que se pide
	      numIntroducido = Integer.parseInt(s.nextLine());

	      if (numIntroducido % 2 != 0) { //condición que hay que comprobar
	        System.out.println("Lo siento. El número no es par.");
	        System.out.println("Vuelva a intentarlo.");
	        check = false;
	      }
	    } while (!check);
	  }

}
