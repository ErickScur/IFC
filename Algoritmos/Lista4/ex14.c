#include <stdio.h>
#define TAM 10
//Leia uma matriz 10 x 10 que se refere respostas de 10 questões de múltipla escolha, referentes a 10 alunos.
// Leia também um vetor de 10 posições contendo o gabarito de respostas que podem ser a, b, c ou d. 
//Seu programa deverá comparar as respostas de cada candidato com o gabarito e emitir um vetor Resultado, contendo a pontuação correspondente.
void zeraVetor(int *resultado);
void preencheRespostas(char respostas[TAM][TAM]);
void preencheGabarito(char *gabarito);
void verificacao(char respostas[TAM][TAM],char* gabarito, int* resultado);
void imprimeVetor(int *v);

int main (){
    int i,j;
    char respostas[TAM][TAM],gabarito[TAM];
    int resultado[TAM];
    zeraVetor(&resultado);
    preencheRespostas(respostas);
    preencheGabarito(&gabarito);
    verificacao(respostas,&gabarito,&resultado);

    
    printf("Resultado:\n");
    imprimeVetor(&resultado);
    return 0;
}
void zeraVetor(int *resultado){
    int i;
    for(i=0;i<TAM;i++){
        resultado[i]=0;
    }
}
void preencheRespostas(char respostas[TAM][TAM]){
    int i,j;
    for(i=0;i<TAM;i++){
      printf("Informe as respostas do aluno %d: \n",i+1);
      for(j=0;j<TAM;j++){
        printf("Questao %d/%d (a, b, c ou d) \n",j+1,TAM);
        scanf("%c",&respostas[i][j]);
        getchar();
      }
    }
}
void preencheGabarito(char *gabarito){
    int i;
    for(i=0;i<TAM;i++){
      printf("Informe o gabarito da questao %d\n",i+1);
      scanf("%c",&gabarito[i]);
      getchar();
    }
}
void verificacao(char respostas[TAM][TAM],char* gabarito, int* resultado){
  int i,j;
  for(i=0;i<TAM;i++){
    for(j=0;j<TAM;j++){
      if(respostas[i][j]==gabarito[i]){
          resultado[i]++;
      }
    }
  }
}
void imprimeVetor(int *v){
    int i;
    for(i=0;i<TAM;i++){
        printf("Aluno %d: %d pontos\n",i,v[i]);
    }
}

