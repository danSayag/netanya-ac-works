#include <stdio.h>

void printBinary(int num) {
    unsigned int mask = 1u << 31;
    for(int i = 0; i < 32; i++) {
        printf("%d", (num & mask) ? 1 : 0);
        mask >>= 1;
    }
}

int rotateLeft(int a, int n) {
    n = n & 31;
    unsigned int leftShifted = (unsigned int)a << n;
    unsigned int wrap = (unsigned int)a >> (32 - n);
    return (int)(leftShifted | wrap);
}

int compressDigits(const char *str) {
    int result = 0;
    for(int i = 0; i < 8; i++) {
        int digit = str[i] - '0';
        digit = digit & 0xF;
        result = (result << 4) | digit;
    }
    return result;
}

int main() {
    int num = 12345;
    printf("Binary representation of %d:\n", num);
    printBinary(num);
    printf("\n\n");
    
    int a = 0x12345678;
    int n = 4;
    int rotated = rotateLeft(a, n);
    printf("Original (hex): 0x%X\n", a);
    printf("Rotate left by %d bits (hex): 0x%X\n\n", n, rotated);
    
    const char *str = "12345678";
    int compressed = compressDigits(str);
    printf("String: %s\n", str);
    printf("Compressed (hex): 0x%X\n", compressed);
    printf("Compressed (binary):\n");
    printBinary(compressed);
    printf("\n\n");
    
    return 0;
}
