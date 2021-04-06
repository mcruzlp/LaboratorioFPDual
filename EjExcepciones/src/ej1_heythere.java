	import java.util.Scanner;

public class ej1_heythere {

		public static void main(String[] args) {
			System.out.print("Introduzca un número positivo: ");
			Scanner s = new Scanner(System.in);
			int numIntroducido = Integer.parseInt(s.nextLine());

			try {
				int resultado = comprueba(numIntroducido);
				System.out.println("El número introducido es: " + resultado);
			} catch (Exception e) {
				System.out.println("Error al introducir el número");
				int resultado = absoluto(numIntroducido);
				System.out.println("El valor absoluto del número introducido es: " + resultado);
			}
		}

		private static int comprueba(int numIntroducido) throws Exception {

			int resultado = 0;

			try {
				resultado = Integer.valueOf(numIntroducido);
			} catch (Exception en) {
				System.out.println("El número no es positivo");
				throw en;
			}

			return resultado != 0 ? resultado : 0;
		}

		private static int absoluto(int numIntroducido) {

			int resultado = 0;

			try {
				resultado = Integer.valueOf(numIntroducido);
			} catch (Exception en) {
				System.out.println("Error nulo");
				throw en;
			}

			return resultado != 0 ? resultado : -1*numIntroducido;
		}
	}

