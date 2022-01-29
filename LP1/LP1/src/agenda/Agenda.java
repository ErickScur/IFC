package agenda;

import java.util.ArrayList;

public class Agenda {
	private ArrayList<Contato> contatos = new ArrayList<>();
	
	public Agenda() {
		
	}
	public ArrayList<Contato> getContatos(){
		return this.contatos;
	}
	public String[] getContatosStringArray() {
		String[] contatos = new String[this.contatos.size()];
		for(int i=0; i<this.contatos.size(); i++) {
			String sobrenome = this.contatos.get(i).getSobrenome();
			contatos[i] = this.contatos.get(i).getNome();
			if(sobrenome != null)
				contatos[i] += " " + sobrenome;
		}
		return contatos;
	}
	public ArrayList<Integer> getContatosNome(String nome) {
		ArrayList<Integer> contatos = new ArrayList<>();
		for(int i=0; i<this.contatos.size();i++) {
			if(this.contatos.get(i).getNome().toLowerCase().equals(nome.toLowerCase()))
				contatos.add(i);
		}
		return contatos;
	}
	public void adicionarContato(Contato c) {
		this.contatos.add(c);
	}
	public void removeContato(int i) {
		try{
			this.contatos.remove(i);
		}catch(java.lang.IndexOutOfBoundsException e) {
			System.err.println("Erro: Contato de Índice "+i+ " Não Existe");
		}catch(Exception e) {
			System.err.println("Erro: "+e.toString());
		}
	}
	public Contato getContato(int i) {
		try {
			Contato contato = this.contatos.get(i);
			return contato;
		}catch(java.lang.IndexOutOfBoundsException e) {
			System.err.println("Erro: Contato de Índice "+i+ " Não Existe");
		}catch(Exception e) {
			System.err.println("Erro: "+e.toString());
		}
		return null;
	}
	public void atualizarContato(Contato c, int i) {
		try{
			this.contatos.set(i, c);
		}catch(java.lang.IndexOutOfBoundsException e) {
			System.err.println("Erro: Contato de Índice "+i+ " Não Existe");
		}catch(Exception e) {
			System.err.println("Erro: "+e.toString());
		}
	}
	public String listarContatos() {
		String msg = "Contatos \n";
		for(int i=0; i<this.contatos.size(); i++) {
			String sobrenome = this.contatos.get(i).getSobrenome();
			msg += (i+1) + ": " + this.contatos.get(i).getNome();
			if(sobrenome != null)
				msg += " "+sobrenome;
			msg += "\n";
		}
		return msg;
	}
	public String listarDadosContato(int i) {
		Contato c = this.getContato(i);
		return i + ": " + c.listarDados();
	}
}
