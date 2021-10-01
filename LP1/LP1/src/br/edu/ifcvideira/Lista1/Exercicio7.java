package br.edu.ifcvideira.Lista1;

import javax.swing.JOptionPane;

public class Exercicio7 {
	public static void main(String[] args) {
		int i,j;
		int menores18=0;
		float altura;
		int idade;
		float peso;
		int somaIdadeTime;
		float mediaIdadeTime[] = new float[5];
		float somaAlturaTodos=0;
		float maisDe80kg=0;
		int totalJogadores=0;
		for(i=0;i<5;i++) {
			somaIdadeTime=0;
			for(j=0;j<11;j++) {
				peso = Float.parseFloat(JOptionPane.showInputDialog("Informe o peso do jogador "+(j+1)+" do time"+(i+1)));
				altura = Float.parseFloat(JOptionPane.showInputDialog("Informe a altura do jogador "+(j+1)+" do time"+(i+1)));
				idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade do jogador "+(j+1)+" do time"+(i+1)));
				totalJogadores++;
				if(idade<18)
					menores18++;
				if(peso>80)
					maisDe80kg++;
				somaIdadeTime+=idade;
				somaAlturaTodos+=altura;
			}
			 mediaIdadeTime[i] = somaIdadeTime / 11;
		}
		String msg = "";
		msg += "quantidade de jogadores com idade inferior a 18 anos: "+menores18+"\n";
		msg += "a média das idades dos jogadores de cada time: \n";
		for(i=0;i<5;i++) 
			msg += " -time "+(i+1)+":"+mediaIdadeTime[i]+" anos\n";
		msg +="média das alturas de todos os jogadores do campeonato: "+somaAlturaTodos/totalJogadores +"\n";
		msg +="porcentagem de jogadores com mais de 80kg entre todos os jogadores do campeonato: "+((maisDe80kg*100)/totalJogadores);
		JOptionPane.showMessageDialog(null, msg);
	}
}
