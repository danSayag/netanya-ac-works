#include <stdio.h>
#include <stdlib.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void bubbleSort(int arr[], int size) {
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(&arr[j], &arr[j + 1]);
            }
        }
    }
}


void arrangeSmallLargeAlternating(int arr[], int size) {
    bubbleSort(arr, size);

    int temp[size];
    int smallIndex = 0, largeIndex = size - 1;
    int toggle = 1; 
    for (int i = 0; i < size; i++) {
        if (toggle) {
            temp[i] = arr[smallIndex++];
        } else {
            temp[i] = arr[largeIndex--];
        }
        toggle = !toggle;
    }
    for (int i = 0; i < size; i++) {
        arr[i] = temp[i];
    }
}

void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int arr[] = {5, 2, 9, 3, 7, 1, 8, 4, 6};
    int size = sizeof(arr) / sizeof(arr[0]);

    printf("Original array: ");
    printArray(arr, size);

    arrangeSmallLargeAlternating(arr, size);

    printf("Rearranged array: ");
    printArray(arr, size);

    return 0;
}
