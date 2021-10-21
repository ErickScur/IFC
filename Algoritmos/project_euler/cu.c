#include <stdio.h>

int main()
{
    int i = 999,  //contador
        j,        //contador
        n,        //numero calculado
        t,        //numero temporario
        ni,       //numero invertido
        im,       //i do MNC
        jm,       //j do MNC
        mnc = 0;  //maior numero capicua
    for (n = i * i; n > mnc; n = i * i){
        for (j = i; n > mnc; n = i * j){
            ni = 0;
            //inverte o número:
            for (t = n; t > 0; t /= 10){
                ni = ni * 10 + t % 10;
            }
            //Se for capicua guarda como sendo o novo MNC:
            if (n == ni) {
                    mnc = n;
                    im = i;
                    jm = j;
            }
            j--;
        }
        i--;
    }
    printf("Maior numero capicua: %d = %d x %d\n", mnc, im, jm);
    return 0;
}