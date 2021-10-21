#include <stdio.h>
#include <locale.h>

//Escrever em ordem decrescente os números múltiplos de 5 entre 100 e -100.

int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int i;
    
    for(i=100;i>=-100;i--){
      if(i%5==0){
          printf("%d \n",i);
      }
    }

   

    return 0;
}

