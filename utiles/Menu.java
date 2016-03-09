/**
 * @author alvaro
 * @version 1.0
 */

package utiles;
import utiles.Teclado;

public class Menu {
	private String titulo;
	private String [] opciones;
	private int numero;
	
	public Menu(String titulo, String[] opciones){
		this.titulo=titulo;
		setOpciones(opciones);
		setNumeroOpciones(opciones);
	}
	
	private void setOpciones(String [] opciones){
		int i=0;
		this.opciones= new String[opciones.length+1]; 
		for(String opcion:opciones){
			this.opciones[i++]=opcion;
		}
		this.opciones[i]="Salir";
	}
	
	private void setNumeroOpciones(String [] opciones){
		this.numero=opciones.length+2;
	}
	
	/**
	 * Lee el número de opciones del menú
	 * @return
	 */
	
	public int getNumeroOpciones() {
		return numero;
	}

	/**
	 * Muestra el menú
	 */
	
	public void mostrarMenu(){
		System.out.println(titulo+"\n");
		for(int i=1;i<numero;i++){
			System.out.println(i + ". " + opciones[i-1]);
		}
	}
	
	/**
	 * Lee la opción introducida por el usuario
	 * @return opcion
	 */
	
	public int recogeOpcionValida(){
		int opcion;
		
		do{
			opcion=Teclado.leerEntero("\nIntroduzca una opción valida: ");
			if(opcion<1 || opcion>numero){
				System.out.println("No ha introducido una opcion valida. ");
			}
		}while(opcion<1 || opcion>numero);
		
		return opcion;
	}
	
	/**
	 * Muestra el menú y recoge una opción válida
	 * @return opción válida escogida
	 */
	public int gestionarMenu(){
		mostrarMenu();
		return recogeOpcionValida();
		
	}
}