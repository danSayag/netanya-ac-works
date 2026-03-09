#include <stdio.h>
#include <string.h>


void printAllStrings(char ***arr){
    printf("{");
    for(int i = 0 ; *(arr+i) != NULL ; i++ ){
        printf("[");
        for(int j = 0 ; *(*(arr+i)+j) != NULL ; j++){
            printf("%s",*(*(arr+i)+j));
            if(*(*(arr+i)+j+1) != NULL)
                printf(",");
            if(*(*(arr+i)+j+1) == NULL)
                printf("]");
        }
        if(*(arr+i+1) != NULL){
            printf(" | ");
        }
        if(*(arr+i+1) == NULL){
            printf("}");
        }
    }
    printf("\n");
}


char* maxLengthString(char *** arr){
    char *res = NULL;
    for(int i = 0 ; *(arr+i) != NULL ; i++ ){
        for(int j = 0 ; *(*(arr+i)+j) != NULL ; j++){
            if(res == NULL || strlen(*(*(arr+i)+j)) > strlen(res))
            res = *(*(arr+i)+j);
        }
    }
    return res;
}




int countString(char ***arr) {
    int count = 0;
    for(int i = 0 ; *(arr+i) != NULL ; i++){
        for(int j = 0 ; *(*(arr+i)+j) != NULL ; j++){
            count++;
        }
    }
    return count;
}




void sort(char ***arr) {
    int size = countString(arr);
    char *temp[size];
    int count = 0 ;

    for (int i = 0; arr[i] != NULL ; i++) {
        for (int j = 0; arr[i][j] != NULL; j++) {
            temp[count++] = arr[i][j];
        }
    }
    count = 0;

    for(int i = 0 ; i < size - 1; i++ ){
        for(int j = 0 ; j < size - i - 1  ; j++ ){
            if(strcmp(temp[j],temp[j+1]) > 0){
                char *swap = temp[j];
                temp[j] = temp[j+1];
                temp[j+1] = swap;
            }
        }
    }


    for (int i = 0; *(arr+i) != NULL ; i++) {
        for (int j = 0; *(*(arr+i)+j) != NULL; j++) {
         arr[i][j] = temp[count++];
        }
    }
    
    
}




int main(){
char * arrP1 [ ] = { "father", "mother", NULL};
char * arrP2 [ ] = { "sister", "brother", "grandfather", NULL };
char * arrP3 [ ] = { "grandmother", NULL};
char * arrP4 [ ] = { "uncle", "aunt", NULL };
char ** arrPP [ ] = { arrP1, arrP2, arrP3, arrP4 , NULL};
puts("original string array:");
printAllStrings(arrPP);
printf("%d\n",countString(arrPP));
sort (arrPP);
printAllStrings(arrPP);
printf("%s\n", maxLengthString(arrPP));
return 0;


}