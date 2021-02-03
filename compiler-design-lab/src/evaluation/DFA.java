package evaluation;
import java.io.*;
import java.util.HashMap;

public class DFA {
	
	String trans_table[][];
	String charcat[][];
	String token_table[][];
	

	public String[][] read_transtable() throws IOException {
		trans_table = new String[20][20];
		int i=0,j=0;
		
		FileReader file = new FileReader("src\\evaluation\\transitions.csv");
		BufferedReader bfr = new BufferedReader(file);
		String line;
		
		try{
			while((line=bfr.readLine())!=null) {
				String[] a = line.split(",");
				String[] s_arr = new String[11];
				
				for(int m=0;m<9;m++) {
					s_arr[m] = a[m]; 
				}
				int k = 0;
				j = 0;
				while(j<11) {
					trans_table[i][j] = s_arr[k];
					j++;
					k++;
				}
				i++;
			}
		}
		
		catch(Exception e) {
			   e.printStackTrace();
			  }
		
		finally {
				   try {
					   bfr.close();
				   } catch (IOException e) {
				    // TODO Auto-generated catch block
				    e.printStackTrace();
				   }
			  }
		
		return trans_table; 
	}
	
	public HashMap<String, String> read_charcat() throws IOException {
		charcat = new String[2][9];
		charcat[0][8]="";
		charcat[1][8]="8";
		HashMap<String, String> charcat_table = new HashMap<String, String>();
		
		int i=0,j=0;
		
		FileReader file = new FileReader("src\\evaluation\\charcat.csv");
		BufferedReader bfr = new BufferedReader(file);
		String line;
		
		try{
			while((line=bfr.readLine())!=null) {
				String[] a = line.split(",");
				String[] s_arr = new String[8];
				
				for(int m=0;m<8;m++) {
					s_arr[m] = a[m]; 
				}
				int k = 0;
				j = 0;
				while(j<8) {
					charcat[i][j] = s_arr[k];
					//System.out.println(charcat[i][j]);
					j++;
					k++;
				}
				i++;
			}
		}
		
		catch(Exception e) {
			   e.printStackTrace();
			  }
		
		finally {
				   try {
					   bfr.close();
					   for (i=0;i<9;i++) {
							charcat_table.put(charcat[0][i],charcat[1][i]);
						}
				   } catch (IOException e) {
				    // TODO Auto-generated catch block
				    e.printStackTrace();
				   }
			  }
		
		return charcat_table; 
	}
	
	public String[][] read_tokentable() throws IOException {
		token_table = new String[2][14];
		
		int i=0,j=0;
		
		FileReader file = new FileReader("src\\evaluation\\tokentype.csv");
		BufferedReader bfr = new BufferedReader(file);
		String line;
		
		try{
			while((line=bfr.readLine())!=null) {
				String[] a = line.split(",");
				String[] s_arr = new String[14];
				
				for(int m=0;m<14;m++) {
					s_arr[m] = a[m]; 
				}
				int k = 0;
				j = 0;
				while(j<14) {
					token_table[i][j] = s_arr[k];
					j++;
					k++;
				}
				i++;
			}
		}
		
		catch(Exception e) {
			   e.printStackTrace();
			  }
		
		finally {
			   try {
				   bfr.close();
			   } catch (IOException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			   }
		  }
		
		return token_table; 
	}
	
//	public static void main(String[] args)throws IOException  {
////		String[][] charcat2=read_charcat();
//		String[][] charcat2=read_tokentable();
//		
//		for(int i=0;i<2;i++) {
//		for(int j=0;j<14;j++) {
//			System.out.print(charcat2[i][j]+" ");
//		}
//		System.out.println("\n");
//	}
//	}

}
