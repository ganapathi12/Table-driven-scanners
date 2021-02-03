package evaluation;

import java.util.HashMap;
import java.util.Stack;

public class table_driven_scanner {
	
	int state;
	String lexeme;
	Stack<String> stk= new Stack<>();
	String[][] trans_table,token_table;
	String input,input_copy;
	int count=0;
	HashMap<String, String> charcat;
	
	table_driven_scanner (String[][] trans_table,HashMap<String, String> charcat,String[][] token_table, String input){
		this.trans_table=trans_table;
		this.charcat=charcat;
		this.token_table=token_table;
		this.input=input;
		this.input_copy=input;
		
//		charcat_table.put(charcat[0][0],charcat[1][0]);
//		charcat_table.put(charcat[0][1],charcat[1][1]);
//		charcat_table.put(charcat[0][2],charcat[1][2]);
//		charcat_table.put(charcat[0][3],charcat[1][3]);
//		for (int i=0;i<9;i++) {
//			charcat_table.put(charcat[0][i],charcat[1][i]);
//		}
		//String test=".";
		//System.out.println(Integer.parseInt(charcat_table.get(test)));
	}
	
	public String next_token() {
		state=1;
		lexeme="";
		stk.clear();
		stk.push("bad");
		
		while(state!=0) {
			char charecter=next_char();
			//System.out.println(charecter);
			if(charecter!='$') {
				lexeme=lexeme+charecter;
				if (!(token_table[1][state].equals("NA"))){
					stk.clear();
				}
				stk.push(String.valueOf(state));
				
				int cat;
				if (charecter == 'i'){
					cat=Integer.parseInt(charcat.get(Character.toString(charecter)));
					//System.out.println(cat);
				}
				else if (charecter == 'f') {
					cat=Integer.parseInt(charcat.get(Character.toString(charecter)));
					//System.out.println(cat);
				}
				else if(charecter >= 'a' && charecter <= 'z') {
					cat=2;
				}
				else if(charecter >= '0' && charecter <= '9') {
					cat=4;
				}
				else{
					//cat=Integer.parseInt(charcat[1][charecter]);
					//cat=Integer.parseInt(charcat_table.get(Character.toString(charecter)));
					//cat=charcat_table.get(charecter);
					//System.out.println(cat);
					try {
						cat=Integer.parseInt(charcat.get(Character.toString(charecter)));
					}
					catch(Exception e) {
						cat=8;
					}
				}
				
				state=Integer.parseInt(trans_table[state+1][cat]);
			}else {
				break;
			}
			
		}
		
		while((token_table[1][state].equals("NA")) && (state!=-1) ) {
			state=Integer.parseInt(stk.pop());
			//sb.deleteCharAt(sb.length()-1);  
			lexeme=lexeme.substring(0,lexeme.length()-1);
			roll_back();	
		}
		
		if (!(token_table[1][state].equals("NA"))) {
			return token_table[1][state]+"=> "+input_copy;
		}else {
			return "INVALID";
		}
		
		
	}
	
	public char next_char() {
//		if(input.length()==0) {
//			return "/n"
//		}
//		try {
//			char charecter = input.charAt(0);
//			input=input.substring(1,input.length());
//			count=count+1;
//			//System.out.println(charecter);
//			return charecter;
//		}
//		catch(Exception e) {
//			String str = "\n";
//			char[]  test = str.toCharArray();
//			return (char)10;
//		}
		char charecter = input.charAt(0);
		input=input.substring(1,input.length());
		count=count+1;
		//System.out.println(charecter);
		return charecter;
	}
	
	public void roll_back() {
		System.out.println(count);
		input=input_copy.substring(count-1,input.length());
	}
	

}
