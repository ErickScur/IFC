//? Amo a Isabeli Pastore <3
#include <stdio.h>

typedef struct //! Cria uma STRUCT para armazenar os dados de uma pessoa
{
    float Peso;   //? define o campo Peso
    int Idade;    //? define o campo Idade
    float Altura; //? define o campo Altura
} Pessoa; //! Define o nome do novo tipo de dado que foi criado

void ImprimePessoa(Pessoa *P){//* Recebe um ponteiro
  printf("Idade: %d  Peso: %f Altura: %f\n", P->Idade, P->Peso, P->Altura);//* acessa os valores 
}

void SetPessoa(Pessoa *P, int idade, float peso, float altura){ //! Nesta função o parâmetro P é um ponteiro para uma struct
    P->Idade = idade;  
    P->Peso = peso;    
    P->Altura = altura;
}
   
int main(){
    Pessoa Joao;
    Pessoa *p= &Joao; //! CRIACAO DE PONTEIRO
    SetPessoa(p, 15, 70.5, 1.75);//! PASSA O ENDERECO DA STRUCT JOAO PARA A FUNCAO
    ImprimePessoa(p);

    return 0;
}