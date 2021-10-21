package br.edu.ifcvideira.Aula09;

public class Televisao {
	private boolean ligado;
	private int[] canais = {1,2,3,4,5,6,7,8,9,10};
	private int canalAtual;
	private int volume;
	private static int volumeMax=10;
	
	public Televisao() {
		this.ligado = false;
		this.canalAtual = this.canais[0];
		this.volume = 5;
	}
	public boolean isLigado() {
		return ligado;
	}
	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	public int[] getCanais() {
		return canais;
	}
	public int getCanalAtual() {
		return canalAtual;
	}
	private void setCanalAtual(int canalAtual) {
		this.canalAtual = canalAtual;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getVolumeMax() {
		return volumeMax;
	}
	public int findIndexCanal(int canal) { //Acha o indice do canal no vetor, se nao achar, retorna -1
		int index = -1;
		for(int i=0; i<this.canais.length; i++) {
			if(this.canais[i] == canal) {
				index = i;
				break;
			}
		}
		return index;
	}
	public void power() {
		boolean isLigado = this.isLigado();
		if(isLigado) {
			this.ligado = false;
		}else {
			this.ligado = true;
		}
	}
	public void setCanal(int canal, int canalAtual) {
		int index = findIndexCanal(canal);
		if(index != -1)
			this.setCanalAtual(this.canais[index]);
		else {
			index = findIndexCanal(canalAtual);
			this.setCanalAtual(this.canais[index]);
		}	
	}
	public void incrementarCanal() {
		int canalAtual = this.getCanalAtual();
		int index = findIndexCanal(canalAtual) +1;
		if(index == (this.canais.length)) {
			index=0;
		}
		this.setCanalAtual(this.canais[index]);
	}
	public void decrementarCanal() {
		int canalAtual = this.getCanalAtual();
		int index = findIndexCanal(canalAtual) -1;
		if(index<0)
			index= this.canais.length - 1;
		this.setCanalAtual(this.canais[index]);
	}
	public void aumentarVolume() {
		if(this.getVolume() < this.getVolumeMax()) {
			this.setVolume(this.getVolume() +1);
		}
	}
	public void diminuirVolume() {
		if(this.getVolume() > 0) {
			this.setVolume(this.getVolume() -1);
		}
		
	}
	
}
