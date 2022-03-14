package demo;
import java.util.Scanner;

public class nth_term_calculator {

	public static void main(String[] args) {
		Scanner inputValue = new Scanner(System.in);
		int n = inputValue.nextInt();
		
		while (n != 0) {
			
			int nExc = 1;
			int function = 0;
			
			for (int i=1; i<n; i++) {
				
				nExc = nExc * (i+1);
				function = 
						nExc - (int) Math.pow(2, n);
				
			}
			
			System.out.println(function);
			n = inputValue.nextInt();
			
		}
		
	}
}
