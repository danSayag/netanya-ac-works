#include <stdio.h>

int inArr( int num , int a[],int from, int size){
    for(int i = from ; i < size ; i++){
        if(a[i] == num){
            return i;
        }
    }
    return 0;
}


int inOrder(int a[] , int size){
    if(size == 1){
        return 1;
    }
    for(int i = 1 ; i < size ; i++){
        if(a[i-1] > a[i]){
            return 0;
        }
    }
    return 1;
}


void printArr(int a[] ,int size){
    printf("[");
    for(int i = 0 ; i < size; i++){
        printf("%d" , a[i]);
        if(i < size-1){
            printf(",");
        }
    }
    printf("]\n");
}


int q5(int a[], int b[], int sizeA, int sizeB) {
    if (sizeB > sizeA) {
        return 1; 
    }
    int c[sizeB];
    if(a[0] == b[0]){
        c[0] = 0;
    }

    for(int i = 1; i < sizeB; i++) {
        c[i] = inArr(b[i], a, i, sizeA); 
        }
    return inOrder(c , sizeB);

}





int main() {
    int a[] = {2, 8, 14, -9, 5, 19, 4};
    int b[] = {8, 5, 2, 4};
    int sizeA = sizeof(a)/sizeof(a[0]);
    int sizeB = sizeof(b)/sizeof(b[0]);
    printf("a[] = " );
    printArr(a,sizeA);
    printf("b[] = " );
    printArr(b,sizeB);

    int result = q5(a, b, sizeA, sizeB);
    if (result) {
        printf("b is a subarray of a.\n");
    } else {
        printf("b is not a subarray of a.\n");
    }

    int c[] = {2, 8, 14, -9, 5, 2, 19, 4};
    int d[] = {8, 5, 2, 4};
    int sizeD = sizeof(d)/sizeof(d[0]);
    int sizeC = sizeof(c)/sizeof(c[0]);
    printf("c[] = " );
    printArr(c,sizeC);
    printf("d[] = " );
    printArr(d,sizeD);

    int result2 = q5(c, d, sizeC, sizeD);
    if (result2) {
        printf("d is a subarray of c.\n");
    } else {
        printf("d is not a subarray of c.\n");
    }

    return 0;
}
