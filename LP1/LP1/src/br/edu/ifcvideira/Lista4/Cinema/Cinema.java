package br.edu.ifcvideira.Lista4.Cinema;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Cinema {
	private ArrayList<Filme> filmes = new ArrayList<>();
	private HashMap<Integer, Integer> salas = new HashMap<>();
	private ArrayList<Sessao> sessoes = new ArrayList<>();
	private String senhaAdm = "123456789";
	public Cinema() {
		
	}
	public String getSessoes() {
		String msg = "";
		for(Sessao sessao: this.sessoes) {
			msg+= "Sessão n.º "+sessao.getNumeroSessao()+"\n"+
					"Filme: "+sessao.getFilme().getTitulo()+"\n"+
					"Valor Ingresso: "+sessao.getPrecoIngreco()+"\n"+
					"Sala: "+sessao.getFilme().getSala()+"\n \n \n";
		}
		return msg;
	}
	public ArrayList<Filme> getAllFilmes() {
		return this.filmes;
	}
	public HashMap<Integer, Integer> getSalas(){
		return salas;
	}
	public void adicionarSala(int numero, int capacidade) {
		salas.put(numero, capacidade);
	}

	public void adicionarFilme(int numero,String titulo, String genero, int ano, String diretor, int sala) {
		if(salas.containsKey(sala)) {
			if(this.filmes.size() > 0) {
				int index = acharIndexFilme(numero);
				if(index == -1) {
					Filme filme = new Filme(numero,titulo,genero,ano,diretor,sala);
					filmes.add(filme);
				}else {
					JOptionPane.showMessageDialog(null, "Numero de filme ja esta em uso!");
				}
			}else {
				Filme filme = new Filme(numero,titulo,genero,ano,diretor,sala);
				filmes.add(filme);
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Sala com o numero informado nao existe");
		}
	}
	
	public int acharIndexFilme(int numero) {
		int index = -1;
		for(int i=0; i<this.filmes.size(); i++) {
			if(this.filmes.get(i).getNumero() == numero)
				index = i;
		}
		return index;
	}
	public int acharIndexSessao(int numero) {
		int index = -1;
		for(int i=0; i<this.sessoes.size(); i++) {
			if(this.sessoes.get(i).getNumeroSessao() == numero)
				index = i;
		}
		return index;
	}
	public Filme encontrarFilmePorNumero(int numero) {
		int index = acharIndexFilme(numero);
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Nenhum filme foi encontrado com esse numero!");
			Filme filme = new Filme();
			filme.setNumero(-100);
			return filme;
		}else {
			return this.filmes.get(index);
		}
	}
	public Sessao encontrarSessaoPorNumero(int numeroSessao) {
		int index = acharIndexSessao(numeroSessao);
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Nenhuma sessao foi encontrado com esse numero!");
			Sessao sessao = new Sessao();
			sessao.setNumeroSessao(-100);
			return sessao;
		}else {
			return this.sessoes.get(index);
		}
	}
	public void adicionarSessao(int numeroFilme, double precoIngreco, int numeroSessao) {
		Filme filme = encontrarFilmePorNumero(numeroFilme);
		if(filme.getNumero()!= -100) {
			int sala = filme.getSala();
			int capacidade = this.salas.get(sala);
			if(this.sessoes.size() > 0) {
				Sessao sessao = new Sessao(filme, precoIngreco,capacidade,numeroSessao);
				sessoes.add(sessao);
			}else {
				int index = acharIndexSessao(numeroSessao);
				if(index == -1) {
					Sessao sessao = new Sessao(filme, precoIngreco,capacidade,numeroSessao);
					sessoes.add(sessao);
				}else {
					JOptionPane.showMessageDialog(null, "Ja existe uma sessao com esse numero!");
				}		
			}
		}	
	}
	
	public void comprarIngresso(int numeroSessao, int numeroIngressos) {
		Sessao sessao = encontrarSessaoPorNumero(numeroSessao);
		if(sessao.getCapacidade() < numeroIngressos) {
			JOptionPane.showMessageDialog(null, "Capacidade maxima excedida! \nLugares Disponiveis Restantes: "+sessao.getCapacidade());
		}else {
			sessao.setCapacidade(sessao.getCapacidade() - numeroIngressos);
			double valorTotal = numeroIngressos * sessao.getPrecoIngreco();
			JOptionPane.showMessageDialog(null, "-------Nota Fiscal------- \n"+
								numeroIngressos+" x "+sessao.getPrecoIngreco()+".........Total: "+valorTotal);
		}
	}
	public boolean admLogin(String senha) {
		return senha.equals(this.senhaAdm);
	}
}
