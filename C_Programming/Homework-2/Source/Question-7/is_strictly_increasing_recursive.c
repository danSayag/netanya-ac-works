#include <stdio.h>

int q7(int a[] , int size){
    if(size <= 1)
        return 1;
    if(a[size-1] > a[size-2]){
        return 1;
    }
    return 0;
    return q7(a , size-1);
}


int main() {
    int arr1[] = {1, 2, 3, 5, 9};
    int size1 = sizeof(arr1) / sizeof(arr1[0]);
    printf("Array: ");
    for (int i = 0; i < size1; i++) {
        printf("%d ", arr1[i]);
    }
    printf("\n");
    printf("Result for arr1: %d\n", q7(arr1, size1)); 

    int arr2[] = {3, 2, 1};
    int size2 = sizeof(arr2) / sizeof(arr2[0]);
    printf("Array: ");
    for (int i = 0; i < size2; i++) {
        printf("%d ", arr2[i]);
    }
    printf("\n");
    printf("Result for arr2: %d\n", q7(arr2, size2));

    return 0;
}