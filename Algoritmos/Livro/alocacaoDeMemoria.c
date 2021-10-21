#include <stdio.h>

int main(){
    int m=10; //? numero de elementos a ser alocado
    int *v; //? criacao de ponteiro
    int i;
    v=malloc(m*sizeof(int)); //! aloca a memoria e transforma v em um vetor

    if(v==NULL){ //* caso a memoria nao seja suficiente
        printf("Memoria insuficiente");
        exit(1);
    }

    for(i=0;i<m;i++){
        v[i]=i;
        printf("%d \n",v[i]);
    }
    
    free(v); //! libera o espaco de memoria alocado
    return 0;
}
