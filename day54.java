package demo;
import java.util.Scanner;

public class nth_term_calculator2 {

	public static void main(String[] args) {
		Scanner inputValue = new Scanner(System.in);
		
		System.out.println("Input n!: ");
		int n = inputValue.nextInt();
		
		while (n != 0) {
			
			int nExc = 1;
			int function = 0;
			
			for (int i=1; i<n; i++) {
				
				nExc = nExc * (i+1);
				System.out.print(i + " * ");

				
			}
			
			System.out.println(n + " = " + nExc);
			n = inputValue.nextInt();
			
		}
		
	}
}
