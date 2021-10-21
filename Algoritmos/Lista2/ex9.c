#include <stdio.h>
#include <locale.h>

/*A prefeitura de uma cidade fez uma pesquisa entre seus habitantes,
coletando dados sobre o número de filhos e salário. A prefeitura deseja
saber:
a. média do salário da população;
b. média do número de filhos;
c. maior salário;
d. percentual de pessoas com salário até R$100,00.
O final da leitura de dados se dará com a entrada de um salário negativo.
*/
int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int totalHabitantes=0, numeroFilhos, totalFilhos=0, salarioAteCem=0;
    float salario,maiorSalario=0,totalSalarios=0,mediaSalario, mediaFilhos, percentualAteCem;

    
    do{
        printf("Informe o salario: (digite um salario negativo para parar) \n");
        scanf("%f",&salario);
        if(salario<0){
            break;
        }else if(salario>maiorSalario){
            maiorSalario=salario;
        }
        if(salario<=100){
            salarioAteCem++;
        }
        printf("Informe o numero de filhos: \n");
        scanf("%d",&numeroFilhos);

        totalHabitantes++;

        totalFilhos += numeroFilhos;

        

        totalSalarios+=salario;
        

    }while(salario>=0);
    
    mediaSalario = totalSalarios/totalHabitantes;
    mediaFilhos = totalFilhos/totalHabitantes;
    percentualAteCem = (salarioAteCem/totalHabitantes) * 100;
    printf("A média de sálario é: %f \n ",mediaSalario);
    printf("A média de filhos é: %f \n ",mediaFilhos);
    printf("O maior sálario é: %f \n ",maiorSalario);
    printf("O percentual de salarios ate 100 é: %f \n ",percentualAteCem);


    return 0;
}

