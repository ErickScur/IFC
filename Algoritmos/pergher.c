#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <math.h>

npoints = 10000
circle_count = 0

do j = 1,npoints
      generate 2 random numbers between 0 and 1
      xcoordinate = random1
      ycoordinate = random2
      if (xcoordinate, ycoordinate) inside circle
      then circle_count = circle_count + 1
end do

PI = 4.0*circle_count/npoints
/

typedef struct{
    double x;
    double y;
}ponto;

ponto gerarPonto(){
    ponto *ponto;
    ponto = malloc(sizeof(ponto));
    srand(time(NULL));
    ponto -> x = (double)rand() / RAND_MAX * 2.0 - 1.0;
    ponto -> y = (double)rand() / RAND_MAX * 2.0 - 1.0;

    return ponto;
}


double calculaPi(int n)
{
    int i, insideCircle = 0;
    //double x, y;
    ponto *ponto;


    for (i = 0; i < n; i++)
    {
        ponto = gerarPonto();

        if (ponto -> x * ponto -> x + ponto -> y * ponto -> y <= 1)
        {
            insideCircle++;
        }
        free(ponto);
    }

    return (double)4 * insideCircle / n;
}

int selecionaQuantidade()
{
    int n;
    printf("Escolha a quantidade de pontos a serem gerados(Quanto mais, mais aproximado vai ser o resultado)\n");
    scanf("%d", &n);

    return n;
}

void imprimePi()
{
    int n = selecionaQuantidade();
    double pi = calculaPi(n);
    printf("%lf", pi);
}

int main(void)
{
    imprimePi();

    return 0;
}