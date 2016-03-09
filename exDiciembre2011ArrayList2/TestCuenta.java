package exDiciembre2011ArrayList2;

import exDiciembre2011ArrayList2.Banco;
import utiles.Menu;
import utiles.Teclado;

public class TestCuenta {
	static private Menu menuPPAL = null;
	static private Menu menuPER = null;
	static private Menu menuCC = null;

	public static void main(String[] args) throws Exception {
		Banco banco = new Banco("Santander");

		String dni;
		int num;
		int opcion = 0;
		int opcion1 = 0;
		int opcion2 = 0;

		// CREAR MENU PRINCIPAL
		menuPPAL = crearMenuPPAL(menuPPAL);
		// CREAR MENU PERSONAS
		menuPER = crearMenuPER(menuPER);
		// CREAR MENU CUENTAS CORRIENTES
		menuCC = crearMenuCC(menuCC);

		do {
			opcion = menuPPAL.gestionarMenu();
			switch (opcion) {
			case 1:
				do {
					opcion1 = menuPER.gestionarMenu();
					switch (opcion1) {
					case 1:
						dni = Teclado.leerCadena("Introduce DNI del titular: ");
						if (!comprobarDNI(dni)) {
							System.out.println("No has introducido un DNI válido.");
						} else {
							if (!buscarPersona(dni, banco))
								crearPersona(dni, banco);
							else {
								System.out.println("Esta persona ya existe");
							}
						}
						break;
					case 2:
						dni = Teclado.leerCadena("Introduce DNI del titular: ");
						if (!comprobarDNI(dni)) {
							System.out.println("No has introducido un DNI válido.");
						} else {
							if (buscarPersona(dni, banco))
								modificarDireccion(dni, banco);
							else {
								System.out.println("Esta persona no existe");
							}
						}
						break;
					case 3:
						dni = Teclado.leerCadena("Introduce DNI del titular: ");
						if (!comprobarDNI(dni)) {
							System.out.println("No has introducido un DNI válido.");
						} else {
							if (buscarPersona(dni, banco))
								mostrarPersona(dni, banco);
							else {
								System.out.println("Esta persona no existe");
							}
						}
						break;
					case 4:
						mostrarPersonas(banco);
						break;
					case 5:
						System.out.println("Volviendo al Menú Principal.");
						break;
					default:
						System.out.println("Por favor, introduce una opción válida. ");
						break;
					}
				} while (opcion1 != 5);
				break;

			case 2:
				do {
					opcion2 = menuCC.gestionarMenu();
					switch (opcion2) {
					case 1:
						char aux = ' ';
						do {
							aux = Teclado.leerCaracter("¿Es usted nuevo cliente? S/N: ");
							if (aux == 's' || aux == 'S') {
								nuevoCliente(banco);
							} else if (aux == 'N' || aux == 'n') {
								antiguoCliente(banco);
							} else {
								System.out.println("Por favor, introduce una opción valida. ");
							}
						} while (aux != 'S' && aux != 's' && aux != 'N' && aux != 'n');
						break;
					case 2:
						ingreso(banco);
						break;
					case 3:
						reintegro(banco);
						break;
					case 4:
						tranferir(banco);
						break;
					case 5:
						num = Teclado.leerEntero("Introduce número de cuenta: ");
						if (!banco.buscarCuenta(num)) {
							System.out.println("\nNo exite cuenta. \n");
						} else {
							mostrarCuenta(num, banco);
						}
						break;
					case 6:
						mostrarCuentas(banco);
						break;
					case 7:
						System.out.println("Volviendo al Menú Principal.");
						break;
					default:
						System.out.println("Por favor, introduce una opción válida. ");
						break;
					}
				} while (opcion2 != 7);
				break;

			case 3:
				System.out.println("Saliendo del programa...");
				break;

			default:
				System.out.println("Por favor, introduce una opción válida. ");
				break;
			}
		} while (opcion != 3);
	}
	
	//----------------------------------------------------------------------------
	
