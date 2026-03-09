#include <stdio.h>

void arrPrint(int a[] , int size){
printf("[");
for (int i = 0; i < size; i++) {
        printf("%d", a[i]);
        if(i < size-1){
            printf(",");
        }
    }
    printf("]\n");
}