#include <stdio.h>
#include <locale.h>
#define TAM 5

/*Escreva um algoritmo que lê uma matriz M(5,5) e calcula as somas:
da linha 4 de M.
da coluna 2 de M.
da diagonal principal.
da diagonal secundária.
de todos os elementos da matriz.
Escreva estas somas e a matriz.
*/
void preencheMatriz(int m[TAM][TAM], int* somaTotal);
void verificacoes(int m[TAM][TAM],int* somaL4,int* somaC2,int* somaDP,int* somaDS);
void imprimirMatriz(int m[TAM][TAM]);

int main(){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int m[TAM][TAM],i,j,somaL4=0, somaC2=0, somaDP=0, somaDS=0, somaTotal=0;
    int *pst=&somaTotal;
    preencheMatriz(m,pst);
    verificacoes(m,&somaL4,&somaC2,&somaDP,&somaDS);
    imprimirMatriz(m);
    
    printf("Soma da Linha 4: %d \n",somaL4);
    printf("Soma da Coluna 2: %d \n",somaC2);
    printf("Soma da Diagonal Principal: %d \n",somaDP);
    printf("Soma da Diagonal Secundaria: %d \n",somaDS);
    printf("Soma Total da Matriz: %d \n",somaTotal);

    
    return 0;
}
void preencheMatriz(int m[TAM][TAM], int* somaTotal){
    int i,j;
    for(i=0;i<TAM;i++){
        for(j=0;j<TAM;j++){
            printf("Digite o valor para m[%d][%d] \n",i,j);
            scanf("%d",&m[i][j]);
            *somaTotal+=m[i][j];
        }
    }
}

void verificacoes(int m[TAM][TAM],int* somaL4,int* somaC2,int* somaDP,int* somaDS){
    int i,j;
    for(i=0;i<TAM;i++){
        for(j=0;j<TAM;j++){
            if(i==4){
                *somaL4 += m[i][j];
            }
            if(j==2){
                *somaC2 += m[i][j];
            }
            if(j==i){
                *somaDP += m[i][j];
            }
            if(j+i==4){
                *somaDS += m[i][j];
            }
        }
    }
}

void imprimirMatriz(int m[TAM][TAM]){
    int i,j;
    for(i=0;i<TAM;i++){
        for(j=0;j<TAM;j++){
            printf("%d ",m[i][j]);
        }
        printf("\n");
    }
}