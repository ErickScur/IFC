package br.edu.ifcvideira.Lista4.LanHouse;

public class Computador {
	private int numero;
	private int status;
	private String modelo;
	private int memoria;
	private String placaVideo;
	private String processador;
	
	public Computador(int numero, int status, String modelo, int memoria, String placaVideo, String processador) {
		super();
		this.numero = numero;
		this.status = status;
		this.modelo = modelo;
		this.memoria = memoria;
		this.placaVideo = placaVideo;
		this.processador = processador;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getMemoria() {
		return memoria;
	}
	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
	public String getPlacaVideo() {
		return placaVideo;
	}
	public void setPlacaVideo(String placaVideo) {
		this.placaVideo = placaVideo;
	}
	public String getProcessador() {
		return processador;
	}
	public void setProcessador(String processador) {
		this.processador = processador;
	}
	public String toString() {
		String msg = "Computador "+this.numero+
				"\nStatus: "+ this.statusString() + "\n"+
				"Modelo: "+this.modelo+"\n"+
				"Memoria: "+this.memoria+"GB\n"+
				"Placa de Video: "+this.getPlacaVideo()+"\n"+
				"Processador: "+this.getProcessador()+"\n";
		
		return msg;
	}
	public String statusString() {
		String status="";
		switch(this.status) {
			case 0:
				status = "Disponivel";
				break;
			case 1:
				status = "Alugado";
				break;
			case 2:
				status = "Defeito";
				break;
		}
		return status;
	}
	
}
