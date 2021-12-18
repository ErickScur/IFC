package br.edu.ifcvideira.Lista4.Cinema;

public class Filme {
	private String titulo;
	private String genero;
	private int ano;
	private String diretor;
	private int sala;
	private int numero;
	public Filme(int numero, String titulo, String genero, int ano, String diretor, int sala) {
		this.titulo = titulo;
		this.genero = genero;
		this.ano = ano;
		this.diretor = diretor;
		this.sala = sala;
		this.numero = numero;
	}
	public Filme() {
		
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
