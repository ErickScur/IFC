package br.edu.ifcvideira.Lista1;

import javax.swing.JOptionPane;

public class Exercicio9 {
	public static void main(String[] args) {
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro numero: "));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo numero: "));
		int temp;
		if(num2<num1) { //Inverte caso num1 seja maior que num2
			temp=num2;
			num2 = num1;
			num1 = temp;
		}
		int i;
		String msg = "";
		for(i=num1;i<=num2;i++) {
			msg += "Fatorial de "+i+": \n";
			int fatorial = 1;
			int num=i;
			while(num>0){
				fatorial *= num;
				num--;
			}
			msg += fatorial+"\n";
		}
		JOptionPane.showMessageDialog(null, msg);
	}
}
