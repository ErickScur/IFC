#include <stdio.h>


int main() {
    int n1,n2,r=0;
    int n;
    int remainder;
    int numeroInverso;
    int maior=0;
    for(n1=999;n1>100;n1--){
        for(n2=999;n2>100;n2--){
            n = n1*n2;
            numeroInverso=n;
            //printf("%d x %d = %d ",n1,n2,n);

            while (n != 0)
            {
                r = r * 10;
                r = r + n%10;
                n = n/10;
            } 
            //printf("%d\n",r);
            if(numeroInverso==r){
                if(r>maior){
                    maior = r;
                    printf("MAIOR ENCONTRADO: %d x %d = %d \n",n1,n2,maior);
                }
            }
            r=0;
        }
    }
    printf("MAIOR DE TODOS: %d",maior);
    
    


    
     
   return 0;
}