package DFA;
import java.io.*;

public class Read {
	
public String[][] readcsv() throws IOException {
		
		String[][] transition_table = new String[20][20];
		int i=0,j=0;
		
		FileReader file = new FileReader("src\\DFA\\transitions.csv");
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
					transition_table[i][j] = s_arr[k];
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
		
		return transition_table; 
		
	}

}
