assume cs:code 

a segment
	dw 1,2,3,4,5,6,7,8,9,0ah,0bh,0ch,0dh,0eh,0fh,0ffh
a ends

b segment
	dw 0,0,0,0,0,0,0,0
b ends



code segment 
	
start:	
		mov ax,a
		mov ds,ax ;设置ds
		
		mov ax,b
		mov ss,ax ;设置ss
		
		mov sp, 10h
		
		mov cx,8
		mov bx,0
		
	s:	push ds:[bx]
		add bx, 2
		loop s
		
		mov ax, 4c00h
		int 21h

code ends
end start