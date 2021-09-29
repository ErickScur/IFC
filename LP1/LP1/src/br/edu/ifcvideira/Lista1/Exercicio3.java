package br.edu.ifcvideira.Lista1;

import javax.swing.JOptionPane;

public class Exercicio3 {
	public static void main(String[] args) {
		float salarioMinimo = Float.parseFloat(JOptionPane.showInputDialog("Informe o Salario Minimo:"));
		float quilowatts = Float.parseFloat(JOptionPane.showInputDialog("Informe a quantidade de quilowatts:"));
		float valorQuilowatt = salarioMinimo/5;
		float valorResidencia = valorQuilowatt * quilowatts;
		float valorDesconto = (float) (valorResidencia * 0.85);
		JOptionPane.showMessageDialog(null, "Valor do Quilowatt: R$"+valorQuilowatt);
		JOptionPane.showMessageDialog(null, "Valor a ser pago nessa residencia: R$"+valorResidencia);
		JOptionPane.showMessageDialog(null, "Valor com 15% de desconto: R$"+valorDesconto);
	}
}
