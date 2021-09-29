package br.edu.ifcvideira.Lista1;

import javax.swing.JOptionPane;

public class Exercicio4 {
	public static void main(String[] args) {
		int horas = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero de horas trabalhadas:"));
		float salarioMinimo = Float.parseFloat(JOptionPane.showInputDialog("Informe o salario minimo:"));
		float valorHora = salarioMinimo/2;
		float salarioBruto = horas * valorHora;
		float imposto = (float) (salarioBruto * 0.03);
		float salarioLiquido = salarioBruto - imposto;
		JOptionPane.showMessageDialog(null, "Salario final: R$"+salarioLiquido);
	}
}
