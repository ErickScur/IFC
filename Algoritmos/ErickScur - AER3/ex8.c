#include <stdio.h>
#include <locale.h>

/*Em uma eleição presidencial existem quatro candidatos. Os votos são
informados através de códigos. Os dados utilizados para a contagem dos
votos obedecem à seguinte codificação:

● 1,2,3,4 = voto para os respectivos candidatos;
● 5 = voto nulo;
● 6 = voto em branco;

Elabore um algoritmo que leia o código do candidato em um voto. Calcule e escreva:

●total de votos para cada candidato;
●total de votos nulos;
●total de votos em branco;

Como finalizador do conjunto de votos, tem-se o valor 0.
*/

int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int n,c1=0,c2=0,c3=0,c4=0,vn=0,vb=0;

    do{
        printf("Registre seu voto: \n 1- Candidato 1 \n 2- Candidato 2 \n 3- Candidato 3 \n 4- Candidato 4 \n 5- Voto Nulo \n 6- Voto em Branco \n 0- Parar votação \n");
        scanf("%d",&n);

        switch (n){
            case 1:
                c1++;
                break;
            case 2:
                c2++;
                break;
            case 3:
                c3++;
                break;
            case 4:
                c4++;
                break;
            case 5:
                vn++;
                break;
            case 6:
                vb++;
                break;
            case 0:
                printf("Votação encerrada!");
                break;
        }
    }while(n!=0);
    printf("Resultados da votação: \n Candidato 1: %d votos \n Candidato 2: %d votos \n Candidato 3: %d votos \n Candidato 4: %d votos \n Votos Nulos: %d \n Votos em Branco: %d    \n",c1,c2,c3,c4,vn,vb);
    

    return 0;
}

