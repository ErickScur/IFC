package br.edu.ifcvideira.Lista2;

import java.util.Scanner;

public class Exercicio5 {
	public static void main(String[] args) {
		//int matriz[][] = new int[4][3];
		int matriz[][] = {{1,2,3},{4,5,6},{7,9,8},{12,11,10}};
		int vMaiorLinha[] = new int[4];
		int vMenorColuna[] = new int[3];
		
		Scanner sc = new Scanner(System.in);
						
		System.out.println("Forneça os 12 elementos da matriz");			
				
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + "  ");				
			}			
			System.out.println("");
		}
			
		for (int j = 0; j < matriz.length; j++) {			
			int maiorValorLinha = matriz[j][0];					
			for (int i = 0; i < matriz[j].length; i++) {
				if (matriz[j][i] > maiorValorLinha)
					maiorValorLinha = matriz[j][i];			
			}
			vMaiorLinha[j] = maiorValorLinha;
		}
		
		for(int j = 0; j < matriz[0].length; j++) {
			int menorValorColuna = matriz[0][j];
			for(int i = 0; i < matriz.length; i++) {
				if(matriz[i][j] < menorValorColuna) {
					menorValorColuna = matriz[i][j];
				}
				vMenorColuna[j] = menorValorColuna;
			}
		}
		
		System.out.println("Maiores valores de cada linha");
		for (int i = 0; i < vMaiorLinha.length; i++) {
			System.out.print(vMaiorLinha[i] + " ");	
		}
		
		System.out.println(" \nMenores valores de cada coluna");
		for (int i = 0; i < vMenorColuna.length; i++) {
			System.out.print(vMenorColuna[i] + " ");
		}
		
			
		
	}
}
