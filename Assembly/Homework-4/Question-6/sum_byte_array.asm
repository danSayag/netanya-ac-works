.model small
.stack 100h
.data
    N equ 5
    A db -1, 2, -3, 4, -5
    Sum db 0

.code
main proc
    mov ax, @data
    mov ds, ax
    mov es, ax

    lea si, A
    mov cx, N
    mov al, 0

sum_loop_byte_byte:
    add al, [si]
    inc si
    loop sum_loop_byte_byte

    mov Sum, al

    mov ah, 4Ch
    int 21h
main endp
end main
