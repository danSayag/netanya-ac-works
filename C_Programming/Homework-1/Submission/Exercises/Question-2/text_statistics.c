#include <stdio.h>

int inWord(int in_word, char c) {
    if (c == ' ' || c == '\t' ) 
        return 1;
    return 0; 
}



int isWhiteSpace(char c){
    return c == ' ' || c == '\t' ;
}



int isLetter(char c) {
    return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
}



int isNum(char c){
    return c >= '0' && c <= '9';
}



int main(){
    char c;
    int totalChar = 0 , totalWords = 0 , totalLines = 1 ,totalLetters = 0 ,totalNums = 0 , totalWhitespace = 0;
    int in_Word = 0;
    printf("enter text (to end press CTRL+D): \n");

    while((c = getchar()) != EOF){
        totalChar++;

        if(c == '\n'){
            totalLines++;
        }
        if(isWhiteSpace(c)){
            totalWhitespace++;
            if(in_Word){
                totalWords++;
            }
        }
        in_Word = inWord(in_Word, c);

        if(isLetter(c)){
            totalLetters++;
        }
        if(isNum(c)){
            totalNums++;
        }
    }

    printf("\nResults:\n");
    printf("Total chars: %d\n", totalChar);
    printf("Total words: %d\n", totalWords);
    printf("Total lines: %d\n", totalLines);
    printf("Total letters: %d\n", totalLetters);
    printf("Total digits: %d\n", totalNums);
    printf("Total whitespace: %d\n", totalWhitespace);

    return 0;
}