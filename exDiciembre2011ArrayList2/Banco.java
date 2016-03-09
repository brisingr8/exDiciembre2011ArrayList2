package exDiciembre2011ArrayList2;

import java.util.ArrayList;

public class Banco {
	private String nombre;

	Banco(String nombre) {
		setNombre(nombre);
	}

	//CREAMOS LOS DOS ARRAYLIST
	static private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	static private ArrayList<Persona> personas = new ArrayList<Persona>();

	public static ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public static void setCuentas(ArrayList<Cuenta> cuentas) {
		Banco.cuentas = cuentas;
	}

	public static ArrayList<Persona> getPersonas() {
		return personas;
	}

	public static void setPersonas(ArrayList<Persona> personas) {
		Banco.personas = personas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * METODO QUE SIRVE PARA BUSCAR PERSONAS EN EL ARRAYLIST
	 * 
	 * @param dni
	 * @return
	 */
	
	public boolean buscarPersona(String dni) {
		for (int i = 0; i < personas.size(); i++) {
			if (dni.equals(personas.get(i).getDni())) {
				return true;
			}
		}
		return false;
	}
	
//	public boolean buscarPersona(String dni) {
//		for (int i = 0; i < personas.size(); i++) {
//			if (personas.contains(dni)) {
//				return true;
//			}
//		}
//		return false;
//	}

	/**
	 * METODO QUE SIRVE PARA INTRODUCIR PERSONA EN SU ARRAYLIST
	 * 
	 * @param persona
	 */
	
	public void crearPersona(Persona persona) {
		personas.add(persona);
	}
	
	/**
	 * METODO QUE SIRVE PARA MODIFICAR LA DIRECCION DE UNA PERSONA EN CONCRETO
	 * 
	 * @param dni
	 * @param direccion
	 */
	
	public void modificarDireccion(String dni, String direccion) {
		for (int i = 0; i < personas.size(); i++) {
			if(dni.equals(personas.get(i).getDni())){
				personas.get(i).setDireccion(direccion);
			}
		}
	}

	/**
	 * METODO QUE SIRVE PARA MOSTRAR UNA PERSONA CONCRETA
	 * 
	 * @param dni
	 * @return
	 */
	
	public String mostrarPersona(String dni) {
		String string = "";

		for (int i = 0; i < personas.size(); i++) {
			if(dni.equals(personas.get(i).getDni())){
				string = personas.get(i).toString();
			}
		}
		return string;
	}

	/**
	 * METODO QUE SIRVE PARA MOSTRAR TODAS LAS PERSONAS
	 * 	
	 * @return
	 */
	
	public String mostrarPersonas() {
		String string = "";
		if(personas.isEmpty()){
			string = string + "La lista está vacía. ";
			return string;
		}
		else{
			for (int i = 0; i < personas.size(); i++) {
				string = string + "\n" + personas.get(i);
			}
			return string;
		}
	}
	//--------------------------------------------------------------------------
	/**
	 * METODO QUE SIRVE PARA BUSCAR CUENTAS EN EL ARRAYLIST
	 * 
	 * @param n
	 * @return
	 */
	
	public boolean buscarCuenta(int n) {
		for (int i = 0; i < cuentas.size(); i++) {
			if (n==cuentas.get(i).getIdentificador()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * METODO QUE SIRVE PARA INTRODUCIR CUENTA EN SU ARRAYLIST
	 * 
	 * @param persona
	 */
	
	public void crearCuenta(Cuenta cuenta) {
		cuentas.add(cuenta);
	}

	/**
	 * METODO QUE SIRVE PARA MOSTRAR UNA CUENTA DETERMINADA
	 * 
	 * @param n
	 * @return
	 */
	
	public String mostrarCuenta(int n) {
		String string = "";

		for (int i = 0; i < cuentas.size(); i++) {
			if(n==cuentas.get(i).getIdentificador()){
				string = cuentas.get(i).toString();
			}
		}
		return string;
	}
	
	/**
	 * METODO QUE SIRVE PARA MOSTRAR LAS CUENTAS
	 * 
	 * @return
	 */
	
	public String mostrarCuentas() {
		String string = "";
		if(cuentas.isEmpty()){
			string = string + "La lista está vacía. ";
			return string;
		}
		else{
			for (int i = 0; i < cuentas.size(); i++) {
				string = string + "\n" + cuentas.get(i);
			}
			return string;
		}
	}

	/**
	 * METODO QUE SIRVE PARA INGRESAR DINERO EN LA CUENTA
	 * 
	 * @param num
	 * @param cantidad
	 * @throws NumerosRojosException
	 */
	
	public static void ingresar(int num, int cantidad) throws NumerosRojosException {
		for(int i=0; i<cuentas.size(); i++){
			if(cuentas.get(i).getIdentificador()==num){
				cuentas.get(i).setSaldo(cantidad+cuentas.get(i).getSaldo());
			}
		}
	}
	
	/**
	 * METODO QUE SIRVE PARA REINTEGRAR DINERO DE LA CUENTA
	 * 
	 * @param num
	 * @param cantidad
	 * @throws NumerosRojosException
	 */
	
	public static boolean reintegrar(int num, int cantidad) throws NumerosRojosException {
		for(int i=0; i<cuentas.size(); i++){
			if(cuentas.get(i).getIdentificador()==num){
				if(cuentas.get(i).setSaldo(cuentas.get(i).getSaldo()-cantidad)){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * METODO QUE RETORNA PERSONA
	 * 
	 * @param dni
	 * @return
	 */
	
	public Persona retornaPersona(String dni) {
		Persona persona = null;
		for (int i = 0; i < cuentas.size(); i++) {
			if(dni.equals(personas.get(i).getDni())){
				persona =  personas.get(i);
			}
		}
		return persona;
	}

	/**
	 * METODO QUE SIRVE PARA TRANFERIR DINERO ENTRE DOS CUENTAS
	 * 
	 * @param num
	 * @param num2
	 * @param cantidad
	 * @throws NumerosRojosException
	 */
	
	public static void transferir(int num, int num2, int cantidad) throws NumerosRojosException {
		if(reintegrar(num, cantidad)){
			ingresar(num2, cantidad);
		}
	}
}
