# mips-instruction-to-binary-conversion-java

Java Program (no other language will be accepted) that takes a MIPS assembly
instruction as input and produces the corresponding binary instruction as output. The input assembly
instruction will be given exactly in the format assembly instructions are written in David Patterson and
John Hennessy’s reference book for the class. For example: add $s0, $t7, $s1 is a valid input. Every input
will be in lower case letters. So ADD $s0, $t7, $s1 is an invalid input.

this program should accept only those MIPS assembly instructions - 
(Rtype) - sub, add, addi, slti
(memory access instruction ) - lw
(jump and branch) - bne, beq, j

For any other instruction as input, program should output
Invalid Instruction.

When giving the binary output, you should have a whitespace between the fields of the instruction so
that it is easier to read what the instruction represent. For example, for:

> Input: and $s4, $s2, $t8 Output: 000000 10010 11000 10100 00000 100100 </br>
> Input: lw $t0, 1200($t1) Output: 100011 01001 01000 0000010010110000
