package br.edu.ifcvideira.Lista1;

import javax.swing.JOptionPane;

public class Exercicio8 {
	public static void main(String[] args) {
		int num = Integer.parseInt(JOptionPane.showInputDialog("Insira um numero:"));
		int resultado = 1;
		while(num>0){
			resultado *= num;
			num--;
		}
	JOptionPane.showMessageDialog(null, "Fatorial: "+resultado);
	}
}
