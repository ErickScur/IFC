#include <stdio.h>
#include <locale.h>

/*Faça um programa que receba duas notas de 6 alunos calcule e imprima: 

a média entre essas 2 notas de cada aluno;
a mensagem de acordo com a tabela abaixo: 


Média/Mensagem 
De 0 a 5.0/reprovado
De 5.1 a 6.9/recuperação 
De 7.0 a 10/aprovado


*/


int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int i;
    float n1,n2,media;
    
    for(i=0;i<6;i++){
        printf("Informe a nota 1 (aluno %d/6)\n",i+1);
        scanf("%f",&n1);

        printf("Informe a nota 2 (aluno %d/6)\n",i+1);
        scanf("%f",&n2);
        media = (n1+n2)/2;

        printf("A media do aluno %d eh: %f\n",i+1,media);
        if(media>=7){
            printf("aprovado!\n");
        }else if(media<7 && media>5){
            printf("recuperacao\n");
        }else{
            printf("reprovado!\n");
        }
    }
       
    
    
   
   

    return 0;
}

