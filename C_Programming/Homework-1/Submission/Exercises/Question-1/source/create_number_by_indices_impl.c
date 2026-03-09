#include "functions.h"
int createNumByIdx(int num, int indices) {
    int result = 0, multiplier = 1;

    while (indices > 0) {
        int index = indices % 10;
        int digit = extractDigitByIndex(num, index);

        if (digit == -1) {
            return -1; 
        }

        result += digit * multiplier;
        multiplier *= 10;
        indices /= 10;
    }

    return result;
}