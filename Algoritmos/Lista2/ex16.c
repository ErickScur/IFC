#include <stdio.h>
#include <locale.h>

/*Supondo que a população de um país A seja 90 milhões de habitantes, crescendo com uma taxa anual de 3.5% 
e que a população de um país B seja 140 milhões de habitantes, crescendo a uma taxa anual de 1%.
Faça um algoritmo que calcule e mostre quantos anos serão necessários para que a população do país A ultrapasse a população do país B. */


int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int i;
    float popA=90000000, popB=140000000;
    
    for(i=0;popA<popB;i++){
        popA += popA*0.01;
        popB += popB*0.035;
    }
    printf("Total de anos: %d",i);
   

    return 0;
}

