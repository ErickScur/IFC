#include <stdio.h>
#include <locale.h>
#define TAM 5

//Faça um programa em C que leia a idade e a altura de 5 pessoas, armazene cada informação no seu respectivo vetor. 
//Imprima a idade e a altura na ordem inversa a ordem lida.
void vetorInvertido(int *n);
void preencheVetor(int *n);

int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int i,idades[TAM],alturas[TAM];
    int *pi = &idades, *pa = &alturas;

    printf("Informe as idades: \n");
    preencheVetor(pi);
    printf("Informe as alturas(em cm): \n");
    preencheVetor(pa);

    printf("\n Idades(invertido): \n");
    vetorInvertido(pi);

    printf("\n Alturas(invertido): \n");
    vetorInvertido(pa);

    return 0;
}
void preencheVetor(int *n){
    int i;
    for(i=0;i<TAM;i++){
        printf("Informe o valor: %d/%d \n",i+1,TAM);
        scanf("%d",&n[i]);
    }
}
void vetorInvertido(int *n){
    int i;
    for(i=TAM-1;i>=0;i--){
        printf("%d,",n[i]);
    }
}