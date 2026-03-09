.model small
.stack 100h
.data
A dw 12, 5, 8, -1, 4
B dw -2, 9, 0, 18, 3
C dw 5 dup (?)
.code
main:
    mov ax, @data
    mov ds, ax
    mov es, ax
    lea si, A
    lea di, B
    lea dx, C
    mov cx, 5
    push cx
    push dx
    push di
    push si
    call sum_arrays
    lea si, A
    mov cx, 5
    call print_array
    lea si, B
    mov cx, 5
    call print_array
    lea si, C
    mov cx, 5
    call print_array
    .exit
end main
print_array proc
    push bp
    mov bp, sp
    mov si, [bp+4]
    mov cx, [bp+6]
print_loop:
    mov ax, [si]
    push ax
    call print_number
    add si, 2
    loop print_loop
    pop bp
    ret
print_array endp
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
