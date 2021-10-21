/*Faça um programa que calcule o salário líquido dos funcionários de uma empresa. O salário líquido é composto por descontos e adicionais, seguindo as seguintes regras:

Descontos:
Salário bruto < 800,00 – não realizar nenhum desconto;
800,00 <= Salário bruto <=1600,00 – descontar 8% de Imposto de Renda e 5% de encargos.
Salário bruto > 1600,00 – descontar 15% de Imposto de Renda e 7% de encargos.

Adicionais:
Caso o funcionário tenha trabalhado mais de 160 horas no mês, divida o seu salário bruto por 160 (representa horas trabalhadas) e calcule 50% de adicional nas horas que excederem a 160.

O usuário deverá digitar o salário bruto e o número de horas trabalhadas no mês de cada funcionário, e deverá receber como resultado
 o salário líquido. Para finalizar o programa o usuário deverá digitar 0 no salário bruto, ao finalizar o programa exibir o total geral dos salários líquidos.
*/
#include <stdio.h>
#include <locale.h>

int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int nHoras,horasExtras;
    float sBruto,sLiquido,valorDaHora;
    do{
        printf("Informe o salario bruto: \n");
        scanf("%f",&sBruto);

        printf("Informe o numero de horas: \n");
        scanf("%d",&nHoras);
        
        if(sBruto==0){
            break;
        }else if(sBruto<800){
            sLiquido = sBruto;
        }else if(sBruto>=800 && sBruto<=1600){
            sLiquido = sBruto - ((sBruto*8)/100);
            sLiquido = sLiquido - ((sLiquido*5)/100);
        }else if(sBruto>1600){
            sLiquido = sBruto - ((sBruto*15)/100);
            sLiquido = sLiquido - ((sLiquido*7)/100);
        }

        if(nHoras>160){
            horasExtras = nHoras-160;
            valorDaHora = sBruto/nHoras;
            sLiquido = sBruto + (horasExtras * valorDaHora);
        }
        printf("Salario Liquido: %f \n",sLiquido);
        
    }while(sBruto!=0); 

    return 0;
}

