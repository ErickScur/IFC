package br.edu.ifcvideira.Aula08;

public class Carro {

		private double velocidade;
		private String marca;
		private String modelo;
		
		public Carro() {
			this.velocidade = 0;
		}
		public Carro(double velocidade, String marca, String modelo) {
			this.velocidade = velocidade;
			this.marca = marca;
			this.modelo = modelo;
		}
		
		public void acelerar(double aceleracao) {
			if(aceleracao>0) {
				System.out.println("O carro aumentou sua velocidade em "+aceleracao+" km/h");
				this.velocidade += aceleracao;
				System.out.println("E agora esta a uma velocidade de: "+this.velocidade+ " km/h");
			}
		}
		
		public double getVelocidade() {
			return velocidade;
		}
		public void setVelocidade(double velocidade) {
			this.velocidade = velocidade;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		
}
