#include <stdio.h>

void printPol(int a[] , int sizeA){
    for(int i = sizeA-1 ; i >= 0 ; i--){
        if(a[i] != 0)
        printf("%d",a[i]);
        if(i >= 1 && a[i] != 0){
            printf("x");
        }
        if(i > 1 && a[i] != 0){
            printf("^%d", i);
        }
        if(a[i-1] > 0 && a[i-1] != 0 && i != 0){
            printf("+");
        }
    }
    printf("\n");
}



void divPol(int A[] , int sizeA , int B[], int sizeB){
    printf("pol 1 = ");
    printPol(A , sizeA);
    printf("pol 2 = ");
    printPol(B,sizeB);
    int sizeQuotient = sizeA - sizeB + 1;
    int quotient[sizeQuotient];
    int remainder[sizeA];

    
    for (int i = 0; i < sizeA; i++) {
        remainder[i] = A[i];
    }
    
    for (int i = 0; i < sizeQuotient; i++) {
        quotient[i] = remainder[sizeB - 1 + i] / B[sizeB - 1];
        for (int j = 0; j < sizeB; j++) {
            remainder[sizeB - 1 + i - j] -= quotient[i] * B[sizeB - 1 - j];
        }
    }

    printf("remainder = ");
    printPol(remainder,sizeA);
    printf("quotient = ");
    printPol(quotient,sizeQuotient);
}


int main(){
    int a[] = {5 , -6 , 0 ,2};
    int size = sizeof(a)/sizeof(a[0]);
    int b[] = {2 , 0 ,2};
    int sizeb = sizeof(b)/sizeof(b[0]);
    divPol(a, size , b ,sizeb);

    return 0;
}