#include <stdio.h>
#include <stdarg.h>

void maxSubarraySum(int count, ...) {
    va_list args;
    va_list argsCopy; 
    va_start(args, count);
    va_copy(argsCopy, args);

    int maxSum = 0, currentSum = 0;
    int startIndex = 0, endIndex = 0, tempStart = 0;

    
    for (int i = 0; i < count; i++) {
        int num = va_arg(args, int);
        currentSum += num;

        if (currentSum > maxSum) {
            maxSum = currentSum;
            startIndex = tempStart;
            endIndex = i;
        }

        if (currentSum < 0) {
            currentSum = 0;
            tempStart = i + 1;
        }
    }

    va_end(args);

   
    printf("Max Subarray: [");
    for (int i = 0; i <= endIndex; i++) {
        int num = va_arg(argsCopy, int); 
        if (i >= startIndex && i <= endIndex) {
            printf("%d", num);
            if (i != endIndex) {
                printf(", ");
            }
        }
    }
    printf("]\n");

    va_end(argsCopy);
    printf("Max Sum: %d\n", maxSum);
}

int main() {
    maxSubarraySum(12, -3, 1, -3, 4, -1, 2, 1, -5, 4 , 2 , 25 , 10 );
    return 0;
}
