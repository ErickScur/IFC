package agenda;

public class Email {
	private String email;
	private String rotulo;
	
	public Email(String email, String rotulo) {
		try {
			if(this._validarEmail(email))
				this.email = email;
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.rotulo = rotulo;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	//Método para verificação interna da classe e tratamento de exceção
	private boolean _validarEmail(String email) throws Exception {
		if(!isValid(email))
			throw new Exception("Email Invalido");
		return true;
	}
	//Método para verificação externa da classe, sem tratamento de exceção
	public static boolean isValid(String email) {
		if(!email.contains("@"))
			return false;
		if(!email.contains("."))
			return false;
		return true;
	}
}
