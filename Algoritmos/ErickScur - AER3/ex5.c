#include <stdio.h>
#include <locale.h>

//Escrever um algoritmo que lê um valor N inteiro e positivo e que calcula e
//escreve o valor de E:
//E = 1 + 1 / 1! + 1 / 2! + ... + 1 / N!
// ! = fatorial. 3! = 3 . 2 . 1


int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int n,i;
    float e,fat;
    
    fat=1;
    e=1;
    printf("Informe o numero limite:\n");
    scanf("%d", &n);
    
    printf("E = 1 + ");
    for(i=1;i<=n;i++){
        fat *= i;
        e += 1/(float)fat;
        printf("1/%d! + ",i);
    }
    printf("\n resultado= %f",e);
   

    return 0;
}

