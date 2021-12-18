package br.edu.ifcvideira.Lista4.Cinema;

public class Sessao {
	private Filme filme;
	private int capacidade;
	private double precoIngreco;
	private int numeroSessao;
	public Sessao(Filme filme, double precoIngreco, int capacidade, int numeroSessao) {
		this.filme = filme;
		this.precoIngreco = precoIngreco;
		this.capacidade = capacidade;
		this.numeroSessao = numeroSessao;
	}
	public Sessao() {
		
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public double getPrecoIngreco() {
		return precoIngreco;
	}
	public void setPrecoIngreco(double precoIngreco) {
		this.precoIngreco = precoIngreco;
	}
	
	public int getNumeroSessao() {
		return numeroSessao;
	}
	public void setNumeroSessao(int numeroSessao) {
		this.numeroSessao = numeroSessao;
	}
	public String toString() {
		String msg = "Sessao n.º "+this.numeroSessao+"\n"+
				"Filme: "+this.filme.getTitulo()+"\n"+
				"Sala: "+this.filme.getSala()+"\n"+
				"Valor do Ingresso: "+this.precoIngreco+"\n";
		return msg;
	}
}
