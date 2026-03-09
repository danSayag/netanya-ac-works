#include <stdio.h>
#include <stdlib.h>
#include "functions.h"





int main() {
    int num, indices;

    printf("Enter a positive number (num): ");
    if (scanf("%d", &num) != 1) {
        fprintf(stderr, "Error: Invalid input. Exiting with code 4.\n");
        exit(4);
    }

    printf("Enter indices (positive number): ");
    if (scanf("%d", &indices) != 1) {
        fprintf(stderr, "Error: Invalid input. Exiting with code 4.\n");
        exit(4);
    }

    
    int validation = validateInput(num, indices);
    if (validation != 0) {
        fprintf(stderr, "Error: Invalid input. Exiting with code %d.\n", validation);
        exit(validation);
    }


    int result = createNumByIdx(num, indices);
    if (result == -1) {
        fprintf(stderr, "Error: Invalid index in indices. Exiting with code 1.\n");
        exit(1);
    }

  
    printf("The resulting number is: %d\n", result);
    return 0;
}