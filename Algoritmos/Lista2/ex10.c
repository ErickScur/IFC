#include <stdio.h>
#include <locale.h>

//Escreva um algoritmo que calcule a média dos números digitados pelo
//usuário, se eles forem pares. Termine a leitura se o usuário digitar zero (0).


int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int n,totalPares=0,soma=0;
    float media;
    do{
        printf("Informe o numero: \n");
        scanf("%d",&n);
        if(n==0){
            printf("Programa finalizado \n");
            break;
        }else if(n%2==0){
            printf("numero par \n");
            totalPares++;
            soma += n;
        }else{
            printf("numero impar \n");
        }
    }while(n!=0);

    media = soma/totalPares;
    printf("a soma de numeros pares é: %f \n",media);
    
   

    return 0;
}

