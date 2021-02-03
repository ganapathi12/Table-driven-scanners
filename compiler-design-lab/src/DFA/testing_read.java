package DFA;
import java.io.*;
import java.util.Scanner;

public class testing_read {
	
	public static Scanner sc;

	public static void main(String[] args)throws IOException  {
		// TODO Auto-generated method stub
		
		Read csv = new Read();
		
		String[][] transition_table = new String[15][9];
		transition_table = csv.readcsv();
		
//		for (int i = 0; i < 15; i++) {
//			  for (int j = 0; j < 11; j++) {
//				  transition_table[i][j] = transition_table[i][j];
//			  }
//			}
//		System.out.print("Enter an input character to get a column : ");
//		sc = new Scanner(System.in);
//		String check = sc.next();
		
//		for(int i=0;i<15;i++) {
//			for(int j=0;j<11;j++) {
//				System.out.print(transition_table[i][j]+" ");
//			}
//			System.out.println("\n");
//		}
		
		Scanner input = new Scanner(System.in);
	    String[] Tokentype = {"dead","start","ID","IF","ID","error","REAL","NUM","REAL",
	"error"," ","white space","white space","error"};
	    System.out.println("Enter the string:");
	    String str = input.nextLine();
	    int n = str.length();
		int cur = 1;
		
		System.out.println("States : ");
	    System.out.print(cur + " => ");
	    
	    for (int i=0;i<n;i++) {
		      char ch = str.charAt(i);
		      cur = Integer.parseInt(transition_table[cur+1][Charcat(ch)]);
		      if (cur == 0) {
		        System.out.println("Dead state reached");
		        break;
		      } else {
		        if (i == n - 1)
		          System.out.println("("+cur+")");
		        else
		          System.out.print(cur + " => ");
		      }
		    }
		
	    if (cur>1){
		      System.out.println("String accepted");
		      System.out.println("String type : "+Tokentype[cur]);
		    }
		    else
		      System.out.println("String rejected");
	    
	    input.close();

	}
	
	static int Charcat(char ch) {
	    if (ch == 'i')
	      return 0;
	    if (ch == 'f')
	      return 1;
	    if (ch >= 'a' && ch <= 'z')
	      return 2;
	    if (ch == '.')
	      return 3;
	    if (ch >= '0' && ch <= '9')
	      return 4;
	    if (ch == '-')
	      return 5;
	    if (ch == '\n')
	      return 6;
	    if (ch == ' ')
	      return 7;
	    else
	      return 8;
	  }
	
}
