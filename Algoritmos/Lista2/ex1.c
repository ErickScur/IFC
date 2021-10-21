#include <stdio.h>
#include <locale.h>


int main (){
    int vi=3000,vf=1000,cont=0;

    while(vi>vf){
        cont++;
        vi = vi-((vi/100)*10);
        printf("ano %d: %d \n",cont, vi);
    } 
    printf("\n %d anos",cont);
    return 0;
}

