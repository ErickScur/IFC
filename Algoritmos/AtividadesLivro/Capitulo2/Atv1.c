#include <stdio.h>

int main(){
    int n,cont=0,temp; 
    int i;

    printf("Informe o limite da sequencia: \n");
    scanf("%d",&n);
    int v[n];
    int impares[n];

    for(i=1;i<=n;i++){
        v[i]=i;
        if(v[i]%2!=0){
            impares[cont] = v[i];
            cont++;
        }
    }

    for(i=0;i<cont;i++){
        temp = impares[i];
        impares[i] = temp*temp*temp;
        printf("%d ",impares[i]);
    }


    
    
     
    
    
    return 0;
}
