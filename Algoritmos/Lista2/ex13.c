#include <stdio.h>
#include <locale.h>

//Leia 5 valores para uma variável a . A seguir mostre quantos valores
//digitados foram pares, quantos valores digitados foram ímpares, quantos
//foram positivos e quantos foram negativos.

int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int i,a, totalPar=0, totalImpar=0, totalPosi=0, totalNega=0;
    
    for(i=0;i<5;i++){
      printf("Informe o numero:");
      scanf("%d",&a);
      if(a%2==0){
          totalPar++;
      }else{
          totalImpar++;
      }

      if(a>=0){
          totalPosi++;
      }else{
          totalNega++;
      }
    }
    printf("Total Positivos: %d\n Total Negativos: %d\n Total Pares: %d \n Total Impares: %d \n", totalPosi, totalNega, totalPar,totalImpar);
   

    return 0;
}

