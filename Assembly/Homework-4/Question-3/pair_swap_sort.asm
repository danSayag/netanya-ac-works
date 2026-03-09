    .model small
.stack 100h
.data
    N equ 10 
    A db -5, 10, -3, 22, -15, 7, 9, -1, 6, 0  

.code
main proc
    mov ax, @data
    mov ds, ax
    mov es, ax

    lea si, A
    mov cx, N - 1

find_max:
    mov di, si
    add di, cx
    mov al, [si]
    mov bl, [di]
    cmp al, bl
    jle no_swap
    xchg al, bl
    mov [si], al
    mov [di], bl
no_swap:
    inc si
    loop find_max

    lea si, A
    mov cx, N
print_array:
    mov al, [si]
    call print_char
    inc si
    loop print_array

    mov ah, 4Ch
    int 21h
main endp

print_char proc
    mov ah, 0Eh
    int 10h
    ret
print_char endp
end main

    