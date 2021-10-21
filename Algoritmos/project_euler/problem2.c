#include <stdio.h>

int main(){
    int n=4000000;
    int n1=1;
    int n2=2;
    int next=n1+n2;
    int sum=n1+n2+next;
    while(next<n){
        n1=n2;
        n2=next;
        next=n1+n2;
        if(next%2==0){
            sum+=next;
        }
    }
    printf("%d",sum);
}