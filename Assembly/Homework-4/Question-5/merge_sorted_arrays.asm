.model small
.stack 100h
.data
    N1 equ 5  
    N2 equ 5 
    A db -10, -5, 0, 5, 10  
    B db -8, -3, 2, 7, 12   
    C db N1 + N2 dup(?)     

.code
main proc
    mov ax, @data
    mov ds, ax
    mov es, ax

    lea si, A
    lea di, B
    lea bx, C

    mov cx, N1
    mov dx, N2

merge_arrays:
    cmp cx, 0
    je copy_remaining_b
    cmp dx, 0
    je copy_remaining_a

    mov al, [si]
    mov bl, [di]

    cmp al, bl
    jle move_from_a
    mov [bx], bl
    inc di
    dec dx
    jmp next_element

move_from_a:
    mov [bx], al
    inc si
    dec cx

next_element:
    inc bx
    jmp merge_arrays

copy_remaining_a:
    cmp cx, 0
    je done
    mov al, [si]
    mov [bx], al
    inc si
    inc bx
    dec cx
    jmp copy_remaining_a

copy_remaining_b:
    cmp dx, 0
    je done
    mov bl, [di]
    mov [bx], bl
    inc di
    inc bx
    dec dx
    jmp copy_remaining_b

done:
    lea si, A
    mov cx, N1
    call print_array

    lea si, B
    mov cx, N2
    call print_array

    lea si, C
    mov cx, N1 + N2
    call print_array

    mov ah, 4Ch
    int 21h
main endp

print_array proc
    mov bx, cx
print_loop:
    mov al, [si]
    call print_char
    inc si
    dec bx
    jnz print_loop

    mov al, 0Dh
    call print_char
    mov al, 0Ah
    call print_char
    ret
print_array endp

print_char proc
    mov ah, 0Eh
    int 10h
    ret
print_char endp

end main
