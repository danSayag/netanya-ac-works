sum_arrays proc
    push bp
    mov bp, sp
    mov si, [bp+4]   
    mov di, [bp+6]   
    mov dx, [bp+8]  
    mov cx, [bp+10]  
    sum_loop:
        mov ax, [si] 
        mov bx, [di]
        call sum_numbers 
        mov [dx], ax 
        add si, 2
        add di, 2
        add dx, 2
        loop sum_loop
    pop bp
    ret
sum_arrays endp
