//Leia os 03 ângulos e os 03 lados de um triângulo, e classifique-o como: retângulo,
//obtusângulo ou acutângulo; e equilátero, escaleno ou isósceles.
package br.edu.ifcvideira.Lista1;

import javax.swing.JOptionPane;

public class Exercicio1 {
	public static void main(String[] args) {
		int[] angulos = new int[3];
		int[] lados = new int[3];
		int i=0;
		String classAngulos="";
		String classLados="";
		
		for(i=0;i<3;i++){
			angulos[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o Angulo "+ (i+1) + "/" + 3 ));
			lados[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o Lado "+ (i+1) + "/" + 3 ));
		}
		
		if(angulos[0]<90 && angulos[1] < 90 && angulos[2] <90) {
			classAngulos = "Triangulo Acutangulo";
		}else if(angulos[0]>90 || angulos[1] > 90 || angulos[2] >90) {
			classAngulos = "Triangulo Obtusangulo";
		}else if(angulos[0]==90 || angulos[1]==90 || angulos[2]==90) {
			classAngulos = "Triangulo Retangulo";
		}
		JOptionPane.showMessageDialog(null, "Classificacao Angulos: "+classAngulos+"\n");
		
		if(lados[0]==lados[1]&&lados[0]==lados[2]) {
			classLados = "Triangulo Equilatero";
		}else if(lados[0]==lados[1] || lados[0]==lados[2] || lados[1]==lados[2]) {
			classLados = "Triangulo Isosceles";
		}else if(lados[0]!=lados[1] && lados[0]!=lados[2] && lados[1]!=lados[2]) {
			classLados = "Triangulo Escaleno";
		}
		JOptionPane.showMessageDialog(null, "Classificacao Lados: "+classLados+"\n");

	}
}
