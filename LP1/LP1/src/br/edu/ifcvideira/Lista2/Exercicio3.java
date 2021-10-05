package br.edu.ifcvideira.Lista2;

public class Exercicio3 {
	public static void main(String[] args) {
		int v1[] = {11,12,13,14,15,16,17,18,19,20};
		int v2[] = {1,2,3,4,5};
		int nPares=0;
		int nImpar=0;
		for(int i=0; i<v1.length;i++) {
			if(v1[i]%2==0) {
				nPares++;
			}else {
				nImpar++;
			}
			
		}
		int[] v3 = new int[nPares];
		int[] v4 = new int[nImpar];
		int somav2=0;
		for(int i=0; i<v2.length; i++) {
			somav2 += v2[i];
		}
		int ipar=0;
		for(int i=0; i<v1.length;i++) {
			if(v1[i]%2==0) {
				v3[ipar] = v1[i]+somav2;
				ipar++;
			}
		}
		System.out.println("Soma de cada número par do primeiro vetor somado a todos os números do segundo vetor:");
		for(int i=0;i<v3.length;i++) {
			System.out.println(v3[i]);
		}
		int iImpar=0;
		for(int i=0; i<v1.length;i++) {
			if(v1[i]%2!=0) {
				v4[iImpar] = v1[i];
				iImpar++;
			}
		}
		for(int i=0; i<v4.length;i++) {
			int qntDiv=0;
			for(int j=0; j<v2.length;j++) {
				if(v4[i]%v2[j]==0) {
					qntDiv++;
				}
			}
			v4[i] = qntDiv;
		}
		System.out.println("Quantidade de divisores que cada número ímpar do primeiro vetor tem no segundo vetor");
		for(int i=0;i<v4.length;i++) {
			System.out.println(v4[i]);
		}
	}
}
