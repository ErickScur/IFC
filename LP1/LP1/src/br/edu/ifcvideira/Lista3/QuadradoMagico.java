package br.edu.ifcvideira.Lista3;

public class QuadradoMagico {
	private static int somaLinha;
	private static int somaColuna;
	private static int somaDiagonal;
	
	private static boolean verificaLinhas(int m[][]) {
		int somaLinhas[] = new int[m.length];
		for(int i=0;i < m.length; i++) {
			somaLinhas[i] = 0;
			for(int j=0; j < m[i].length; j++) {
				somaLinhas[i] += m[i][j];
			}
		}
		boolean flag = true;
		int primeiroElemento = somaLinhas[0];
		for(int i=1;i < somaLinhas.length; i++) {
			if(!(somaLinhas[i] == primeiroElemento)) {
				flag = false;
				break;
			}
		}
		if(flag) {
			somaLinha = primeiroElemento;
			System.out.println("Soma das linhas: "+somaLinha);
			return true;
		}
		else {
			return false;
		}
	}
	private static boolean verificaColunas(int m[][]) {
		int somaColunas[] = new int[m[1].length];
		for(int i=0; i < m[0].length; i++) {
			somaColunas[i] = 0;
			for(int j=0; j < m.length; j++) {
				somaColunas[i] += m[j][i];
			}
		}
		boolean flag = true;
		int primeiroElemento = somaColunas[0];
		for(int i=0; i< somaColunas.length; i++) {
			if(!(somaColunas[i]==primeiroElemento)) {
				flag = false;
				break;
			}
		}
		if(flag) {
			somaColuna = primeiroElemento;
			System.out.println("Soma das colunas: "+somaColuna);
			return true;
		}
		else {
			return false;
		}
			
	}
	private static boolean verificaSeHaRepetidos(int m[][]) {
		int valorTeste;
		boolean flag = true;
		for(int k=0; k < m.length; k++) {
			for(int l=0 ; l < m[0].length; l++) {
				valorTeste = m[k][l];
				for(int i=0; i<m.length; i++) {
					for(int j=0; j<m[0].length; j++) {
						if((m[i][j] == valorTeste)&&(i!=k || j!=l)) {
							flag = false;
							break;
						}
					}
				}
			}
		}
		return flag;
	}
	private static void somaDiagonal(int m[][]) {
		int soma = 0;
		for(int i =0; i<m.length; i++ ){
			for(int j=0; j<m[0].length; j++) {
				if(i==j) {
					soma+= m[i][j];
				}
			}
		}
		somaDiagonal = soma;
		System.out.println("Soma da diagonal principal: "+somaDiagonal);
	}
	public static boolean QuadradoMagico(int m[][]) {
		somaDiagonal(m);
		if(verificaSeHaRepetidos(m)) {
			if(verificaColunas(m) && verificaLinhas(m)) {
				if((somaColuna == somaLinha)&&(somaDiagonal == somaColuna)) {
					System.out.println("É um Quadrado Mágico!");
					return true;
				}else {
					System.out.println("Nao é um Quadrado Mágico");
					return false;
				}
			}else {
				System.out.println("Nao é um Quadrado Mágico");
				return false;
			}
		}else {
			System.out.println("Existem valores repetidos");
			return false;
		}
		
	}
}
