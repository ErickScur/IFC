#include <stdio.h>
#include <locale.h>
#define TAM 12

//Ler do teclado 12 números inteiros e armazená-los em um vetor N. Em seguida, copiar os elementos pares divisíveis por 3 para o vetor
// X e os ímpares divisíveis por 5 para o vetor Y.
void preencheVetor(int *n);
int isParDiv3(int *n,int i);
int isImparDiv5(int *n, int i);
void limpaVetor(int *v);
void imprimeVetor(int *v);

int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int i, n[TAM],x[TAM],y[TAM],contX=0,contY=0;
    int *pn = &n, *px = &x, *py = &y; //criacao de ponteiros

    preencheVetor(pn);
    limpaVetor(px);//tira o lixo de memoria
    limpaVetor(py);//tira o lixo de memoria
    for(i=0;i<TAM;i++){
        if(isParDiv3(pn,i)==1){
            x[contX] = n[i];
            contX++;
        }else if(isImparDiv5(pn,i)==1){
            y[contY]= n[i];
            contY++;
        }
    }
    printf("\nPares Divisiveis por 3: \n");
    imprimeVetor(px);
    printf("\nImpares Divisiveis por 5: \n");
    imprimeVetor(py);

    return 0;
}
void preencheVetor(int *n){
    int i;
    for(i=0;i<TAM;i++){
            printf("Informe o valor: %d/%d \n",i+1,TAM);
            scanf("%d",&n[i]);
    }
}
int isParDiv3(int *n,int i){
    if((n[i]%2==0) && (n[i]%3==0)){
        return(1);
    }else{
        return(0);
    }
}
int isImparDiv5(int *n, int i){
    if((n[i]%2!=0)&&(n[i]%5==0)){
        return(1);
    }else{
        return(0);
    }
}
void limpaVetor(int *v){
    int i;
    for(i=0;i<TAM;i++){
        v[i]=0;
    }
}
void imprimeVetor(int *v){
    int i;
    for(i=0;i<TAM;i++){
        printf("%d, ",v[i]);
    }
}