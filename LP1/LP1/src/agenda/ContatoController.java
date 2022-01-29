package agenda;

import javax.swing.JOptionPane;

public class ContatoController {
	public ContatoController() {
		
	}
	public static void addTelefone(Contato contato) {
		String rotuloTelefone = "";
		String numero = "";
		try {
			rotuloTelefone = JOptionPane.showInputDialog("Informe o Rótulo do Telefone");
			if(rotuloTelefone == null)
				return;
			numero = telefoneValido();
			if(numero == null)
				return;
		}
		catch(java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(null, "a");
			return;
		}
		Telefone tel = new Telefone(numero, rotuloTelefone);
		contato.addTelefone(tel);
	}
	public static void addEmail(Contato contato) {
		String rotuloEmail = "";
		String email = "";
		try {
			rotuloEmail = JOptionPane.showInputDialog("Informe o Rótulo do Email");
			if(rotuloEmail == null)
				return;
			email = emailValido();
			if(email == null)
				return;
		}
		catch(java.lang.NullPointerException e) {
			return;
		}
		Email mail = new Email(email, rotuloEmail);
		contato.addEmail(mail);
	}
	public static void atualizacaoTelefone(Contato contato) {
		int i = selecaoTelefone(contato);
		Telefone tel = contato.getTelefoneByIndex(i);
		String rotulo = "";
		String numero = "";
		try {
			rotulo = JOptionPane.showInputDialog("Informe o Rótulo do Telefone");
			if(rotulo == null)
				return;
			numero = telefoneValido();
			if(numero == null)
				return;
		}
		catch(java.lang.NullPointerException e) {
			return;
		}
		tel.setNumero(numero);
		tel.setRotulo(rotulo);
	}
	public static void excluirTelefone(Contato contato) {
		int i = selecaoTelefone(contato);
		Telefone tel = contato.getTelefoneByIndex(i);
		int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o telefone: "+tel.getRotulo());
		if(op == 0)
			contato.excluirTelefone(i);
	}
	public static void excluirEmail(Contato contato) {
		int i = selecaoEmail(contato);
		Email email = contato.getEmailByIndex(i);
		int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o email: "+email.getRotulo());
		if(op == 0) {
			contato.excluirEmail(i);
		}
	}
	public static int selecaoEmail(Contato contato) {
		String[] emails = contato.getEmailsArray();
		return JOptionPane.showOptionDialog(null, "Seleção de Email", "Agenda",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, emails, emails[0]);
	}
	public static int selecaoTelefone(Contato contato) {
		String[] telefones = contato.getTelefonesArray();
		return JOptionPane.showOptionDialog(null, "Seleção de Telefone", "Agenda",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, telefones, telefones[0]);
	}
	public static void atualizacaoEmail(Contato contato) {
		int i = selecaoEmail(contato);
		Email email = contato.getEmailByIndex(i);
		String rotulo = "";
		String endereco = "";
		try {
			rotulo = JOptionPane.showInputDialog("Informe o Rótulo do Email");
			if(rotulo == null)
				return;
			endereco = emailValido();
			if(endereco==null)
				return;
		}
		catch(java.lang.NullPointerException e) {
			return;
		}
		email.setEmail(endereco);
		email.setRotulo(rotulo);
	}
	public static String telefoneValido() {
		Boolean telValido = false;
		String numero = "";
		try {
			while(!telValido) {
				numero = JOptionPane.showInputDialog("Informe o Número de Telefone."
						+ "\n Exemplo Valido: 49991937797");
				if(Telefone.isValid(numero))
					telValido = true;
				else
					JOptionPane.showMessageDialog(null, "Telefone Invalido!");
			}
		}
		catch(java.lang.NullPointerException e) {
			return null;
		}
		
		return numero;
	}
	public static void atualizarNome(Contato contato) {
		try {
			String nome = JOptionPane.showInputDialog("Informe o novo nome (deixe em branco para permanecer o mesmo)");
			if(nome == null)
				return;
			if(!nome.equals(""))
				contato.setNome(nome);
			String sobrenome = JOptionPane.showInputDialog("Informe o novo sobrenome (deixe em branco para permanecer o mesmo)");
			if(!sobrenome.equals(""))
				contato.setSobrenome(sobrenome);
		}
		catch(java.lang.NullPointerException e) {
			return;
		}
	}
	public static String emailValido() {
		Boolean emailValido = false;
		String email = "";
		try {
			while(!emailValido) {
				email = JOptionPane.showInputDialog("Informe o Email:");
				if(Email.isValid(email))
					emailValido = true;
				else
					JOptionPane.showMessageDialog(null, "Email Invalido");
			}
		}
		catch(java.lang.NullPointerException e) {
			return null;
		}
		return email;
	}
}
