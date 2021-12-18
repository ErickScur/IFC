package br.edu.ifcvideira.Lista4.LanHouse;

import java.sql.Date;
import java.util.ArrayList;

public class LanHouse {
	private ArrayList<Computador> computadores = new ArrayList<>();
	private ArrayList<String> listaDefeitos = new ArrayList<>();
	public LanHouse() {
		
	}
	
	public ArrayList<Computador> getComputadores() {
		return this.computadores;
	}
	public ArrayList<String> getDefeitos(){
		return this.listaDefeitos;
	}
	
	public void adicionarComputador(int numero, int status, String modelo, int memoria, String placaVideo, String processador) {
		if(this.computadores.size() > 0) {
			int index = this.acharIndexComputador(numero);
			if(index == -1) {
				Computador computador = new Computador(numero, status, modelo, memoria, placaVideo, processador);
				computadores.add(computador);
			}else {
				System.out.println("Numero do computador ja esta em uso");
			}
		}else {
			Computador computador = new Computador(numero, status, modelo, memoria, placaVideo, processador);
			computadores.add(computador);
		}
	}
	public ArrayList<Computador> getComputadorPorMemoria(int memoria){
		ArrayList<Computador> result = new ArrayList<>();
		for(Computador pc: this.computadores) {
			if(pc.getMemoria()==memoria) {
				result.add(pc);
			}
		}
		return result;
	}
	public int acharIndexComputador(int numero) {
		int index = -1;
		for(int i=0; i<this.computadores.size(); i++) {
			if(this.computadores.get(i).getNumero() == numero) {
				index = i;
			}
		}
		return index;
	}
	public void removerComputador(int numero) {
		int index = acharIndexComputador(numero);
		if(index == -1) {
			System.out.println("Nao foi encontrado um computador com esses numero");
		}else {
			this.computadores.remove(index);
			System.out.println("Computador numero "+numero+" foi removido");
		}
	}
	public void alugarComputador(int numero) {
		int index = acharIndexComputador(numero);
		if(index == -1) {
			System.out.println("Nao foi encontrado um computador com esses numero");
		}else {
			this.computadores.get(index).setStatus(1);
		}
	}
	public void liberarComputador(int numero) {
		int index = acharIndexComputador(numero);
		if(index == -1) {
			System.out.println("Nao foi encontrado um computador com esses numero");
		}else {
			this.computadores.get(index).setStatus(0);
		}
	}
	public void marcarDefeito(int numero, String descricao) {
		int index = acharIndexComputador(numero);
		Date date = new Date(System.currentTimeMillis());
		String desc = "";
		if(index == -1) {
			System.out.println("Nao foi encontrado um computador com esses numero");
		}else {
			this.computadores.get(index).setStatus(2);
			desc = "Defeito no Computador "+numero+": \n"+
					descricao+". Data: "+date;
			this.listaDefeitos.add(desc);	
		}
	}
}
