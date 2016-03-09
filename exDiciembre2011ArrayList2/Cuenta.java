package exDiciembre2011ArrayList2;

public class Cuenta {
	private Persona persona;
	private int saldo;
	private int identificador;
	static private int contador;

	Cuenta(Persona persona, int saldo) throws NumerosRojosException {
		this.persona=persona;
		setSaldo(saldo);
		setIdentificador();
	}

	private void setIdentificador() {
		identificador = ++contador;
	}

	public int getIdentificador() {
		return identificador;
	}
	
	public Cuenta(int identificador) {
		this.identificador = identificador;
	}

	public int getSaldo(){
		return saldo;
	}
	
	protected boolean setSaldo(int saldo) throws NumerosRojosException { 
		if(saldo<0){
			throw new NumerosRojosException("Error, la cuenta no puede tener saldo negativo.");
		}
		else{
			this.saldo=saldo;
			return true;
		}
	}
		
	public String toString() {
		return "Cuenta: " + identificador + ", " + saldo +  ", " +   persona;
	}
}