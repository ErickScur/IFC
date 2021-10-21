#include <stdio.h>
int IsPrime(unsigned int number) {
    if (number <= 1) return 0; // zero and one are not prime
    unsigned int i;
    for (i=2; i*i<=number; i++) {
        if (number % i == 0) return 0;
    }
    return 1;
}
int main(){

    int n = 10001,i=1,cont=1;
    do{
        if(IsPrime(i)==1){
            printf("%d \n",i);
            cont++;
            i++;
        }else{
            i++;
        }
        
    }while(cont<=n);
}