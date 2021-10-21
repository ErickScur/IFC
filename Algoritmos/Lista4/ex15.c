#include <stdio.h>
#include <locale.h>
#define TAM 3

int verifica(char a);
void perguntaCidade(char* a);

int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    char origem,destino;
    int a,b,tabela[7][7] =
        {
        {0, 2, 11, 6, 15, 11, 1},
        {2, 0, 7, 12, 4, 2, 15},
        {11, 7, 0, 11, 8, 3, 13},
        {6, 12, 11, 0, 10, 2, 1},
        {15, 4, 8, 10, 0, 5, 13},
        {11, 2, 3, 2, 5, 0, 14},
        {1, 15, 13, 1, 13, 14, 0}
        }; 

    do{
        perguntaCidade(&origem);
        perguntaCidade(&destino);

        if(origem!=destino){
            a=verifica(origem);
            b=verifica(destino);
            if(a>=0 && b>=0)
                printf("%d horas! \n",tabela[a][b]);
        }else{
            printf("fim do programa!");
            break;
        }
        
    }while(origem!=destino);
    
    return 0;
}
int verifica(char a){
    switch(a){
        case 'a':
            return(0);
            break;
        case 'b':
            return(1);
            break;
        case 'c':
            return(2);
            break;
        case 'd':
            return(3);
            break;
        case 'e':
            return(4);
            break;
        case 'f':
            return(5);
            break;
        case 'g':
            return(6);
            break;
        default:
            printf("cidade invalida\n");
            return(-1);
            break;
    }
}
void perguntaCidade(char* a){
    printf("Informe a cidade(a,b,c,d,e,f ou g) \n");
    scanf("%c",a);
    getchar();

}
