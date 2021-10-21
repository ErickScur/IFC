#include <stdio.h>
#include <locale.h>

/*Uma empresa decidiu fazer um levantamento em relação aos candidatos que se apresentarem para preenchimento de vagas no seu quadro de funcionários. 
Supondo que você seja o programador dessa empresa, faça um programa que leia para cada candidato a idade, o sexo (M=1 ou F=2) e a experiência no serviço (S=1 ou N=2). 

Para encerrar a entrada de dados, digite zero para a idade. Calcule e escreva: 

número de candidatos do sexo feminino; 
número de candidatos do sexo masculino; 
a idade média dos homens que já têm experiência no serviço;
a porcentagem dos homens com mais de 45 anos entre o total dos homens; 
número de mulheres com idade inferior a 35 anos e com experiência no serviço;
a menor idade entre as mulheres que já têm experiência no serviço.
*/


int main (){
    setlocale(LC_ALL, "Portuguese_Brazil");

    int idade, sexo,exp,tf=0,tm=0,tme=0,somaIdadeComExp=0,t45=0,texp35=0,menorComExp=10000;
    float mediaExp,porcentagem45;
    
    do{
        printf("Informe a idade (0 para parar)");
        scanf("%d",&idade);
        if(idade==0){
            break;
        }else{
            printf("Informe o sexo (M=1 ou F=2)");
            scanf("%d",&sexo);

            printf("Informe a experiencia (S=1 ou N=2)");
            scanf("%d",&exp);
            if(sexo==1){
                tm++;   //numero de homens
                if(exp==1){ 
                    tme++; //total de homens com experiencia
                    somaIdadeComExp+=idade; //soma das idades para calcular a media
                }
                if(idade>45){
                    t45++; //total de homens +45
                }
            }else{
                tf++; //numero de mulheres
                if(exp==1){
                    if(idade<35){
                        texp35++; //total de mulheres com menos de 35 e experiencia
                    }
                    if(idade<menorComExp){
                        menorComExp=idade; //a menor idade entre as mulheres que já têm experiência no serviço.
                    }
                }
            
            }
        }
    }while(idade!=0);
    mediaExp=somaIdadeComExp/tme;
    porcentagem45 = (t45 * 100)/tm;
    
    
    printf("numero de candidatos do sexo masculino: %d\n", tm);
    printf("numero de candidatos do sexo feminino: %d\n", tf);
    printf("a idade media dos homens que ja tem experiencia no servico: %f\n", mediaExp);
    printf("a porcentagem dos homens com mais de 45 anos entre o total dos homens: %f\n", porcentagem45);
    printf("numero de mulheres com idade inferior a 35 anos e com experiencia no servico: %d\n", texp35);
    printf("a menor idade entre as mulheres que ja tam experiência no servico: %d\n",menorComExp);


   

    return 0;
}

