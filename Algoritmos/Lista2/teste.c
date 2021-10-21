#include <stdio.h>
#include <locale.h>

//Fa�a um algoritmo para calcular e exibir do sal�rio l�quido de um professor, onde o n�mero de horas, o valor da hora e o percentual do INSS devem ser fornecidos pelo usu�rio:
//salario_bruto = num_hora_aula * valor_hora_aula
//salario_liquido = salario_bruto � (salario_bruto * percentual_INSS).


int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    float h, vh, inss, sb, sl;
    printf("Informe o numero de horas: ");
    scanf("%f", &h);

    printf("Informe o valor da hora: ");
    scanf("%f", &vh);

    printf("Informe o percentual do inss: ");
    scanf("%f", &inss);

    sb = h*vh;
    sl = sb-sb*(inss/100);

    printf("O salario bruto é: %f reais, descontando o percentual de %f do inss, o salario liquido é: %f",sb,inss,sl);

    return 0;
}

