.model small
.stack 100h
.data
    N equ 5
    A dw -1, 2, -3, 4, -5
    Sum dw 0

.code
main proc
    mov ax, @data
    mov ds, ax
    mov es, ax

    lea si, A
    mov cx, N
    xor ax, ax

sum_loop_word_word:
    add ax, [si]
    add si, 2
    loop sum_loop_word_word

    mov Sum, ax

    mov ah, 4Ch
    int 21h
main endp
end main
