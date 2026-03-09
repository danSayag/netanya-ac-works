

int extractDigitByIndex(int num, int index) {
    int digits[10], i = 0; 
    while (num > 0) {
        digits[i++] = num % 10;
        num /= 10;
    }
    if (index < 0 || index >= i) {
        return -1; 
    } 
    return digits[i - index - 1];
}