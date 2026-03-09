#include <stdio.h>
#include <string.h>


int intCmp(void *a , void *b){
    return *(int*)a - *(int*)b;
}


int doubleCmp(void *a , void *b){
    return *(double*)a - *(double*)b;
}


int charPointerCmp(void *a , void *b){
     return strcmp(*(char **)a, *(char **)b);
}

int stringCmp(void *a , void *b){
    return (strcmp((char*)a, (char*)b));
}



void sort(void *arr , int sizeOf , int size , int (*cmp)(void*,void*)){
    for(int i = 0 ; i < size - 1 ; i++){
        for(int j = 0 ; j < size - i - 1 ; j++){
        void* current = (char*)arr+(j*sizeOf);
        void* next = (char*)arr+((j+1)*sizeOf);
            if (cmp(current, next) > 0) {
                for (int k = 0; k < sizeOf; k++) {
                    char temp = *((char *)current + k);
                    *((char *)current + k) = *((char *)next + k);
                    *((char *)next + k) = temp;
                }
            }
        }
    }
}













int main(){
    int a[] = {2,7,6,4,1};
    double b[] = {12.5,2.7,3.0,5.5,5.9,1.0};
    
    puts("\noriginal int array:");
    for(int i = 0 ; i < 5 ; i++){
        printf("%d ",*(a+i));
    }
    printf("\n");
    sort(a, sizeof(int) , 5 , intCmp);
    puts("\nsorted int array:");
    for(int i = 0 ; i < 5 ; i++){
        printf("%d ",*(a+i));
    }
    puts("   ");
    puts("\noriginal double array:");
    for(int i = 0 ; i < 6 ; i++){
        printf("%.1f ",*(b+i));
    }
    puts("   ");
    sort(b, sizeof(double) , sizeof(b)/sizeof(b[0]), doubleCmp);
    puts("\nsorted double array:");
    for(int i = 0 ; i < 6 ; i++){
        printf("%.1f ",*(b+i));
    }
    puts("   ");

    char *d[] = {"abc" , "xy" , "ac"};
    puts("\noriginal pointer char array:");
    for(int i = 0 ; i < 3 ; i++){
        printf("%s ",*(d+i));
    }
    puts("   ");
    sort(d, sizeof(char*) , 3 , charPointerCmp);
    printf("\nsortd pointer char array:\n");
    for(int i = 0 ; i < 3 ; i++){
        printf("%s ",*(d+i));
    }
    puts("   ");
    char c[][5] = {"abc", "xy", "ac"};
    int cSize = sizeof(c) / sizeof(c[0]);
    printf("\nOriginal fixed-size char array:\n");
    for (int i = 0; i < cSize; i++) {
        printf("%s ", c[i]);
    }
    printf("\n");
    sort(c, sizeof(c[0]), cSize, stringCmp);
    printf("\nSorted fixed-size char array:\n");
    for (int i = 0; i < cSize; i++) {
        printf("%s ", c[i]);
    }
    printf("\n");
return 0;
}