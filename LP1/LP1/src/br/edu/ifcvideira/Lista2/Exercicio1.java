package br.edu.ifcvideira.Lista2;

public class Exercicio1 {
	public static void main(String[] args) {
		int[] v1 = {2,4,6,8,10,12,14,16,18,20};
		int[] v2 = {1,2,3,4,5,6,7,8,9,10};
		int[] vr = new int[20];
		int i;
		int index = v2.length;
		for(i=0;i<v2.length;i++) {
			vr[i] = v2[i];
		}
		for(i=0;i<v1.length;i++) {
			vr[i+index] = v1[i];
		}
		int temp=0;
		int n = vr.length;
		for(i=0;i<n;i++) {
			for(int j=1;j<(n-i);j++) {
				if(vr[j-1]<vr[j]) {
					temp = vr[j-1];
					vr[j-1] = vr[j];
					vr[j] = temp;
				}
			}
		}
		for(i=0;i<n;i++) {
			System.out.println(vr[i]);
		}
	}
}
