package br.edu.ifcvideira.Lista4.Pais;

import java.util.ArrayList;

public class Pais {
	private String codigo;
	private String nome;
	private int populacao;
	private double dimensao;
	private ArrayList<String> fronteiras = new ArrayList<>();
	
	public Pais(String codigo,String nome,double dimensao) {
		this.codigo = codigo.toUpperCase();
		this.nome = nome;
		this.dimensao = dimensao;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPopulacao() {
		return populacao;
	}
	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}
	public double getDimensao() {
		return dimensao;
	}
	public void setDimensao(double dimensao) {
		this.dimensao = dimensao;
	}
	public void addPaisVizinho(String pais ) {
		this.fronteiras.add(pais);
	}
	public boolean isVizinho(Pais pais) {
		boolean result = this.fronteiras.contains(pais.getCodigo());
		return result;
	}
	public ArrayList<String> getFronteiras() {
		return fronteiras;
	}
	public ArrayList<String> getVizinhosComum(Pais pais){
		ArrayList<String> vizinhosComuns = new ArrayList<>();
		for(int i = 0; i < this.fronteiras.size(); i++) {
			if(pais.getFronteiras().contains(this.fronteiras.get(i))) {
				vizinhosComuns.add(this.fronteiras.get(i));
			}
		}
		return vizinhosComuns;
	}
	public double getDensidadePopulacional() {
		double densidade = this.populacao/this.dimensao;
		return densidade;
	}
	
}
