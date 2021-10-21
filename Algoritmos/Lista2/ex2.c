#include <stdio.h>
#include <locale.h>

//Fazer um programa que calcule a tabuada de qualquer número, e o limite
//de cálculo deve ser definido pelo usuário.


int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int n,i,limite,tabuada;
    printf("Informe o numero: ");
    scanf("%d", &n);

    printf("Informe o limite: ");
    scanf("%d", &limite);

    for(i=0;i<=limite;i++){
        tabuada = n * i;
        printf("%d * %d = %d \n",n,i,tabuada);
    }

   

    return 0;
}

