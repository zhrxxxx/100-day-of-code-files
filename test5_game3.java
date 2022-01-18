package demo;
import java.util.Scanner;
import java.util.*;
import java.util.Arrays;

public class test5_game3 {

	public static void main(String[] args) {
		Scanner inputValue = new Scanner(System.in);
		int count = 1;
		

		int quit = 0;
		
		while (quit == 0) {
			System.out.println("=============Blackjack=============\n\t[1]single player\n\t[2]auto mode\n\t[3]???");
			int level = inputValue.nextInt();
			
			switch (level) {
			case 1:
				singlePlayer();
				break;
			case 2:
				autoMode();
				break;	
				
			}
			System.out.print("\n");
			
		}	
	}
	
	public static int[] generateCard() {;
		
		int[] cardHand = {(int)(Math.round(Math.random() * 12 + 1)), (int)(Math.round(Math.random() * 12 + 1))};
		//int[] plCard = {1, 1}; //#test aces 
		//int[] plCard = {13, 11}; //#test face cards
		
		return cardHand;
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
	
	public static int settlement(int[] card) {
		int score = 0;
		int ace = 0; 
		int totalScore = 0;
		
		for (int i = 0; i < card.length; i++) {
				
			switch (card[i]) {
			case 11:
			case 12:
			case 13:
				card[i] = 10;
				break;
			}
		}
		
		for (int i : card) {
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
		System.out.println("-------");
		
		return totalScore;
		
	}
	

	public static void singlePlayer() {		
		Scanner inputValue = new Scanner(System.in);
		int spRound = 0;
		int totalScore = 0;
		
		while (spRound < 3) {
			spRound++;
			
			int[] plCard = generateCard();
			reportor(plCard);	
			
			System.out.println("\n[1]hitting\n[2]staying");
			
			int nextRound = inputValue.nextInt();
			while (nextRound !=2) {
				
				plCard = add_element(plCard.length, plCard, (int)(Math.round(Math.random() * 12 + 1)));
				reportor(plCard);
				
				System.out.println("\n[1]hitting\n[2]staying");
				nextRound = inputValue.nextInt();
				
			}
			
			totalScore = totalScore + settlement(plCard);
			
		}
		
		System.out.println("=====================\nYour total Score: " + totalScore + "\n=====================");
		if (totalScore >= 51 && totalScore < 60) {
			System.out.println("Nice");
		}
		else if (totalScore >= 57 && totalScore < 63){
			System.out.println("Good job");
		}
		else if (totalScore == 63) {
			System.out.println("Did you cheat£¿©°(¡£§¥¡£)©´");
		}
		else if (totalScore == 0) {
			System.out.println("(¤Ã ¡ã§¥ ¡ã;)¤Ã");
		}
	
	}
	
	public static int dealerDecision(int dealerCard[]) {
		int dealerValue = 0;
		int nextRound;
		int ace = 0;
		
		for (int i:dealerCard) {
			switch (i) {
			case 1:
				ace++;
				dealerValue = dealerValue + 11;
				break;
			case 11:
			case 12:
			case 13:
				dealerValue = dealerValue + 10;
				break;
			
			default:
				dealerValue = dealerValue + i;
				break;
			}
			
			while (ace > 0) {
				if (dealerValue > 21) {
					ace--;
					dealerValue = dealerValue - 10;	
				}
				else {
					ace--;
				}
			}
		}
		
		if (dealerValue > 16) {
			nextRound = 2;
		}
		else {
			nextRound = 1;
		}
		
		return nextRound;
	}
	
	
	
	public static void autoMode() {	
		int spRound = 0;
		int totalScore = 0;
		
		while (spRound < 3) {
			spRound++;
			int dealerValue = 0;
			int nextRound = 1;
			
			int[] dealerCard = generateCard();
			reportor(dealerCard);
			
			System.out.println("\n[1]hitting\n[2]staying");
			
			nextRound = dealerDecision(dealerCard);
			
			while (nextRound !=2) {
				dealerValue = 0;
				
				dealerCard = add_element(dealerCard.length, dealerCard, (int)(Math.round(Math.random() * 12 + 1)));
				reportor(dealerCard);
				
				System.out.println("\n[1]hitting\n[2]staying");
				
				nextRound = dealerDecision(dealerCard);

				
			}
			
			totalScore = totalScore + settlement(dealerCard);
			
		}
		
		System.out.println("================\nTotal Score: " + totalScore + "\n================");
		if (totalScore >= 51 && totalScore < 60) {
			System.out.println("Nice");
		}
		else if (totalScore >= 60 && totalScore < 63){
			System.out.println("Good job");
		}
		else if (totalScore == 63) {
			System.out.println("That's not impossible, but still...©°(¡£§¥¡£)©´");
		}
		else if (totalScore == 0) {
			System.out.println("(¤Ã ¡ã§¥ ¡ã;)¤Ã");
		}
		
	}

}
