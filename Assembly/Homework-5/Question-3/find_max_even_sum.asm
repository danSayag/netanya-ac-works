find_max_even_sum proc
    push bp
    mov bp, sp
    mov si, [bp+4]  
    mov cx, [bp+6]  
    xor bx, bx      
    xor dx, dx      
    find_loop:
        mov ax, [si]
        push ax
        call sum_even_digits
        cmp al, bl
        jle check_equal_sum
        mov bl, al
        mov dx, ax
        jmp continue_find_loop
    check_equal_sum:
        cmp al, bl
        jne continue_find_loop
        cmp ax, dx
        jle continue_find_loop
        mov dx, ax
    continue_find_loop:
        add si, 2
        loop find_loop
    mov ax, dx
    pop bp
    ret
find_max_even_sum endp
