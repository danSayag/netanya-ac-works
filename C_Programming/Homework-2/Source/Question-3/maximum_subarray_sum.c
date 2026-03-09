#include <stdio.h>
#include "arrPrint.c"



    void maxSubArr(int a[] ,int length ){
        if(length == 0){
            printf("Oop you are empty!!\n");
        }
        int b[length];
        int max = a[0] , maxStart = 0 , maxEnd = 0; 
        b[0] = a[0];

        for(int i = 1 ; i < length ; i++){            
            if (b[i-1] > 0){
                b[i] = b[i-1] + a[i];
            }
            else{
                b[i] = a[i];
                maxStart = i;
            }
            if(max < b[i]){
                max = b[i];
                maxEnd = i;
            }       
        }
    printf("maxSum = %d \n" , max);
    printf("maxSum Arr = [");
        for( int i = maxStart  ; i <= maxEnd ; i++){
            printf("%d" , a[i]);
            if(i!=maxEnd)
                printf(",");
        } 
        printf("]\n");
    }


int main(){
    int a[] = {-3,1,-3,4,-1,2,1,-5,4};
    int size = sizeof(a)/sizeof(a[0]);
    printf("original Arr = ");
    arrPrint(a , size);
    maxSubArr(a , size);
    return 0;
}






