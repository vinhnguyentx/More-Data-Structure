//  LetterInventory.java - CS314 Assignment 7

//Version 07/24/2014
/*  Student information for assignment:
 * 
 *  On my honor, Vinh T Nguyen, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name:			Vinh T Nguyen
 *  email address:		vinhnguyentx@utexas.edu
 *  UTEID:			vtn288
 *  Section 5 digit ID:		90140
 *  Grader name:		John A. Thywissen
 *  Number of slip days used on this assignment: 0
 */

public class LetterInventory {
	private static final int ALPHABET_LENGTH = 26;
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private int[] frequency;
	private int numOfLetters;
	
	/* Constructor
	 * pre: input != null
	 * post: store and update the number of times each English letter occurs.
	 */
	public LetterInventory(String input) {
		
		if (input == null)
			throw new IllegalArgumentException("Violation of precondition: input cannot be null");
		frequency = new int[ALPHABET_LENGTH];
		numOfLetters = 0;
		
		String data = input.toLowerCase();
		for (int index = 0; index < input.length(); index ++) {
			//check if a English letter occurs
			if ('a' <= data.charAt(index) && data.charAt(index) <= 'z') {
				//increase the frequency of an English letter
				frequency[data.charAt(index) - 'a'] ++;
				//increase the count of an English letters in the string
				numOfLetters ++;
			}
		}
	}
	
	/*
	 * create a new object
	 */
	public LetterInventory() {
		this.frequency = new int[ALPHABET_LENGTH];
		this.numOfLetters = 0;
	}
	
	/* return the frequency of that letter in this LetterInventory
	 * pre: the char be an English letter
	 * post: return the frequency of that letter
	 */
	public int get(char ch) {
		if (Character.toLowerCase(ch) < 'a' || Character.toLowerCase(ch) > 'z')
			throw new IllegalArgumentException("Violation of precondition: the letter must be an English letter");
		return frequency[Character.toLowerCase(ch) - 'a'];
	}
	
	/* returns the total number of letters in this LetterInventory
	 * pre: none
	 * post: returns the total number of letters
	 */
	public int size() {
		return this.numOfLetters;
	}
	
	/* return true if the size of the LetterInventory is 0, false otherwise
	 * pre: none
	 * post: boolean value
	 */
	public boolean isEmpty() {
		return this.numOfLetters == 0;
	}
	
	/* return a String representation of this LetterInventory
	 * pre: none
	 * post:  returns a String representation of this LetterInventory
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		//search through out the alphabet
		for (int letterPos = 0; letterPos < ALPHABET_LENGTH; letterPos ++) {
			//append the letter as many times as its frequency
			for (int freq = 0; freq < frequency[letterPos]; freq ++) {
				result.append(ALPHABET.charAt(letterPos));
			}
		}
		return result.toString();
	}
	
	/* return a new LetterInventory created by adding the frequencies from
	 * the calling and explicit objects 
	 * pre: LetterInventory sent as an explicit parameter not be null
	 * post: return a new LetterInventory have the sum of frequencies,
	 * neither the calling object or the explicit parameter are altered
	 */
	public LetterInventory add(LetterInventory other) {
		if (other == null)
			throw new IllegalArgumentException("Violation of precondition: the LetterInventory sent must not be null");
		LetterInventory result = new LetterInventory("");
		result.numOfLetters = this.numOfLetters;
		
		for (int letterPos = 0; letterPos < ALPHABET_LENGTH; letterPos ++) {
			//add frequencies of each letter
			result.frequency[letterPos] = this.frequency[letterPos] + other.frequency[letterPos];
			result.numOfLetters += other.frequency[letterPos];
		}
		return result;
	}
	
	/* return a new LetterInventory created by subtracting the frequencies from
	 * the calling and explicit objects 
	 * pre: LetterInventory sent as an explicit parameter not be null
	 * post: return a new LetterInventory have the sum of frequencies,
	 * neither the calling object or the explicit parameter are altered
	 */
	public LetterInventory subtract(LetterInventory other) {
		if (other == null)
			throw new IllegalArgumentException("Violation of precondition: the LetterInventory sent must not be null");
		LetterInventory result = new LetterInventory("");
		result.numOfLetters = this.numOfLetters;
		
		for (int letterPos = 0; letterPos < ALPHABET_LENGTH; letterPos ++) {
			//subtract frequencies from 2 LetterInventory of each letter
			result.frequency[letterPos] = this.frequency[letterPos] - other.frequency[letterPos];
			
			//return null if any frequency appear to be less than 0
			if (result.frequency[letterPos] < 0) {
				return null;
			}
			result.numOfLetters -= other.frequency[letterPos];
		}
		return result;
	}
	
	/* return true if the frequency for each letter in the alphabet is the same
	 * in both LetterInventory objects, false otherwise
	 * pre: none
	 * post: true or false
	 */
	public boolean equals(Object other) {
		boolean result = false;
		//check if other is an instance of the class
		if (other instanceof LetterInventory) {
			//check if other is null, or if the numOfLetters are different
			if (other == null || this.numOfLetters != ((LetterInventory) other).numOfLetters) {
				return false;
			} else {
				result = true;
				for (int letterPos = 0; letterPos < ALPHABET_LENGTH; letterPos ++) {
					//return false and stop if any frequency is different
					if (this.frequency[letterPos] != ((LetterInventory) other).frequency[letterPos]) {
						return false;
					}
				}
			}
		}
		return result;
	}
	
}
