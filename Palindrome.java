/*
* Kate McCarthy
* 12-1-2020
* Recursive program to check if a given word is a palindrome
*/

import java.util.Scanner;

public class Palindrome {

	public static boolean isPalindrome(String wordWithSpaces) {

		String word = ((wordWithSpaces).replaceAll(" ", "")).toLowerCase();

		if (word.length() == 0 || word.length() == 1) return true; // Base Case
		else if (word.charAt(0) == word.charAt(word.length()-1)) {
			return isPalindrome(word.substring(1,word.length()-1));
		}
		return false; // if at any point it fails to satisfy the rule, terminate and return false
	}

	public static void main (String[] args) {

		Scanner input = new Scanner(System.in);
		String exit = "stop";

		System.out.println("racecar: " + isPalindrome("racecar"));
		System.out.println("pasta: " + isPalindrome("pasta"));
		System.out.println("tattarrattat: " + isPalindrome("tattarrattat"));
		System.out.println("Are we not drawn onward, we few, drawn onward to new era?: " + isPalindrome("Are we not drawn onward, we few, drawn onward to new era"));

		String word = "";
		while (!word.equals(exit)) {
			System.out.print("Please type your word here: (type \"stop\" to end program)\t");
			String word = input.nextLine();
			if (!word.equals(exit)) {
				System.out.println(word + ": " + isPalindrome(word));
			}
		}
		input.close();
	}
}
