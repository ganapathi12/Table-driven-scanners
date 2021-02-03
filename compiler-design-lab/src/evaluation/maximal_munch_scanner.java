package evaluation;

import java.util.HashMap;
import java.util.Stack;

public class maximal_munch_scanner {
	int state;
	String lexeme;
	Stack<String> stk= new Stack<>();
	String[][] trans_table,token_table;
	String input,input_copy;
	int count=0;
	HashMap<String, String> charcat = new HashMap<String, String>();
	
	maximal_munch_scanner(String[][] trans_table,HashMap<String, String> charcat,String[][] token_table, String input){
		this.trans_table=trans_table;
		this.charcat=charcat;
		this.token_table=token_table;
		this.input=input;
		this.input_copy=input;
	}
	
	int Current_state;
	int Last_final_state=0;
	int Current_Input_position=0;
	int Last_final_input_position=0;
	int Begin_token_position=0;
	
	public String next_token() {
		Current_state=1;
		int y;
		while(Current_state!=0 ) {
			char x = next_char();
			if(x!='$') {
			//int y = Integer.parseInt(charcat.get(Character.toString(x)));
			
			if (x == 'i'){
				y=Integer.parseInt(charcat.get(Character.toString(x)));
			}
			else if (x == 'f') {
				y=Integer.parseInt(charcat.get(Character.toString(x)));
			}
			else if(x >= 'a' && x <= 'z') {
				y=2;
			}
			else if(x >= '0' && x <= '9') {
				y=4;
			}
			else{
				try {
					y=Integer.parseInt(charcat.get(Character.toString(x)));
				}
				catch(Exception e) {
					y=8;
				}
			}
			
			Current_state=Integer.parseInt(trans_table[Current_state+1][y]);
			if(!(token_table[1][Current_state].equals("NA"))) {
				Last_final_input_position++;
				Last_final_state = Current_state;
			}
		}else {
			break;
		}
		}
		
		if (!(token_table[1][Current_state].equals("NA"))) {
			return token_table[1][Current_state]+"=> "+input_copy;
		}else {
			return "INVALID";
		}
		
	}
	
	public char next_char() {
		char charecter = input.charAt(0);
		input=input.substring(1,input.length());
		count=count+1;
		return charecter;
	}
	
	public void roll_back() {
		System.out.println(count);
		Current_state=0;
		
		input=input_copy.substring(count-1,input.length());
	}

}
