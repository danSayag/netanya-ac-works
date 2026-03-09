.model small
.stack 100h

.data
A db '     This      is     a          test     $'
B db 100 dup('$')
res db 0
check db ' '

.code
main proc
    mov ax, @data
    mov ds, ax

    mov si, offset A
    mov cx, 0            

forLoop:
    mov al, [si]         
    cmp al, '$'     
    je endLoop           
    cmp al, check        
    jne ifStat             
    inc cx               

ifStat:
    inc si               
    jmp forLoop          

endLoop:

main endp
.exit
end main
