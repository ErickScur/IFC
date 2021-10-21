#include <stdio.h>
#define STB_IMAGE_IMPLEMENTATION
#include "stb_image.h"



   
int main(){
    int x,y,n;
    unsigned char *img = stbi_load("laranja.png", &x, &y, &n, 0);
    
    return 0;
}