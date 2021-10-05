package br.edu.ifcvideira.Lista2;

import javax.swing.JOptionPane;

public class Exercicio4 {
	public static int acharIndice(int cd, int codigos[]) {
		int index = -1;
		for(int i=0; i<codigos.length;i++) {
			if(codigos[i]==cd) {
				index = i;
			}
		}
		if(index>=0) {
			return index;
		}else {
			return -1;
		}
	}
	public static void main(String[] args) {
		int codigos[] = {1,2,3,4,5,6,7,8,9,10};
		double saldos[] = {100.87, 200.6, 900.76, 7965.09, 9786.92,100.87, 200.6, 900.76, 7965.09, 9786.92};
		String[] options = {"Efetuar depósito", "Efetuar saque", "Consultar o ativo bancário","Finalizar programa"};
		for(;;) {
			int op = JOptionPane.showOptionDialog(null, "Escolha a Operação:",
	                "Banco",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			switch(op) {
				case 0:
					int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo:"));
					int index = acharIndice(codigo, codigos);
					if(index==-1) {
						JOptionPane.showMessageDialog(null, "Codigo invalido");
						break;
					}
					double deposito = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser depositado:"));
					if(deposito>0) {
						saldos[index] += deposito;
						JOptionPane.showMessageDialog(null, "Foram depositados: "+deposito+ "\n O saldo agora é: "+saldos[index]);
						break;
					}else {
						JOptionPane.showMessageDialog(null, "Quantidade invalida");
						break;
					}
				case 1:
					codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo:"));
					index = acharIndice(codigo, codigos);
					if(index==-1) {
						JOptionPane.showMessageDialog(null, "Codigo invalido");
						break;
					}
					float saque = Float.parseFloat(JOptionPane.showInputDialog("Quanto deseja sacar?"));
					if(saque>0) {
						if(saldos[index]<saque) {
							JOptionPane.showMessageDialog(null, "Voce nao tem saldo suficiente!");
							break;
						}else {
							saldos[index] -= saque;
							JOptionPane.showMessageDialog(null, "Foi realizado um saque no valor de: "+saque+"\n Saldo restante: "+saldos[index]);
							break;
						}
					}else {
						JOptionPane.showMessageDialog(null, "Quantidade invalida");
						break;
					}
				case 2:
					float soma=0;
					for(int i=0; i<saldos.length;i++) {
						soma += saldos[i];
					}
					JOptionPane.showMessageDialog(null, "Ativo Bancario: "+soma);
					break;
				case 3:
					System.exit(0);
			}
		}
	}
}
