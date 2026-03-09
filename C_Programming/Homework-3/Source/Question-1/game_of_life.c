#include <stdio.h>
#include <stdlib.h>

#define ALIVE 1
#define DEAD  0

typedef int CellState;

typedef enum {
    false = 0,
    true  = 1
} bool;

int countLiveNeighbors(CellState **board, int rows, int cols, int r, int c) {
    int liveCount = 0;
    for(int i = r - 1; i <= r + 1; i++) {
        for(int j = c - 1; j <= c + 1; j++) {
            if(i >= 0 && i < rows && j >= 0 && j < cols) {
                if(!(i == r && j == c)) {
                    if(board[i][j] == ALIVE) {
                        liveCount++;
                    }
                }
            }
        }
    }
    return liveCount;
}

CellState** allocateBoard(int rows, int cols) {
    CellState **board = (CellState**)malloc(rows * sizeof(CellState*));
    if(!board) {
        fprintf(stderr, "Error: Failed to allocate memory for board.\n");
        exit(EXIT_FAILURE);
    }
    for(int i = 0; i < rows; i++) {
        board[i] = (CellState*)malloc(cols * sizeof(CellState));
        if(!board[i]) {
            fprintf(stderr, "Error: Failed to allocate memory for board row.\n");
            exit(EXIT_FAILURE);
        }
    }
    return board;
}

void freeBoard(CellState **board, int rows) {
    for(int i = 0; i < rows; i++) {
        free(board[i]);
    }
    free(board);
}

void createNextGeneration(CellState **current, CellState **next, int rows, int cols) {
    for(int r = 0; r < rows; r++) {
        for(int c = 0; c < cols; c++) {
            int neighbors = countLiveNeighbors(current, rows, cols, r, c);
            if(current[r][c] == ALIVE) {
                if(neighbors == 2 || neighbors == 3) {
                    next[r][c] = ALIVE;
                } else {
                    next[r][c] = DEAD;
                }
            } else {
                if(neighbors == 3) {
                    next[r][c] = ALIVE;
                } else {
                    next[r][c] = DEAD;
                }
            }
        }
    }
}

void printBoard(CellState **board, int rows, int cols, int generation) {
    printf("Generation %d:\n", generation);
    for(int r = 0; r < rows; r++) {
        for(int c = 0; c < cols; c++) {
            printf("%d ", board[r][c]);
        }
        printf("\n");
    }
    printf("\n");
}

int main(void) {
    int generations, rows, cols;
    if (scanf("%d %d %d", &generations, &rows, &cols) != 3) {
        fprintf(stderr, "Error: Invalid input for generations/rows/cols.\n");
        return EXIT_FAILURE;
    }
    CellState ***allBoards = (CellState***)malloc((generations + 1) * sizeof(CellState**));
    if(!allBoards) {
        fprintf(stderr, "Error: Failed to allocate memory for allBoards.\n");
        return EXIT_FAILURE;
    }
    for(int g = 0; g <= generations; g++) {
        allBoards[g] = allocateBoard(rows, cols);
    }
    for(int r = 0; r < rows; r++) {
        for(int c = 0; c < cols; c++) {
            if(scanf("%d", &allBoards[0][r][c]) != 1) {
                fprintf(stderr, "Error: Invalid board data input.\n");
                for(int g = 0; g <= generations; g++) {
                    freeBoard(allBoards[g], rows);
                }
                free(allBoards);
                return EXIT_FAILURE;
            }
        }
    }
    for(int g = 1; g <= generations; g++) {
        createNextGeneration(allBoards[g-1], allBoards[g], rows, cols);
    }
    for(int g = 0; g <= generations; g++) {
        printBoard(allBoards[g], rows, cols, g);
    }
    for(int g = 0; g <= generations; g++) {
        freeBoard(allBoards[g], rows);
    }
    free(allBoards);
    return 0;
}
