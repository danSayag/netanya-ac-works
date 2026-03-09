.model small
.stack 100h
.data
A dw 1489, 32661, 31248, 24788, 13499, 28
N dw 6
.code
main:
    mov ax, @data
    mov ds, ax
    mov es, ax
    lea si, A
    mov cx, N
    push cx
    push si
    call find_max_even_sum
    push ax
    call print_number
    .exit
end main
print_number proc
    pop ax
    mov bx, 10
    mov cx, 0
    cmp ax, 0 
    jge next
    neg ax
next:	
    mov dx, 0
    div bx
    add dx, 30h
    push dx
    inc cx
    cmp ax, 0
    jne next
    cmp num, 0
    jge sof
    push '-'
    inc cx
sof:
    cmp cx, 0
    jz ext
    pop dx
    mov ah, 2
    int 21h
    dec cx
    jmp sof
ext:
    ret
print_number endp
ten dw 10
