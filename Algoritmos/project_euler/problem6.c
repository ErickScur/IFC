#include <stdio.h>

int main(){
    int somaQuadrados=0,i;
    int somaNumeros=0;
    int quadradoDaSoma, diferenca;
    for(i=1;i<=100;i++){
        somaQuadrados += i*i;
        somaNumeros +=i;
    }
    quadradoDaSoma = somaNumeros*somaNumeros;
    diferenca=quadradoDaSoma-somaQuadrados;
    printf("%d",diferenca);
    return 0;
}
