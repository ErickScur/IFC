#include <stdio.h>
#include <locale.h>

//Faça um algoritmo que leia a altura de um grupo de 20 pessoas, calcule e
//exiba:
//a. A maior altura do grupo;
//b. A altura média;
//c. O número de pessoas com altura superior a 2 metros.


int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int i, maiorQue2=0;
    float media,a,soma=0,maior=0;
    
    for(i=0;i<20;i++){
        printf("Informe a altura:");
        scanf("%f",&a);
        
        soma+=a;
        if(a>2){
            maiorQue2++;
        }
        if(a>maior){
            maior = a;
        }
    }
    media = soma/20;

    printf("A maior altura do grupo: %f \nA altura media: %f \nNumero de pessoas com altura maior que 2 metros: %d",maior, media,maiorQue2);
   

    return 0;
}

