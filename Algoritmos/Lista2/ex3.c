#include <stdio.h>
#include <locale.h>

//Fazer um programa que retorne quantos valores digitados pelo usuário são
//negativos. O programa deverá parar a execução quando o usuário informar
//o número zero ou for informado 20 valores.


int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int cont,n,total;
    total=0;
    cont=0;
    n=1;
    do{
        printf("Informe o numero: (digite 0 para parar) \n");
        scanf("%d", &n);
        if(n==0){
            printf("programa finalizado \n");
            break;
        }else if(n<0){
            total++;
            printf("numero negativo!!! \n");
            printf("total de numeros negativos: %d \n",total);
        }else{
            printf("numero positivo \n");
        }
        cont++;
    }while (cont<=20);
    printf("total de numeros negativos: %d \n",total);
   

    return 0;
}

