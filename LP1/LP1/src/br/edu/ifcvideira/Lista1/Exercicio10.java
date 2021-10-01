package br.edu.ifcvideira.Lista1;

import javax.swing.JOptionPane;

public class Exercicio10 {
	public static void main(String[] args) {
		int num = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero"));
		int i;
		boolean primo=true;
		for(i=2;i<= (num/2);i++) {
			if(num%i==0) {
				primo=false;
				break;
			}
		}
		if(primo)
			JOptionPane.showMessageDialog(null, "Primo");
		else
			JOptionPane.showMessageDialog(null, "Nao primo");
	}
}
