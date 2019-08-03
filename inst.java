package nsuProject;

import java.util.Scanner;
import java.util.function.Function;

public class inst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter your MIPS instruction");
		Scanner input = new Scanner(System.in);
		String inst = input.nextLine();
		
		//check lowercase 
		if(inst.equals(inst.toLowerCase())){
			split_input_function(inst);
			
		}else {
			System.out.print("invalid input");
		}
		
		
	}


	
	protected static void split_input_function(String input) {
		String remove_comma = input.replaceAll("[,]", "");
		String[] split_input = remove_comma.split("\\s");
		// System.out.print(split_input[1]);
		instructions(split_input[0], split_input);
	}
	
	protected static void instructions(String op, String[] data) {
	
		if(op.equals("and")) {
			//opcode
			rType(data[1], data[2], data[3], "00000", "100100");
			
		}else if(op.equals("sub")){
			rType(data[1], data[2], data[3], "00000", "100010");
			
		}else if(op.equals("addi")){
			iType("001000", data[1], data[2], data[3]);
		}else if(op.equals("slti")){
			iType("001010", data[1], data[2], data[3]);
		}else if(op.equals("lw")){
			// remove ( ) with space
			String data_replace = data[2].replaceAll("[(|)]", " ");
			String[] data_split = data_replace.split(" ");

			iType("100011", data_split[1], data[1], data_split[0]);
		}else if(op.equals("beq")){
			iTypeLabel("000100", data[1], data[2], data[3]);
		}else if(op.equals("bne")){
			iTypeLabel("000101", data[1], data[2], data[3]);
		}else if(op.equals("j")){
			jType("000010", data[1]);
		}else {
			System.out.print("Invalid Instruction.");
		}
		
	}
	
	protected static void rType(String rd, String rs, String rt, String sa, String fn) {
		//op code
		System.out.printf("000000 %05d %05d %05d %s %s",  registerNumber(rs),  registerNumber(rt),  registerNumber(rd), sa, fn);
		
	}
	
	protected static void jType(String opc, String label) {
		//op code
		System.out.printf("%s %s", opc, label);
		
		
	}
	
	protected static void iType(String opc, String rs, String rt, String data) {
		//op code
		System.out.printf("%s %05d %05d %s", opc, registerNumber(rs), registerNumber(rt), Integer.toBinaryString(Integer.parseInt(data)));
		
		
		
		
		
	}

	protected static void iTypeLabel(String opc, String rs, String rt, String data) {
		//op code
		System.out.printf("%s %05d %05d %s", opc, registerNumber(rs), registerNumber(rt), data);
	}
	
	 protected static int registerNumber(String r) {
		 int val = 0;
		 char rtype = r.charAt(1);
		 int value = Character.getNumericValue(r.charAt(2));
		 if(r.equals("$zero")) {
			 return 00000;
		 }else if(r.equals("$at")) {
			 return 00001;
			 
		 }else if(r.equals("$gp")) {
			 return Integer.parseInt(Integer.toBinaryString(28));
			 
		 }else if(r.equals("$sp")) {
			 return Integer.parseInt(Integer.toBinaryString(29));
			 
		 }else if(r.equals("$fp")) {
			 return Integer.parseInt(Integer.toBinaryString(30));
			 
		 }else if(r.equals("$ra")) {
			 return Integer.parseInt(Integer.toBinaryString(31));
			 
		 }else if(rtype == 'v') {
			  val = 2+value;
			  return Integer.parseInt(Integer.toBinaryString(val));
			
		 }else if(rtype == 'a') {
			 val = 4+value;
			  return Integer.parseInt(Integer.toBinaryString(val));		 
		 }else if(rtype == 't') {
			 if(value>=0 && value<=7 ) {
				  val = 8+value;
				  return Integer.parseInt(Integer.toBinaryString(val));
			 }else if(value == 8){
				  return Integer.parseInt(Integer.toBinaryString(24));
				  }else {
					  return Integer.parseInt(Integer.toBinaryString(25));
				  }
		 	
		 }else if(rtype == 's') {
			 val = 16+value;
			// System.out.println(Integer.toBinaryString(val));
			  return Integer.parseInt(Integer.toBinaryString(val));
		 }
		 

		 return 0;
		
	}

}
