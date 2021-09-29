package br.edu.ifcvideira.Lista1;

import javax.swing.JOptionPane;

public class Exercicio6 {
	public static void main(String[] args) {
		float valor = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor da conta:"));
		float valorPago = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor pago:"));
		float troco = valorPago - valor;
		int notas[] = {100, 50, 20, 10, 5, 2, 1};
		int moedas[] =  {50, 25, 10, 5, 1};
		int i;
		while(troco>0) {
			for(i=0;i<notas.length;i++) {
				if(notas[i]<=troco) {
					troco -= notas[i];
					System.out.println("troco: "+notas[i]);
					System.out.println("restante: "+troco);
					break;
				}
			}
		}
 	}
}