	/**
	 * CREAR MENU PRINCIPAL
	 * 
	 * @param menuPPAL
	 * @return
	 */

	private static Menu crearMenuPPAL(Menu menuPPAL) {
		String[] opcionesMP = { "Menu Personas", "Menu Cuentas" };
		menuPPAL = new Menu("**Menu Principal", opcionesMP);
		return menuPPAL;
	}

	/**
	 * CREAR MENU PERSONA
	 * 
	 * @param menuPER
	 * @return
	 */

	private static Menu crearMenuPER(Menu menuPER) {
		String[] opcionesPER = { "Crear una persona nueva", "Modificar direccion", "Mostrar Persona",
				"Mostrar Personas" };
		menuPER = new Menu("**Menu Personas", opcionesPER);
		return menuPER;
	}

	/**
	 * METODO QUE SIRVE PARA REINTEGRAR DINERO EN UNA CUENTA
	 * 
	 * @param banco
	 * @throws NumerosRojosException
	 */
	
	private static void reintegro(Banco banco) throws NumerosRojosException {
		int num;
		num = Teclado.leerEntero("Introduce número de cuenta: ");
		if (!banco.buscarCuenta(num)) {
			System.out.println("\nNo exite cuenta. \n");
		} else {
			banco.reintegrar(num, Teclado.leerEntero("Introduce una cantidad: "));
		}
	}

	/**
	 * METODO QUE SIRVE PARA INGRESAR DINERO EN UNA CUENTA
	 * 
	 * @param banco
	 * @throws NumerosRojosException
	 */
	
	private static void ingreso(Banco banco) throws NumerosRojosException {
		int num;
		num = Teclado.leerEntero("Introduce número de cuenta: ");
		if (!banco.buscarCuenta(num)) {
			System.out.println("\nNo exite cuenta. \n");
		} else {
			banco.ingresar(num, Teclado.leerEntero("Introduce una cantidad: "));
		}
	}

	/**
	 * METODO PARA TRANSFERIR DINERO DE UNA CUENTA A OTRA
	 * 
	 * @param banco
	 * @throws NumerosRojosException
	 */
	
	private static void tranferir(Banco banco) throws NumerosRojosException{
		int num = Teclado.leerEntero("Introduce número de cuenta origen: ");

		if (!banco.buscarCuenta(num)) {
			System.out.println("\nNo exite cuenta. \n");
			return;
		}
		int num2 = Teclado.leerEntero("Introduce número de cuenta destino: ");

		if (!banco.buscarCuenta(num2)) {
			System.out.println("\nNo exite cuenta. \n");
			return;
		}
		banco.transferir(num, num2, Teclado.leerEntero("Introduce una cantidad: "));
	}
	
	/**
	 * METODO QUE SIRVE PARA CREAR UNA CUENTA A PARTIR DE UN CLIENTE EXISTENTE
	 * 
	 * @param banco
	 * @throws NumerosRojosException
	 */

	private static void antiguoCliente(Banco banco) throws NumerosRojosException {
		String dni;
		dni = Teclado.leerCadena("Introduce DNI del titular: ");
		if (!comprobarDNI(dni)) {
			System.out.println("No has introducido un DNI válido.");
		} else {
			if (!banco.buscarPersona(dni)) {
				System.out.println("\nNo existe esta persona. \n");
			} else {
				Persona persona = retornaPersona(dni, banco);
				crearCuenta(persona, Teclado.leerEntero("Introduce saldo inicial: "), banco);
			}
		}
	}

	/**
	 * METODO QUE SIRVE PARA CREAR UNA CUENTA DE UN CLIENTE NUEVO
	 * 
	 * @param banco
	 * @throws NumerosRojosException
	 */

	private static void nuevoCliente(Banco banco) throws NumerosRojosException {
		String dni = Teclado.leerCadena("Introduce DNI del titular: ");
		if (!comprobarDNI(dni)) {
			System.out.println("No has introducido un DNI válido.");
		} else {
			if (banco.buscarPersona(dni)) {
				System.out.println("\nYa existe esta persona. \n");
			} else {
				Persona persona = crearPersona(dni, banco);
				crearCuenta(persona, Teclado.leerEntero("Introduce saldo inicial: "), banco);
			}
		}
	}

