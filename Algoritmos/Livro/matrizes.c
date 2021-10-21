#include <stdio.h>
#include <locale.h>
int* transposta(int i, int j, int* M);//! PROTOTIPO DA FUNCAO, INT* EH PQ A FUNCAO IRA RETORNAR O ENDERECO DE UMA MATRIZ E NAO A MATRIZ EM SI
int main (){

    int m[4][3]= {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};//! matrizes podem ser inicializadas na declaracao
    printf("%d \n",m[0]); //? imprime o endereco do primeiro item do primeiro vetor linha
    printf("%d \n",*m[0]); //? imprime o conteudo do primeiro item do primeiro vetor linha
    printf("%d \n",*(m[0]+1)); //? imprime o conteudo do proximo item

    int matriz[][3]={1,2,3,4,5,6}; //! podemos omitir o numero de linhas, mas nunca o numero de elementos por linha(colunas)
    printf("%d \n",matriz[0][5]);
    return 0;
}

//funcao que troca as linhas e colunas
int* transposta(int i, int j, int* M){
    int x,y;
    int* trp;

    //!aloca o espaco na memoria para a matriz
    trp=malloc(i*j*sizeof(int));

    //!preenche a matriz
    for(x=0;x<i;x++){
        for(y=0;i<j;y++){
            trp[y*i+x]= M[x*j+y];
        }
    }
    return(trp);
}

