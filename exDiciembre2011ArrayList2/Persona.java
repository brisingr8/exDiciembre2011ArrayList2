package exDiciembre2011ArrayList2;

import java.util.regex.Pattern;

public class Persona {
	public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";

	private String titular;
	private String dni;
	private String direccion;

	Persona(String titular, String dni, String direccion) {
		super();
		setTitular(titular);
		setDni(dni);
		setDireccion(direccion);
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	private void setTitular(String titular) {
		this.titular = titular;
	}

	public String getTitular() {
		return titular;
	}

	/**
	 * Devuelve un NIF completo a partir de un DNI. Es decir, añade la letra del
	 * NIF
	 * 
	 * @param dni
	 *            dni al que se quiere añadir la letra del NIF
	 * @return NIF completo.
	 */
	static private String letraDNI(int dni) {
		return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
	}

	/**
	 * COMPRUEBA SI EL DNI ES VALIDO
	 * 
	 * @param dni
	 * @return
	 */

	static boolean comprobarDNI(String dni) {
		// REGEX
		boolean b = Pattern.matches("^\\d{8}[- ]?[A-Z&&[^IOU]]$", dni);
		if (b == true) {
			// QUITAR LETRA
			String numerosDNI = dni.substring(0, dni.length() - 1);
			// TRANSFORMAR CADENA A ENTERO
			int numEntero = Integer.parseInt(numerosDNI);

			if (dni.equals(letraDNI(numEntero))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public String toString() {
		return "Nombre del titular: " + titular + ", dirección: " + direccion + ", DNI: " + dni;
	}
}
