package evaluation;
import java.io.*;
import java.util.*;
import java.util.HashMap;


public class Test {
	
	public static Scanner sc;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		long starti = System.currentTimeMillis();
		
		
		DFA dfa =new DFA();
		
		String[][] trans_table = dfa.read_transtable();
		HashMap<String,String> charcat = dfa.read_charcat();
		String[][] token_table = dfa.read_tokentable();
		
		String input= new String();
		sc = new Scanner(System.in);
		System.out.print("Enter an input String: ");
		
		long endi = System.currentTimeMillis();
		long elapsedTimei = endi - starti;
		
		input = sc.nextLine();
		
		String[] inputArray = input.split(" ");
		System.out.print("Enter: \n"
				+ " 1 for table driven \n "
				+ "2 for maximal munch \n "
				+ "3 for direct coded ");
		char choice=sc.next().charAt(0);
//		System.out.println(choice);
		
		if(choice=='1') {
			long start1 = System.currentTimeMillis();
			//System.out.println('$');
			for(int i = 0; i< inputArray.length; i++){

				//System.out.println(String.valueOf(buf[i])+'$');
				//System.out.println(inputArray[i]+'$');
				table_driven_scanner tds = new table_driven_scanner(trans_table, charcat, token_table, inputArray[i]+'$' );
				System.out.println(tds.next_token());
				if(i!=inputArray.length-1) {
					table_driven_scanner space = new table_driven_scanner(trans_table, charcat, token_table, String.valueOf(' ')+'$' );
					System.out.println(space.next_token());
				}
				
				}
			long end1 = System.currentTimeMillis();
			long elapsedTime1 = end1 - start1;
			
			System.out.println("Time for Table driven scanner alone: "+ elapsedTime1);
			long elapsedtotal=elapsedTime1+elapsedTimei;
			System.out.println("Time for Table driven scanner along with dfa reading: "+ elapsedtotal);
			
		}else if(choice=='2') {
			long start2 = System.currentTimeMillis();
			for(int i = 0; i< inputArray.length; i++){

				//System.out.println(String.valueOf(buf[i])+'$');
				//System.out.println(inputArray[i]+'$');
				maximal_munch_scanner mms=new maximal_munch_scanner(trans_table, charcat, token_table, inputArray[i]+'$' );
				System.out.println(mms.next_token());
				
				if(i!=inputArray.length-1) {
					maximal_munch_scanner space=new maximal_munch_scanner(trans_table, charcat, token_table, String.valueOf(' ')+'$' );
					System.out.println(space.next_token());
				}
				
				}
			long end2 = System.currentTimeMillis();
			long elapsedTime2 = end2 - start2;
			
			System.out.println("Time for maximal munch scanner alone: "+ elapsedTime2);
			long elapsedtotal=elapsedTime2+elapsedTimei;
			System.out.println("Time for maximal munch scanner along with dfa reading: "+ elapsedtotal);
		}else if(choice=='3') {
			long start3 = System.currentTimeMillis();
			for(int i = 0; i< inputArray.length; i++){
				direct_coded_scanner dcs=new direct_coded_scanner(trans_table, charcat, token_table, inputArray[i]+'$' );
				dcs.next_token();
				if(i!=inputArray.length-1) {
					direct_coded_scanner space=new direct_coded_scanner(trans_table, charcat, token_table, String.valueOf(' ')+'$');
					space.next_token();
				}
				}
			long end3 = System.currentTimeMillis();
			long elapsedTime3 = end3 - start3;
			
			System.out.println("Time for direct coded scanner alone: "+ elapsedTime3);
			long elapsedtotal=elapsedTime3+elapsedTimei;
			System.out.println("Time for direct coded scanner along with dfa reading: "+ elapsedtotal);
			
		}
		//char[] buf = input.toCharArray();
//		for(int i = 0; i< inputArray.length; i++){
//
//			//System.out.println(String.valueOf(buf[i])+'$');
//			//System.out.println(inputArray[i]+'$');
//			table_driven_scanner tds = new table_driven_scanner(trans_table, charcat, token_table, inputArray[i]+'$' );
//			System.out.println(tds.next_token());
//			table_driven_scanner space = new table_driven_scanner(trans_table, charcat, token_table, String.valueOf(' ')+'$' );
//			System.out.println(space.next_token());
//			}
		
		//table_driven_scanner tds = new table_driven_scanner(trans_table, charcat, token_table, input );
		//System.out.println(tds.next_token());
		
//		maximal_munch_scanner mms=new maximal_munch_scanner(trans_table, charcat, token_table, input );
//		System.out.println(mms.next_token());
		
		

	}

}
