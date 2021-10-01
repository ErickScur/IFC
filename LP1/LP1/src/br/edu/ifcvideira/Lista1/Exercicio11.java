package br.edu.ifcvideira.Lista1;

import javax.swing.JOptionPane;

public class Exercicio11 {
	public static void main(String[] args) {
		int totalPrimos=0;
		int i;
		int j;
		for(i=0;i<10;i++) {
			int num = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero "+(i+1)));
			boolean primo=true;
			for(j=2;j<= (num/2);j++) {
				if(num%j==0) {
					primo=false;
					break;
				}
			}
			if(primo)
				totalPrimos++;
		}
		
		JOptionPane.showMessageDialog(null, "Total de primos: "+totalPrimos);
	}
}
