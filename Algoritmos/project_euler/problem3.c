#include <stdio.h>


int main() {
   long int n,i,cont=4;
   n=600851475143;
   long int cleber[17425170l];
   cleber[0]=2;
   cleber[1]=3;
   cleber[2]=5;
   cleber[3]=7;
   for(i=7;i<600851475143;i++){
      if(i%2!=0 && i%3!=0 && i%5!=0 && i%7!=0){
         cleber[cont]=i;
         cont++;
         printf("%d",cleber[cont]);
      }
   }

     
   return 0;
}