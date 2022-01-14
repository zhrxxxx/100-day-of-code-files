package demo;
import java.util.Scanner;
import java.util.*;
import java.util.Arrays;

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
	}
	
	public static int[] add_element(int n, int myarray[], int ele) { 
       int i; 

       int newArray[] = new int[n + 1]; 
        
       for (i = 0; i < n; i++) 
             newArray[i] = myarray[i]; 

       newArray[n] = ele; 

       return newArray; 
    } 
	
	public static void reportor(int plCard[]) { 

		for (int i : plCard) {
			
			switch (i) {
			case 1:
				System.out.print("|ACE| ");
				break;
			case 11:
				System.out.print("|JACK| ");
				break;
			case 12:
				System.out.print("|QUEEN| ");
				break;
			case 13:
				System.out.print("|KING| ");
				break;
			default:
				System.out.print("|" + i + "| ");
			}
		}
	} 
	

	public static void singlePlayer() {		
		Scanner inputValue = new Scanner(System.in);
		int spRound = 0;
		int totalScore = 0;
		
		while (spRound < 3) {
			spRound++;
			
			int[] plCard = {(int)(Math.round(Math.random() * 12 + 1)), (int)(Math.round(Math.random() * 12 + 1))};
			//int[] plCard = {1, 1}; //#test aces 
			//int[] plCard = {13, 11}; //#test face cards
			reportor(plCard);	
			
			System.out.println("\n[1]hitting\n[2]staying");
			
			int nextRound = inputValue.nextInt();
			while (nextRound !=2) {
				
				plCard = add_element(plCard.length, plCard, (int)(Math.round(Math.random() * 12 + 1)));
				reportor(plCard);
				
				System.out.println("\n[1]hitting\n[2]staying");
				nextRound = inputValue.nextInt();
				
			}
			
			int score = 0;
			int ace = 0; 
			
			for (int i = 0; i < plCard.length; i++) {
					
				switch (plCard[i]) {
				case 11:
				case 12:
				case 13:
					plCard[i] = 10;
					break;
				}
			}
			
			for (int i : plCard) {
				if (i == 1) {
					ace++;
					score = score + 11;
				}
				else {	
					score = score + i;
				}
			}
			
			while (ace > 0) {
				if(score > 21) {
					ace--;
					score = score - 10;
				}
				else {
					ace--;
				}
			}
			
			
			System.out.println(score);
			if (score == 21) {
				System.out.println("Blackjack");
				totalScore = totalScore + score;
			}
			else if (score > 21) {
				System.out.println("Bust");
			}
			else {
				totalScore = totalScore + score;
			}
			
		}
		
		System.out.println("================\nYour total Score: " + totalScore + "\n================");
		if (totalScore >= 51 && totalScore < 60) {
			System.out.println("Nice");
		}
		else if (totalScore >= 60 && totalScore < 63){
			System.out.println("Good job");
		}
		else if (totalScore == 63) {
			System.out.println("Did you cheat？┌(。Д。)┐");
		}
		else if (totalScore == 0) {
			System.out.println("(っ °Д °;)っ");
		}

		
	}

}
