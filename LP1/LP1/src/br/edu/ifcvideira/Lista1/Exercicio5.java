package br.edu.ifcvideira.Lista1;

import javax.swing.JOptionPane;

public class Exercicio5 {
	public static void main(String[] args) {
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo"));
		int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade:"));
		float precoUnd=0;
		if(codigo<=10) {
			precoUnd = 10;
		}else if(codigo<=20) {
			precoUnd = 15;
		}else if(codigo<=30) {
			precoUnd = 20;
		}else if(codigo<=40) {
			precoUnd = 40;
		}else {
			JOptionPane.showMessageDialog(null, "Codigo Invalido");
		}
		float precoTotal = precoUnd * quantidade;
		float desconto=0;
		if(precoTotal<=250) {
			desconto = (float) (precoTotal * 0.05);
		}else if(precoTotal<=500) {
			desconto = (float) (precoTotal * 0.1);
		}else if(precoTotal>500) {
			desconto = (float) (precoTotal * 0.15);
		}
		float precoFinal = precoTotal - desconto;
		JOptionPane.showMessageDialog(null, "Valor total: R$"+precoFinal);
	}
}
