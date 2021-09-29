package br.edu.ifcvideira.Lista1;

import javax.swing.JOptionPane;

public class Exercicio2 {
	public static void main(String[] args) {
		float salario = Float.parseFloat(JOptionPane.showInputDialog("Informe o salario:"));
		salario *= 1.05;
		salario *= 0.93;
		JOptionPane.showMessageDialog(null, "Salario Final: R$"+salario);
	}
}
