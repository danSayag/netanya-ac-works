sum_even_digits proc
    push bp
    mov bp, sp
    pop ax
    xor bx, bx 
    sum_loop:
        xor dx, dx
        div word ptr [ten]
        cmp dl, 0
        jne check_even_digit
        jmp continue_sum_loop
    check_even_digit:
        mov cx, 2
        div cx
        cmp dx, 0
        jne continue_sum_loop
        add bx, dl
    continue_sum_loop:
        cmp ax, 0
        jne sum_loop
    mov al, bl
    pop bp
    ret
sum_even_digits endp
ten dw 10