	/**
	 * CREAR MENU CUENTA CORRIENTE
	 * 
	 * @param menuCC
	 * @return
	 */

	private static Menu crearMenuCC(Menu menuCC) {
		String[] opcionesCC = { "Crear Cuenta Nueva", "Ingreso", "Reintegro", "Trasferencia", "Mostrar Cuenta",
				"Mostrar Cuentas" };
		menuCC = new Menu("**Menu Personas", opcionesCC);
		return menuCC;
	}

	/**
	 * METODO QUE COMPRUEBA SI EL DNI ES VALIDO
	 * 
	 * @param dni
	 * @return
	 */

	private static boolean comprobarDNI(String dni) {
		if (!Persona.comprobarDNI(dni)) {
			return false;
		}
		return true;
	}

	/**
	 * METODO QUE SIRVE PARA BUSCAR UNA PERSONA
	 * 
	 * @param dni
	 * @param banco
	 * @return
	 */

	private static boolean buscarPersona(String dni, Banco banco) {
		if (banco.buscarPersona(dni)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * METODO QUE SIRVE PARA RETORNAR LA PERSONA
	 * 
	 * @param dni
	 * @param banco
	 * @return
	 */

	private static Persona retornaPersona(String dni, Banco banco) {
		return banco.retornaPersona(dni);
	}

	/**
	 * METODO QUE SIRVE PARA CREAR UNA PERSONA
	 * 
	 * @param dni
	 * @param banco
	 */

	private static Persona crearPersona(String dni, Banco banco) {
		Persona persona = new Persona(Teclado.leerCadena("Introduzca nombre del titular: "), dni,
				Teclado.leerCadena("Introduzca dirección del titular: "));
		banco.crearPersona(persona);
		return persona;
	}

	/**
	 * METODO QUE SIRVE PARA MODIFICAR LA DIRECCION DE UNA PERSONA CONCRETA
	 * 
	 * @param dni
	 * @param banco
	 */

	private static void modificarDireccion(String dni, Banco banco) {
		banco.modificarDireccion(dni, Teclado.leerCadena("Introduce una nueva dirección: "));
	}

	/**
	 * METODO QUE SIRVE PARA MOSTRAR UNA PERSONA DETERMINADA
	 * 
	 * @param dni
	 * @param banco
	 */

	private static void mostrarPersona(String dni, Banco banco) {
		System.out.println(banco.mostrarPersona(dni));
	}

	/**
	 * METODO QUE SIRVE PARA MOSTRAR TODAS LAS PERSONAS DEL ARRAYLIST
	 * 
	 * @param banco
	 */

	private static void mostrarPersonas(Banco banco) {
		String clientes;
		clientes = banco.mostrarPersonas();
		System.out.println(clientes);
	}

	/**
	 * METODO QUE SIRVE PARA CREAR UNA NUEVA CUENTA
	 * 
	 * @param persona
	 * @param saldo
	 * @param banco
	 * @throws NumerosRojosException
	 */

	private static void crearCuenta(Persona persona, int saldo, Banco banco) throws NumerosRojosException {
		Cuenta cuenta = new Cuenta(persona, saldo);
		banco.crearCuenta(cuenta);
	}

	/**
	 * METODO QUE SIRVE PARA MOSTRAR UNA CUENTA
	 * 
	 * @param n
	 * @param banco
	 */

	private static void mostrarCuenta(int n, Banco banco) {
		System.out.println(banco.mostrarCuenta(n));
	}

	/**
	 * METODO QUE SIRVE PARA MOSTRAR TODAS LAS CUENTAS DEL ARRAYLIST
	 * 
	 * @param banco
	 */

	private static void mostrarCuentas(Banco banco) {
		String cuentas;
		cuentas = banco.mostrarCuentas();
		System.out.println(cuentas);
	}
}
