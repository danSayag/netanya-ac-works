#include <stdio.h>

void reverseArray(int *array, int size) {
    for (int i = 0; i < size / 2; i++) {
        int temp = array[i];
        array[i] = array[size - 1 - i];
        array[size - 1 - i] = temp;
    }
}

void transpose(int *All[]) {
    int i = 0;
    while (All[i] != NULL) {
        int size = All[i][0];
        reverseArray(All[i] + 1, size);
        i++;
    }
}

int main() {
    int A[] = {5, -5, 14, 5, 2};
    int B[] = {3, 6, 11};
    int C[] = {4, 1, -3, 4};
    int D[] = {6, 2, 7, 1, 8, 2};
    int E[] = {2, 15};
    int F[] = {3, 4, -2};
    int *All[] = {A, B, C, D, E, F, NULL};

    printf("Original structure:\n");
    for (int i = 0; All[i] != NULL; i++) {
        printf("%d -> [", All[i][0]);
        for (int j = 1; j <= All[i][0]; j++) {
            printf("%d", All[i][j]);
            if (j < All[i][0]) printf(", ");
        }
        printf("]\n");
    }

    transpose(All);

    printf("\nTransposed structure:\n");
    for (int i = 0; All[i] != NULL; i++) {
        printf("%d -> [", All[i][0]);
        for (int j = 1; j <= All[i][0]; j++) {
            printf("%d", All[i][j]);
            if (j < All[i][0]) printf(", ");
        }
        printf("]\n");
    }

    return 0;
}
