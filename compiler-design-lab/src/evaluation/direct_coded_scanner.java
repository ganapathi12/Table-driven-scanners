package evaluation;

import java.util.HashMap;
import java.util.Stack;

public class direct_coded_scanner {
	int state;
	String lexeme;
	Stack<String> stk= new Stack<>();
	String[][] trans_table,token_table;
	String input,input_copy;
	int count=0;
	HashMap<String, String> charcat;
	char charecter;
	
	direct_coded_scanner (String[][] trans_table,HashMap<String, String> charcat,String[][] token_table, String input){
		this.trans_table=trans_table;
		this.charcat=charcat;
		this.token_table=token_table;
		this.input=input;
		this.input_copy=input;
		
	}
	
	public void next_token() {
		state=1;
		lexeme="";
		stk.clear();
		stk.push("bad");
		s1();
		
//		s1:{
//			charecter=next_char();
//			lexeme=lexeme+charecter;
//			if (!(token_table[1][state].equals("NA"))){
//				stk.clear();
//			}
//			stk.push(String.valueOf(state));
//			if(charecter=='i') {
//				goto s1;
//			}
//		}
//		
//		s2:
//			charecter=next_char();
//			lexeme=lexeme+charecter;
//			if (!(token_table[1][state].equals("NA"))){
//				stk.clear();
//			}
//			stk.push(String.valueOf(state));
			
	}
	public void  s1() {
		charecter=next_char();
		lexeme=lexeme+charecter;
		state=1;
		if (!(token_table[1][state].equals("NA"))){
			stk.clear();
		}
		stk.push(String.valueOf(state));
		if(charecter=='i') {
			 s2();
		}
		else if(charecter >= 'a' && charecter <= 'h') {
			 s4();
		}
		else if(charecter >= 'j' && charecter <= 'z') {
			 s4();
		}
		else if(charecter =='.') {
			 s5();
		}
		else if(charecter >= '0' && charecter <= '9') {
			 s7();
		}
		else if(charecter =='-') {
			 s9();
		}
		else if(charecter ==' ') {
			 s12();
		}else {
			s13();
		}
	}
	public void  s2() {
		charecter=next_char();
		lexeme=lexeme+charecter;
		state=2;
		if (!(token_table[1][state].equals("NA"))){
			stk.clear();
		}
		stk.push(String.valueOf(state));
		if(charecter=='f') {
			 s3();
		}
		else if((charecter >= 'a' && charecter <= 'e')||(charecter >= 'g' && charecter <= 'z')||(charecter >= '0' && charecter <= '9')) {
			 s4();
		}else {
			sout();
		}
	}
	public void  s3() {
		charecter=next_char();
		lexeme=lexeme+charecter;
		state=3;
		if (!(token_table[1][state].equals("NA"))){
			stk.clear();
		}
		stk.push(String.valueOf(state));
		if((charecter >= '0' && charecter <= '9')||(charecter >= 'a' && charecter <= 'z')) {
			 s4();
		}
		else {
			sout();
		}
	}
	public void  s4() {
		charecter=next_char();
		lexeme=lexeme+charecter;
		state=4;
		if (!(token_table[1][state].equals("NA"))){
			stk.clear();
		}
		stk.push(String.valueOf(state));
		if((charecter >= '0' && charecter <= '9')||(charecter >= 'a' && charecter <= 'z')) {
			 s4();
		}
		else {
			sout();
		}
	}
	public void  s5() {
		charecter=next_char();
		lexeme=lexeme+charecter;
		state=5;
		if (!(token_table[1][state].equals("NA"))){
			stk.clear();
		}
		stk.push(String.valueOf(state));
		if(charecter >= '0' && charecter <= '9') {
			 s6();
		}
		else {
			sout();
		}
	}
	public void  s6() {
		charecter=next_char();
		lexeme=lexeme+charecter;
		state=6;
		if (!(token_table[1][state].equals("NA"))){
			stk.clear();
		}
		stk.push(String.valueOf(state));
		if(charecter >= '0' && charecter <= '9') {
			 s6();
		}
		else {
			sout();
		}
	}
	public void  s7() {
		charecter=next_char();
		lexeme=lexeme+charecter;
		state=7;
		if (!(token_table[1][state].equals("NA"))){
			stk.clear();
		}
		stk.push(String.valueOf(state));
		if(charecter >= '0' && charecter <= '9') {
			 s7();
		}
		else if(charecter == '.') {
			 s8();
		}
		else {
			sout();
		}
	}
	public void  s8() {
		charecter=next_char();
		lexeme=lexeme+charecter;
		state=8;
		if (!(token_table[1][state].equals("NA"))){
			stk.clear();
		}
		stk.push(String.valueOf(state));
		if(charecter >= '0' && charecter <= '9') {
			 s8();
		}
		else {
			sout();
		}
	}
	public void  s9() {
		charecter=next_char();
		lexeme=lexeme+charecter;
		state=9;
		if (!(token_table[1][state].equals("NA"))){
			stk.clear();
		}
		stk.push(String.valueOf(state));
		if(charecter == '-') {
			 s10();
		}
		else {
			sout();
		}
	}
	public void  s10() {
		charecter=next_char();
		lexeme=lexeme+charecter;
		state=10;
		if (!(token_table[1][state].equals("NA"))){
			stk.clear();
		}
		stk.push(String.valueOf(state));
		if(charecter >= 'a' && charecter <= 'z') {
			 s10();
		}
		else if(charecter == '\n') {
			 s11();
		}
		else {
			sout();
		}
	}
	public void  s11() {
		charecter=next_char();
		lexeme=lexeme+charecter;
		state=11;
		if (!(token_table[1][state].equals("NA"))){
			stk.clear();
		}
		stk.push(String.valueOf(state));
		sout();
	}
	public void  s12() {
		charecter=next_char();
		lexeme=lexeme+charecter;
		state=12;
		if (!(token_table[1][state].equals("NA"))){
			stk.clear();
		}
		stk.push(String.valueOf(state));
		if(charecter==' ') {
			 s12();
		}else {
			sout();
		}
	}
	public void  s13() {
		charecter=next_char();
		lexeme=lexeme+charecter;
		state=13;
		if (!(token_table[1][state].equals("NA"))){
			stk.clear();
		}
		stk.push(String.valueOf(state));
		sout();
	}
	public void sout() {
		while((token_table[1][state].equals("NA")) && (state!=-1) ) {
			state=Integer.parseInt(stk.pop());
			//sb.deleteCharAt(sb.length()-1);  
			lexeme=lexeme.substring(0,lexeme.length()-1);
			roll_back();	
		}
		if (!(token_table[1][state].equals("NA"))) {
			System.out.println (token_table[1][state]+"=> "+input_copy);
		}else {
			System.out.println( "INVALID");
		}
	}
	
	public char next_char() {
		if(charecter!='$') {
		char charecter = input.charAt(0);
		input=input.substring(1,input.length());
		count=count+1;
		return charecter;
		}else {
			return '$';
		}
	}
	
	public void roll_back() {
		System.out.println(count);
		input=input_copy.substring(count-1,input.length());
	}
}
