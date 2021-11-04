package br.edu.ifcvideira.Aula10;

public class ContaCorrente {
	
	private double saldo;
	private String nome;
	private String cpf;
	public ContaCorrente(){
		
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void deposito(double valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
	
	public void saque(double valor) {
		if(valor < this.getSaldo()) {
			this.setSaldo( this.getSaldo() - valor);
		}
	}
}
