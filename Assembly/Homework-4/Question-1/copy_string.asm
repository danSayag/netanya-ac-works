.model small
.stack 100h

.data
A db '     This      is     a          test     $'
B db 100 dup(0)

.code
main proc
    mov ax, @data
    mov ds, ax

    mov si, offset A
    mov di, offset B

copyLoop:
    mov al, [si]
    cmp al, '$'
    je endLoop
    mov [di], al
    inc di
    inc si
    jmp copyLoop

endLoop:

main endp
end main
