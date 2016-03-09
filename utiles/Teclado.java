package utiles;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Permite lectura desde teclado
 */
public class Teclado {

	/**
	 * Lee un carácter del teclado
	 * 
	 * @return carácter introducido por el usuario
	 */
	public static char leerCaracter() {
		char caracter;
		try {
			caracter = leerCadena().charAt(0);
		} catch (Exception e) {
			caracter = 0;
		}
		return caracter;
	}

	/**
	 * Lee un carácter del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return carácter introducido por el usuario
	 */
	public static char leerCaracter(String msj) {
		System.out.println(msj);
		return leerCaracter();
	}

	/**
	 * Lee una cadena del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return cadena introducida por el usuario
	 */
	public static String leerCadena(String msj) {
		System.out.println(msj);
		return leerCadena();
	}

	/**
	 * Lee una cadena del teclado
	 * 
	 * @return cadena introducida por el usuario
	 */

	public static String leerCadena() {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(
				System.in));
		String cadena;
		try {
			cadena = bReader.readLine(); // Lee una línea de texto (hasta intro)
		} catch (Exception e) {
			cadena = "";
		}
		return cadena;
	}

	/**
	 * Lee un entero del teclado
	 * 
	 * 
	 * @return entero introducido por el usuario
	 */
	public static int leerEntero() {
		int x;
		try {
			x = Integer.parseInt(leerCadena().trim()); // Quita los espacios del
														// String y convierte a
														// int
		} catch (Exception e) {
			x = 0;
		}
		return x;
	}

	/**
	 * Lee una entero del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return entero introducida por el usuario
	 */
	public static int leerEntero(String msj) {
		System.out.println(msj);
		return leerEntero();
	}

	/**
	 * Lee un decimal del teclado
	 * 
	 * @return decimal introducido por el usuario
	 */
	public static double leerDecimal() {
		double x;
		try {
			x = Double.parseDouble(leerCadena().trim()); // Quita los espacios
															// del String y
															// convierte a
															// double
		} catch (Exception e) {
			x = 0;
		}
		return x;
	}

	/**
	 * Lee una decimal del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return decimal introducida por el usuario
	 */
	public static double leerDecimal(String msj) {
		System.out.println(msj);
		return leerDecimal();
	}
	
	/**
	 * Muestra la longitud de la cadena
	 * 
	 * @param cadena
	 * 			cadena introducida por el usuario
	 * @return longitud de la cadena
	 */
	public static void mostrarLongitud(String msj, String cadena){
		System.out.println(msj + ": " + cadena.length());
	}
	
	/**
	 * Devuelve las veces que se ha repetido un caracter en la cadena
	 * 
	 * @param cadena
	 * 			cadena introducida por el usuario
	 * @param caracter
	 * 			caracter introducido por el usuario
	 * @return cont de la cadena
	 */
	public static int contarRepeticion(char caracter, String cadena){
		int cont=0;
		for(int i=0; i<cadena.length()-1; i++){
			if(caracter==cadena.charAt(i)){
				cont++;
			}
		}
		return cont;
	}
	
	/**
	 * Muestra la cadena invertida
	 * 
	 * @param msj
	 * @param cadena
	 */
	public static void mostrarInvertida(String msj, String cadena){
		String cadenainvertida = "";
		
		System.out.print(msj);
		
		for (int i=cadena.length()-1; i>=0; i--){
			cadenainvertida = cadenainvertida + cadena.charAt(i);
		}
		
		System.out.println(cadenainvertida + "'");
	}
	
	/**
	 * convierte la cadena a mayusculas
	 * 
	 * @param cadena
	 * @return cadena en mayusculas
	 */
	public static String convertirMayusculas(String cadena){
		return cadena.toUpperCase();
	}
	
	/**
	 * Muestra el numero de palabras que tiene una cadena
	 * 
	 * @param cadena
	 */
	public static void numeroPalabras(String cadena){
		StringTokenizer st = new StringTokenizer(cadena);
	    System.out.println("La cadena tiene " + st.countTokens() + " palabras.");
	}
	
	/**
	 * muestra si una cadena es palindromo
	 * 
	 * @param cadena
	 */
	public static void palindromo(String cadena){
		int i=0, j=cadena.length()-1, cont=0;
		while(i<j){
			if(cadena.charAt(i)!=cadena.charAt(j)){
				cont++;
			}
			i++;
			j--;
		}
		if(cont!=0){
			System.out.println("No es un palindromo. ");
		}
		else{
			System.out.println("Es un palindromo. ");
		}
	}
}