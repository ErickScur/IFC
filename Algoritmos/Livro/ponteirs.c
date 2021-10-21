#include <locale.h>
#include <stdio.h>

int main (){

 
    //! & = endereço
    //! * = conteudo da variavel

    char c, *ponteiro, x;
    c = 'A'; 
    ponteiro = &c;//? define a variavel ponteiro como sendo o endereco da variavel C na memoria
    printf("%c \n",*ponteiro); //? imprime o valor da variavel C
    printf("%p \n",ponteiro); //? imprime o endereco da variavel C na memoria
    return 0;
}

