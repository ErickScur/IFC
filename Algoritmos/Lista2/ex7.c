#include <stdio.h>
#include <locale.h>

//Escreva um algoritmo que leia um número n (número de termos de uma
//progressão aritmética), a1 (o primeiro termo da progressão) e r (a razão da
//progressão) e escreva os n termos dessa progressão, bem como a soma
//dos elementos.


int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int n,a1,r,i,na;

    printf("Informe o numero de termos:\n");
    scanf("%d", &n);

    printf("Informe o termo inicial:\n");
    scanf("%d", &a1);

    printf("Informe a razao:\n");
    scanf("%d", &r);

    printf("%d ",a1);
    na = a1+r;
    printf("%d ",na);
    for(i=1;i<n-1;i++){
        na += r;
        printf("%d ",na);
    }

    return 0;
}

