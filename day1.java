package demo;
import java.util.Scanner;

public class test4_game2 {

	public static void main(String[] args) {
		Scanner inputValue = new Scanner(System.in);
		int count = 1;
		int max = 1000;
		
		System.out.println("Do you want to set the range of number?(default setting:1-1000)\n(1 for yes/input any number for no)");
		int yesNo = inputValue.nextInt();
		if (yesNo == 1) {
			System.out.println("Please set the maximum number:");
			max = inputValue.nextInt();
		}
		
		System.out.println("Please input a number (between 1-" + max +")");
		int goal = (int)(Math.round(Math.random() * max + 1));
		int usernum = inputValue.nextInt();
		
		while (usernum != goal) {
			
			if (usernum/2 > goal) {
				System.out.println("My number is much less than [" + usernum+ "], try again.");
			}
			else if(usernum > goal) {
				System.out.println("My number is less than [" + usernum+ "], try again.");
			}
			else if(usernum*2 < goal) {
				System.out.println("My number is much more than [" + usernum+ "], try again.");
			}
			else {
				System.out.println("My number is more than [" + usernum+ "], try again.");
			}
			
			count++;
			usernum = inputValue.nextInt();
			
		}
		System.out.println("The number [" + goal+ "] you guess is correct. You win(๑•̀ㅂ•́)و✧");
		System.out.println("You take " + count + " steps.");

	}

}
