#include <stdio.h>
#include <locale.h>

//11. Calcular a soma dos 100 primeiros no naturais.


int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int i,soma=0;
    
    for(i=0;i<=100;i++){
      printf("%d + ",i);
      soma+=i;  
    }
    printf("\n resultado= %d",soma);
   

    return 0;
}

