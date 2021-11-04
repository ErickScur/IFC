package br.edu.ifcvideira.Lista3;

public class Tempo {
	private int horas;
	private int minutos;
	private int segundos;
	
	public Tempo() {
		this.horas = 0;
		this.minutos = 0;
		this.segundos = 0;
	}
	public Tempo(int horas) {
		if(this.validaValores(horas)) {
			this.horas=horas;
			this.minutos = 0;
			this.segundos = 0;
		}else {
			this.zeraObjeto();
		}
	}
	public Tempo(int horas, int minutos) {
		if(this.validaValores(horas, minutos)) {
			this.horas=horas;
			this.minutos = minutos;
			this.segundos = 0;
		}else {
			this.zeraObjeto();
		}
	}
	public Tempo(int horas, int minutos, int segundos) {
		if(this.validaValores(horas, minutos,segundos)) {
			this.horas=horas;
			this.minutos = minutos;
			this.segundos = segundos;
		}else {
			this.zeraObjeto();
		}
	}
	public void zeraObjeto() {
		this.horas=0;
		this.minutos=0;
		this.segundos=0;
	}
	private boolean validaHoras(int horas) {
		if(horas>=0 && horas <= 23) {
			return true;
		}else {
			return false;
		}
	}
	private boolean validaMinutos(int minutos) {
		if(minutos >=0 && minutos<=59) {
			return true;
		}else {
			return false;
		}
	}
	private boolean validaSegundos(int segundos) {
		if(segundos >=0 && segundos<=59) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean validaValores(int horas) {
		if(this.validaHoras(horas))
			return true;
		else
			return false;
	}
	private boolean validaValores(int horas, int minutos) {
		if(this.validaHoras(horas) && this.validaMinutos(minutos))
			return true;
		else
			return false;
		
	}
	private boolean validaValores(int horas, int minutos, int segundos) {
		if(this.validaHoras(horas) && this.validaMinutos(minutos) && this.validaSegundos(segundos))
			return true;
		else
			return false;
	}
	
	public String toString() {
		String tempo = "";
		if(this.horas < 10) {
			tempo += "0"+this.horas+":";
		}else {
			tempo += +this.horas+":";
		}
		if(this.minutos < 10) {
			tempo += "0"+this.minutos+":";
		}else {
			tempo += +this.minutos+":";
		}
		if(this.segundos < 10) {
			tempo += "0"+this.segundos;
		}else {
			tempo += +this.segundos;
		}
		return tempo;
	}
	
	public int getHoras() {
		return this.horas;
	}
	public boolean setHoras(int horas) {
		if(this.validaHoras(horas)) {
			this.horas = horas;
			return true;
		}else {
			return false;
		}	
			
	}
	public int getMinutos() {
		return this.minutos;
	}
	public boolean setMinutos(int minutos) {
		if(this.validaMinutos(minutos)) {
			this.minutos = minutos;
			return true;
		}else {
			return false;
		}
	}
	public int getSegundos() {
		return this.segundos;
	}
	public boolean setSegundos(int segundos) {
		if(this.validaSegundos(segundos)) {
			this.segundos = segundos;
			return true;
		}else {
			return false;
		}
	}
	public long toSegundos() {
		long total = (this.horas*3600)+(this.minutos*60)+this.segundos;
		return total;
	}
	private static long toSegundos(int horas, int minutos, int segundos) {
		long total = (horas*3600)+(minutos*60)+segundos;
		return total;
	}
	public long tempoDiff(Tempo tempo) {
		long tempo1 = Tempo.toSegundos(tempo.getHoras(), tempo.getMinutos(), tempo.getSegundos());
		long tempo2 = Tempo.toSegundos(this.horas, this.minutos, this.segundos);
		long diff;
		if(tempo1>tempo2) {
			diff= tempo1 - tempo2;
		}else {
			diff = tempo2 - tempo1;
		}
		return diff;
	}
}
