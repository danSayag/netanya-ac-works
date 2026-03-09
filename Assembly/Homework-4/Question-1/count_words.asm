model small
.stack 100h

.data
A db '     This      is     a          test     $'
B db 100 dup('$')
check db ' '

.code
main proc 
    mov ax, @data
    mov ds, ax

    mov si, offset A
    mov cx, 0  
    mov bx, 0 
    mov dx, 1      
    
    
    forLoop:
        mov al, [si]
        cmp al, '$'
        je endLoop
        cmp al, check
        jne ifStat
        inc si
        mov bx, 0
        jmp forLoop

    ifStat:
        inc si
        cmp bx, dx
        jge forLoop
        inc bx
        inc cx 
        jmp forLoop


endLoop:
main endp
end main