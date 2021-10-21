#include <stdio.h>
#include <stdlib.h>
#include<time.h>
#define TAM 30

typedef struct{
    float min;
    float max;
    float abertura;
    float fechamento;
} candle;

candle* alocaVetorCandles(int); //aloca a memoria para o vetor de candles
float* alocaVetor(int); //aloca a memoria pasra um vetor float
void carregaVetor(int ,candle*); //carrega o vetor com as candles
void encontraCandlesPeriodo(int,candle*); //encontra e imprime os candles de um respectivo periode de tempo
void calculaMedias(int, float*, candle*);//popula o vetor de media com as medias
void encontrarMaiorFechamento(int, candle*); //encontra e imprime o dia que teve o maior fechamento e o seu valor
void encontrarMenorAbertura(int, candle*); //encontra e imprime o dia que teve a menor abertura e o seu valor
void encontrarMediaMaiorQueAbertura(int, float*, candle*);//encontra os dias em que a media dos valores maximos e minimos foram maior que a abertura do dia anterior
int main(){
    candle *candles;
    float *medias;

    candles = alocaVetorCandles(TAM);
    carregaVetor(TAM,candles);

    encontraCandlesPeriodo(TAM, candles);

    medias=alocaVetor(TAM);
    calculaMedias(TAM, medias, candles);

    encontrarMaiorFechamento(TAM, candles);
    encontrarMenorAbertura(TAM, candles);

    encontrarMediaMaiorQueAbertura(TAM,medias,candles);
    return 0;
}

candle* alocaVetorCandles(int tam){
    candle* p;
    p=malloc(tam*sizeof(candle));
    return p;
}
void carregaVetor(int tam,candle* vet){
    int i;
    srand(time(NULL));
    for(i=0;i<tam;i++){
        if(i==0){ //caso for o primeiro elemento o valor de abertura sera gerado de forma aleatoria
            vet[i].abertura=rand() % 100;
        }else{
            vet[i].abertura=vet[i-1].fechamento; //caso nao for o primeiro, o valor de abertura sera o de fechamento do anterior
        }

        //Caso o valor minimo for maior que o maximo, ele ira entrar no loop e so vai acabar quando o maximo foi maior que o minimo
        do{
            vet[i].min=rand() % 100;
            vet[i].max=rand() % 100;
        }while(vet[i].min>vet[i].max);

        //A linha abaixo faz com que o valor de fechamento da candle nao seja menor que o valor minimo e nem maior que o valor maximo
        do{
            vet[i].fechamento = fmod(rand(),vet[i].max);
        }while(vet[i].fechamento < vet[i].min);
    }
}
void encontraCandlesPeriodo(int tam,candle* candles){
    int i, max, min;
    printf("Favor informe o dia inicial(minimo %d, maximo %d):",1,tam);
    scanf("%d",&min);
    printf("Favor informe o dia final(minimo %d, maximo %d):",min,tam);
    scanf("%d",&max);

    if(max<min){
        printf("Valor digitado incorreto!\n");
        exit(1);
    }
    min--; //diminuir 1 para utilizar no for como indice do vetor
    for(i=min;i<max;i++){
        printf("--------------------------\n");
        printf("Dia %d: \n",i+1);
        printf("Valor de abertura: %f \n",candles[i].abertura);
        printf("Valor de fechamento: %f \n",candles[i].fechamento);
        printf("Valor maximo: %f \n",candles[i].max);
        printf("Valor minimo: %f \n",candles[i].min);
    }
}
float* alocaVetor(int tam){
    float* p;
    p=malloc(tam*sizeof(float));
    return p;
}

void calculaMedias(int tam, float* medias, candle* candles){
    int i;
    for(i=0;i<tam;i++){
        medias[i]=(candles[i].min + candles[i].max)/2;
    }
}
void encontrarMaiorFechamento(int tam, candle* candles){
    int i,dia;
    float maior=0;
    for(i=0;i<tam;i++){
        if(candles[i].fechamento>maior){
            maior = candles[i].fechamento;
            dia=i+1;
        }
    }
    printf("--------------------\n");
    printf("O maior fechamento foi no dia %d, com um valor de %f\n",dia,maior);
}
void encontrarMenorAbertura(int tam, candle* candles){
    int i,dia;
    float menor;
    menor=candles[0].abertura;
    for(i=0;i<tam;i++){
        if(candles[i].abertura<menor){
            menor=candles[i].abertura;
            dia=i+1;
        }
    }
    printf("--------------------\n");
    printf("A menor abertura foi no dia %d, com um valor de %f\n",dia,menor);
}
void encontrarMediaMaiorQueAbertura(int tam, float* medias, candle* candles){
    int i, dia=0;
    printf("--------------------\n");
    for(i=1;i<tam;i++){ //começando por 1 porque o dia 0 nao tem dia anterior
        if(medias[i]>candles[i-1].abertura){
            dia=i;
            if(dia!=0){
                printf("A Candle do dia %d teve a media maior que a abertura do dia anterior\n",dia+1);
            }
        }
    }
    if(dia==0){
        printf("Nenhum dia teve a media maior que a abertura do dia anterior\n");
    }
}
