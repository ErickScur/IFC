package agenda;

public class Telefone {
	private String numero;
	private String rotulo;
	
	public Telefone(String numero, String rotulo) {
		if(isValid(numero))
			this.numero = formatarTelefone(numero);
		this.rotulo = rotulo;
	}
	public Telefone() {
		
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		if(isValid(numero))
			this.numero = formatarTelefone(numero);
	}
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public static boolean isValid(String numero) {
		if(numero.length() != 11)
			return false;
		return true;
	}
	private String formatarTelefone(String numero) {
		String ddd = numero.substring(0,2);
		String n1 = numero.substring(2,7);
		String n2 = numero.substring(7);
		return "("+ddd+") "+n1+"-"+n2;
	}
}
