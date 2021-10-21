#include <stdio.h>
#include <locale.h>

//João tem 1,50 metro e cresce 2 centímetros por ano, enquanto Zé tem 1,10
//metro e cresce 3 centímetros por ano. Construa um algoritmo que calcule e
//imprima quantos anos serão necessários para que Zé seja maior que João.


int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int cont;
    double aj,az;
    
    aj=1.50;
    az=1.10;
    cont=0;
    while(az<aj){
        aj+=0.02;
        az+=0.03;
        cont++;
        printf("Ano %d: \n Joao: %f \n Ze:%f \n",cont,aj,az);
    }  
    printf("Sao necessarios %d anos",cont);
   

    return 0;
}

