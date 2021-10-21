/*Faça um algoritmo que leia vários códigos do jogador (1 ou 2) que ganhou o ponto em uma partida de pingue-pongue, 
e responda quem ganha a partida. A partida chega ao final se um dos jogadores chega a 21 pontos e a diferença de pontos 
entre os jogadores é maior ou igual a dois. Caso contrário, ganha aquele que, com mais de 21 pontos, consiga colocar uma 
vantagem de dois pontos sobre o adversário.  
*/
#include <stdio.h>
#include <locale.h>

int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int n,t1=0,t2=0,dif=0,flag=0;
    do{
        printf("Qual jogador marcou o ponto? \n");
        scanf("%d",&n);

        if(n==1)
            t1++;
        else if(n==2)
            t2++;
        else
            printf("Codigo invalido! \n");

        if(t1>t2)
            dif= t1-t2;
        else
            dif= t2-t1;
        
        if(t1>=21 && dif>=2){
            printf("Jogador 1 ganhou");
            flag=1;
        }else if(t2>=21 && dif>=2){
            printf("Jogador 2 ganhou");
            flag=1;
        }

    }while(flag==0);
    
    
       
    return 0;
}

