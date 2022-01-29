package agenda;

import java.util.ArrayList;
import java.util.Date;

public class Contato {
	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	private ArrayList<Email> emails = new ArrayList<>();
	private ArrayList<Telefone> telefones = new ArrayList<>();
	
	public Contato() {
		
	}
	public Contato(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	public Contato( String nome) {
		this.nome = nome;
	}
	public Contato(String nome, String sobrenome, Date dataNascimento) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
	}
	public String[] getTelefonesArray() {
		int size = this.telefones.size();
		String[] telefones = new String[size];
		for(int i=0;i<size;i++) {
			telefones[i] = this.telefones.get(i).getRotulo();
		}
		return telefones;
	}
	public String[] getEmailsArray() {
		int size = this.emails.size();
		String[] emails = new String[size];
		for(int i=0;i<size;i++) {
			emails[i] = this.emails.get(i).getRotulo();
		}
		return emails;
	}
	
	public Telefone getTelefoneByIndex(int i) {
		try {
			return this.telefones.get(i);
		} catch(java.lang.IndexOutOfBoundsException e) {
			System.err.println("Erro: Telefone de Índice "+i+ " Não Existe");
		}catch(Exception e) {
			System.err.println("Erro: "+e.toString());
		}
		return null;
	}
	public Email getEmailByIndex(int i) {
		try {
			return this.emails.get(i);
		} catch(java.lang.IndexOutOfBoundsException e) {
			System.err.println("Erro: Emails de Índice "+i+ " Não Existe");
		}catch(Exception e) {
			System.err.println("Erro: "+e.toString());
		}
		return null;
	}
	public void excluirTelefone(int i) {
		try {
			this.telefones.remove(i);
		} catch(java.lang.IndexOutOfBoundsException e) {
			System.err.println("Erro: Telefone de Índice "+i+ " Não Existe");
		}catch(Exception e) {
			System.err.println("Erro: "+e.toString());
		}	
	}
	public void excluirEmail(int i) {
		try {
			this.emails.remove(i);
		} catch(java.lang.IndexOutOfBoundsException e) {
			System.err.println("Erro: Email de Índice "+i+ " Não Existe");
		}catch(Exception e) {
			System.err.println("Erro: "+e.toString());
		}	
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void addTelefone(Telefone telefone) {
		this.telefones.add(telefone);
	}
	public void addEmail(Email email) {
		this.emails.add(email);
	}
	public String listarTelefones() {
		String msg = "";
		for(Telefone telefone : this.telefones) {
			msg += telefone.getRotulo()+": "+telefone.getNumero()+"\n";
		}
		return msg;
	}
	public String listarEmails() {
		String msg = "";
		for(Email email : this.emails) {
			msg += email.getRotulo()+": "+email.getEmail()+"\n";
		}
		return msg;
	}
	public String dataNascimentoToString() {
		return ""+this.dataNascimento.getDay()+"/"+this.dataNascimento.getMonth()+"/"+this.dataNascimento.getYear();
	}
	public String listarDados() {
		String msg = this.nome;
		if(this.sobrenome != null)
			msg += " " + this.sobrenome + "\n";
		else
			msg += "\n";
		
		if(this.dataNascimento != null) {
			msg += "Data de Nascimento: " + this.dataNascimentoToString() + "\n";
		}
		msg += "------------------\n";
		
		if(this.telefones.size()>0) {
			msg += "Telefones:\n" + this.listarTelefones();
		}
		
		msg += "------------------\n";
		
		if(this.emails.size()>0) {
			msg += "Emails:\n" + this.listarEmails();
		}
	
		msg += "------------------\n";
		
		return msg;
	}
}
