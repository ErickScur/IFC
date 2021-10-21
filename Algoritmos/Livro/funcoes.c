#include <stdio.h>
void fat(int n);//! PROTOTIPO DA FUNCAO
//! VOIDA = NAO RETORNA VALOR (RETURN)

int main (){
    int n;
    printf("Digite o numero: \n");
    scanf("%d",&n);    
    fat(n); //! CHAMADA DA FUNCAO
}

void fat(int n){ //!CRIACAO DO CORPO DA FUNCAO
    int i;
    int f=1;
    for(i=1;i<=n;i++)
        f*=i;
    printf("Fatorial de %d: %d",n,f);
}