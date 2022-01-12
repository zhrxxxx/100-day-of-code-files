package demo;
import java.util.Scanner;
import java.util.*;

public class test5_game3 {

	public static void main(String[] args) {
		Scanner inputValue = new Scanner(System.in);
		int count = 1;
		
		System.out.println("=============Blackjack=============\n\t[1]single player\n\t[2]???");
		int level = inputValue.nextInt();
		
		if (level == 1) {
			while (level == 1) {
			singlePlayer();
			}
		}		

	}public static int[] add_element(int n, int myarray[], int ele) { 
        int i; 

        int newArray[] = new int[n + 1]; 
       //copy original array into new array
       for (i = 0; i < n; i++) 
             newArray[i] = myarray[i]; 

       //add element to the new array
       newArray[n] = ele; 

       return newArray; 
   } 
	
	public static void singlePlayer() {		
		Scanner inputValue = new Scanner(System.in);
		
		int[] plCard = {(int)(Math.round(Math.random() * 12 + 1)), (int)(Math.round(Math.random() * 13 + 1))};
		//System.out.println("\n\n\n\n__________\n\n["+plCard[0]+"] ["+plCard[1]+"]\n");
		for (int i : plCard) {System.out.print("|" + i + "| ");}
		System.out.println("\n[1]hitting\n[2]staying");
		
		int nextRound = inputValue.nextInt();
		while (nextRound !=2) {
			
			plCard = add_element(plCard.length, plCard, (int)(Math.round(Math.random() * 12 + 1)));
			for (int i : plCard) {System.out.print("|" + i + "| ");}
			
			System.out.println("\n[1]hitting\n[2]staying");
			nextRound = inputValue.nextInt();
			
		}
		
		int score = 0;
		for (int i : plCard) {
			score = score + i;
		}
		
		System.out.println(score);
		if (score == 21) {
			System.out.println("Blackjack");
		}
		if (score > 21) {
			System.out.println("Bust");
		}
		
		
		
		
		
	}
	

}
