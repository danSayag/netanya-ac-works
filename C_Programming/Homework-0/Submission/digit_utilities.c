#include <stdio.h>
int sumDigits(int num);
int searchOnce(int num , int numToFind);
int countAll(int num , int numToFind);
int getMax(int num);
int sort(int num);
int reverse(int num);


int main() {
    int num , numToFind;

    // Test sumDigits
    printf("Enter a number for sumDigits: ");
    scanf("%d", &num);
    printf("The sum of the digits is: %d\n", sumDigits(num));

    // Test searchOnce
    printf("\nEnter a number for searchOnce: ");
    scanf("%d", &num);
    printf("Enter a digit to find: ");
    scanf("%d", &numToFind);
    if (searchOnce(num, numToFind) == 0)
        printf("The digit %d is found in %d.\n", numToFind, num);
    else
        printf("The digit %d is NOT found in %d.\n", numToFind, num);

    // Test countAll
    printf("\nEnter a number for countAll: ");
    scanf("%d", &num);
    printf("Enter a digit to count: ");
    scanf("%d", &numToFind);
    printf("The digit %d appears %d times in %d.\n", numToFind, countAll(num, numToFind), num);

    // Test getMax
    printf("\nEnter a number for getMax: ");
    scanf("%d", &num);
    printf("The maximum digit in %d is: %d\n", num, getMax(num));

    // Test sort
    printf("\nEnter a number for sort: ");
    scanf("%d", &num);
    printf("The sorted number is: %d\n", sort(num));

    // Test reverse
    printf("\nEnter a number to reverse: ");
    scanf("%d", &num);
    printf("The reversed number is: %d\n", reverse(num));

    return 0;
}



//q1
int sumDigits(int num){
    if(num<0) 
        return 0;
    if(num == 0) 
        return 0;
    return (num % 10) + sumDigits(num / 10);
}


//q2
int searchOnce(int num , int numToFind){
    if (num < 0)
        return 1;
    if(num == 0)
        return 1;
    if((num%10) == numToFind)
        return 0;
    return searchOnce((num / 10) , numToFind);
}


//q3
int countAll(int num , int numToFind){
    if(num < 0)
        return 0;
    if (num == 0)
        return 0;
    if((num % 10) == numToFind){
       return 1 + countAll(num / 10 , numToFind);
    }
    return countAll(num / 10, numToFind);
}


//q4
int getMax(int num){
    if (num < 10)
        return num;
    return num%10 > getMax(num/10) ? num%10 : getMax(num/10);
}


//q5
int sort(int num) {
    if (num < 10)
        return num;

    int lastDigit = num % 10;
    int sortedRest = sort(num / 10);
    int result = 0;
    int multiplier = 1;

    while (sortedRest > 0 || lastDigit != -1) {
        int currentDigit = sortedRest % 10;
        if (lastDigit != -1 && (sortedRest == 0 || lastDigit < currentDigit)) {
            result += lastDigit * multiplier;
            lastDigit = -1;
        } else {
            result += currentDigit * multiplier;
            sortedRest /= 10;
        }
        multiplier *= 10;
    }

    return result;
}



int countDigit(int num){
    int res = 0 ; 
    while (num > 0){
        num = num / 10;
        res++;
    }
    return res;
}



int reverse(int num) {
    static int rev = 0;
    static int base = 1;

    if (num == 0) {
        int temp = rev;
        base = 1;      
        return temp/10;
    }
    
    rev += (num % 10) ;
    rev *= 10;
    base *= 10;
    return reverse(num / 10);
}



int marge(int num1, int num2){
    if(num1 == 0) return num2;
    if(num2 == 0) return num1;

    int dig1 = num1%10;
    int dig2 = num2%10;

    if(dig1 > dig2){
        return dig1 + 10 * marge(num1 / 10 , num2);
    }
    else{
        return dig2 + 10 * marge(num1 , num2 / 10);
    }
}




void adjacentHanoi(int n, int from, int via, int to) {
    if (n == 1) {
        printf("Move disk from rod %d to rod %d\n", from, via);
        printf("Move disk from rod %d to rod %d\n", via, to);
        return;
    }
    adjacentHanoi(n - 1, from, to, via);
    printf("Move disk from rod %d to rod %d\n", from, via);
    printf("Move disk from rod %d to rod %d\n", via, to);
    adjacentHanoi(n - 1, via, from, to);
}

