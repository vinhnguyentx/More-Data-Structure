//  CodeCamp.java - CS314 Assignment 1

//Version 06/12/2014

/*  Student information for assignment:
 * 
 *  On my honor, VINH T NGUYEN, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name:			VINH T NGUYEN
 *  email address:		vinhnguyentx@utexas.edu
 *  UTEID:			vtn288
 *  Section 5 digit ID:		90140
 *  Grader name:		John
 *  Number of slip days used on this assignment: 0
 */

import java.util.Arrays;
import java.util.Random;

public class CodeCamp {

	/**
	 * Determine the Hamming distance between two arrays of ints. 
	 * Neither the parameter <tt>aList</tt> or
	 * <tt>bList</tt> are altered as a result of this method.<br>
	 * @param aList != null, aList.length == bList.length
	 * @param bList != null, bList.length == aList.length
	 * @return the Hamming Distance between the two arrays of ints.
	 */    
	public static int hammingDistance(int[] aList, int[] bList){
		// check preconditions
		if (aList == null || bList == null || aList.length != bList.length) 
			throw new IllegalArgumentException("Violation of precondition: " +
					"hammingDistance. neither parameter may equal null, arrays" +
					" must be equal length.");

		/*STUDENT'S CODE PART 1 IS FROM HERE*/

		int dist = 0;
		for (int i = 0; i < aList.length; i ++) {
			if (aList[i] != bList[i]) dist ++;
		}
		return dist;

		/*END OF PART 1*/
	}


	/**
	 * Determine if one array of ints is a permutation of another.
	 * Neither the parameter <tt>listA</tt> or 
	 * the parameter <tt>listB</tt> are altered as a result of this method.<br>
	 * @param listA != null
	 * @param listB != null
	 * @return <tt>true</tt> if listB is a permutation of listA, 
	 * <tt>false</tt> otherwise
	 * 
	 */
	public static boolean isPermutation(int[] listA, int[] listB) {
		// check preconditions
		if (listA == null || listB == null) 
			throw new IllegalArgumentException("Violation of precondition: " +
					"isPermutation. neither parameter may equal null.");

		/*STUDENT'S CODE PART 2 IS FROM HERE*/

		if (listA.length != listB.length) {
			return false;
		} else if (listA.length == 0 || listB.length == 0) {
			return true;
		} else {
			boolean result = false;
			for (int i = 0; i < listA.length; i ++) {
				for (int j = 0; j < listB.length; j ++) {
					if (listB[j] == listA[i]) result = true;
				}
			}
			return result;
		}

		/*END OF  PART 2*/
	}


	/**
	 * Determine the index of the String that 
	 * has the largest number of vowels. 
	 * Vowels are defined as <tt>'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 
	 * 'U', and 'u'</tt>.
	 * The parameter <tt>list</tt> is not altered as a result of this method.
	 * <p>pre: <tt>list != null</tt>, <tt>list.length > 0</tt>, there is an least 1 non null element in list
	 * <p>post: return the index of the non-null element in list that has the 
	 * largest number of characters that are vowels.
	 * If there is a tie return the index closest to zero. 
	 * The empty String, "", has zero vowels.
	 * It is possible for the maximum number of vowels to be 0.<br>
	 * @param list the array to check
	 * @return the index of the non-null element in list that has 
	 * the largest number of vowels.
	 */
	public static int mostVowels(String[] list) {
		// check preconditions
		if (list == null || list.length == 0 || !atLeastOneNonNull(list))  
			throw new IllegalArgumentException("Violation of precondition: " +
					"mostVowels. parameter may not equal null and must contain " +
					"at least one none null value.");

		//  You can use all methods from the String class and native arrays.

		/*STUDENT'S CODE PART 3 IS FROM HERE*/

		int[] listVowelCount = new int[list.length];	//array contains the numbers of vowels of list[]
		for (int k = 0; k < list.length; k ++) {
			listVowelCount[k] = vowelCount(list[k]);
		}

		int maxIndex = 0;
		int mostVowel = 0;
		for (int m = list.length - 1; m >= 0; m --) {
			if (listVowelCount[m] >= mostVowel) {
				mostVowel = listVowelCount[m];
				maxIndex = m;
			}
		}

		return maxIndex;
	}

	//separated method counting the vowels in a string
	private static int vowelCount(String s) {

		String vowelString = "AaEeIiOoUu";
		int count = 0;
		if (s == null) return -1;		//if string is null, vowel count = -1
		for (int i = 0; i < vowelString.length(); i ++) {
			for (int j = 0; j < s.length(); j ++) {
				if (s.charAt(j) == vowelString.charAt(i)) {
					count ++;
				}
			}
		}						
		return count;
	}

	/*END OF ART 3*/


	/**
	 * Perform an experiment simulating the birthday problem.
	 * Pick random birthdays for the given number of people. 
	 * Return the number of pairs of people that share the
	 * same birthday.<br>
	 * @param numPeople The number of people in the experiment.
	 * This value must be > 0
	 * @param numDaysInYear The number of days in the year for this experiement.
	 * This value must be > 0
	 * @return The number of pairs of people that share a birthday 
	 * after running the simulation.
	 */


	public static int sharedBirthdays(int numPeople, int numDaysInYear) {
		// check preconditions
		if (numPeople <= 0 || numDaysInYear <= 0)
			throw new IllegalArgumentException("Violation of precondition: " +
					"sharedBirthdays. both parameters must be greater than 0. " +
					"numPeople: " + numPeople + 
					", numDaysInYear: " + numDaysInYear);

		/*STUDENT'S CODE PART 4 IS FROM HERE*/

		int[] birthdays = new int[numDaysInYear];		//array containing birthdays of the given people
		birthdays = getBirthday(numPeople, numDaysInYear);		//get the birthdays

		int count = 0;
		for (int i = 0; i < birthdays.length; i ++) {
			for (int j = i + 1; j < birthdays.length; j ++) {

				if (birthdays[j] == birthdays[i]) count ++;
			}
		}

		return count;
	}


	//separated method getting birthdays of the given numbers of people and days in the year
	private static int[] getBirthday(int people, int days) {
		Random r = new Random();
		int[] result = new int[people];
		for (int i = 0; i < people; i ++) {
			result[i] = r.nextInt(days) + 1;
		}
		return result;
	}


	/*END OF ART 4*/


	/**
	 * Determine if the chess board represented by board is a safe set up.
	 * <p>pre: board != null, board.length > 0, board is a square matrix.
	 * (In other words all rows in board have board.length columns.),
	 * all elements of board == 'q' or '.'. 'q's represent queens, '.'s
	 * represent open spaces.<br>
	 * <p>post: return true if the configuration of board is safe,
	 * that is no queen can attack any other queen on the board.
	 * false otherwise.
	 * the parameter <tt>board</tt> is not altered as a result of 
	 * this method.<br>
	 * @param board the chessboard
	 * @return true if the configuration of board is safe,
	 * that is no queen can attack any other queen on the board.
	 * false otherwise.
	 */
	public static boolean queensAreSafe(char[][] board) {
		char[] validChars = {'q', '.'};
		// check preconditions
		if (board == null || board.length == 0 || !isSquare(board) 
				|| !onlyContains(board, validChars))
			throw new IllegalArgumentException("Violation of precondition: " +
					"queensAreSafe. The board may not be null, must be square, " +
					"and may only contain 'q's and '.'s");        

		//*STUDENT'S CODE PART 5 IS FROM HERE

		boolean safe = true;
		for (int r = 0; r < board.length; r ++) {
			for (int c = 0; c < board.length; c ++) {
				if (board[r][c] == 'q') {
					safe = safeCheck(board, r, c);
				}
			}
		}

		return safe;
	}

			//check if queen is safe
			private static boolean safeCheck(char[][] board, int row, int col) {
		
				boolean colSafe = true;
				int numColQueens = 0;
				for (int i = 0; i < board.length; i ++) {		//column check
					if (board[i][col] == 'q') {
						numColQueens ++;
						colSafe = numColQueens < 2;
					}
				}
		
				boolean rowSafe = true;
				int numRowQueens = 0;
				for (int j = 0; j < board.length; j ++) {		//row check
					if (board[row][j] == 'q') {
						numRowQueens ++;
						rowSafe = numRowQueens < 2;
					}
				}
		
				boolean dia1Safe = true;
				int numDia1Queens = 0;
				if (row >= col) {			//diagonal down and left check
					for (int k = 0; k < board.length - (row - col); k ++) {
						if (board[row - col + k][k] == 'q') {
							numDia1Queens ++;
							dia1Safe = numDia1Queens < 2;
						}
					}
				}
		
				boolean dia2Safe = true;
				int numDia2Queens = 0;
				if (col > row) {			//diagonal down and right check
					for (int l = 0; l < board.length - (col - row); l ++) {
						if (board[l][col - row + l] == 'q') {
							numDia2Queens ++;
							dia2Safe = numDia2Queens < 2;
						}
					}
				}
		
				boolean dia3Safe = true;
				int numDia3Queens = 0;
				if (row + col < board.length) {			//diagonal up and left check
					for (int m = 0; m <= row + col; m ++) {
						if (board[m][row + col - m] == 'q') {
							numDia3Queens ++;
							dia3Safe = numDia3Queens < 2;
						}
					}
				}
		
				boolean dia4Safe = true;
				int numDia4Queens = 0;
				if (row + col >= board.length) {		//diagonal up and right check
					for (int n = row + col - (board.length - 1); n < board.length; n ++) {
						if (board[n][(row + col) - n] == 'q') {
							numDia4Queens ++;
							dia4Safe = numDia4Queens < 2;
						}
					}
				}
				return (colSafe && rowSafe && dia1Safe && dia2Safe && dia3Safe && dia4Safe);
			}

	/*END OF PART 5*/

	/**
	 * Given a 2D array of ints return the value of the
	 * most valuable contiguous sub rectangle in the 2D array.
	 * The sub rectangle must be at least 1 by 1. 
	 * <p>pre: <tt>mat != null, mat.length > 0, mat[0].length > 0,
	 * mat</tt> is a rectangular matrix.
	 * <p>post: return the value of the most valuable contigous sub rectangle
	 * in <tt>city</tt>.<br>
	 * @param city The 2D array of ints representing the value of
	 * each block in a portion of a city.
	 * @return return the value of the most valuable contigous sub rectangle
	 * in <tt>city</tt>.
	 */
	public static int getValueOfMostValuablePlot(int[][] city) {
		// check preconditions
		if (city == null || city.length == 0 || city[0].length == 0 
				|| !isRectangular(city) )
			throw new IllegalArgumentException("Violation of precondition: " +
					"getValueOfMostValuablePlot. The parameter may not be null," +
					" must value at least one row and at least" +
					" one column, and must be rectangular."); 


		//*STUDENT'S CODE PART 6 IS FROM HERE

		int mostValBlock = city[0][0];

		for (int row = 0; row < city.length; row ++) {
			for (int col = 0; col < city[0].length; col ++) {
				mostValBlock = blockSum(row, col, mostValBlock, city);
			}
		}

		return mostValBlock;
	}


	//calculate value of the blocks
	public static int blockSum (int row, int col, int mostValBlock, int[][] city) {
		int blockValue = 0;
		for (int i = 0; i < city.length - row; i ++) {
			for (int j = 0; j < city[0].length - col; j ++) {
				for (int m = i; m >= 0; m--) {
					for (int n = j; n >= 0; n --) {
						blockValue += city[row + m][col + n];
					}
				}

				if(blockValue > mostValBlock) {
					mostValBlock = blockValue;
				}

				blockValue = 0;
			}
		}

		return mostValBlock;
	}

	/*END OF PART 6*/


	// !!!!! ***** !!!!! ***** !!!!! ****** !!!!! ****** !!!!! ****** !!!!!!
	// CS314 STUDENTS: Put your birthday problem experiments code here:

	//Perform 1,000,000 experiments with 365 days per year and 182 people per experiment
	public static int experiment1(int noPeople, int daysInYear) {

		final int expm = 1000000;
		int avg = 0;
		int total = 0;
		for (int i = 0; i < expm; i ++) {
			total += sharedBirthdays(noPeople, daysInYear);
		}
		avg = (int) total/expm;
		return avg;
	}

	//Perform 50,000 experiments with 365 days per year and vary the number of people from 2 to 100
	public static void experiment2(int noPeople, int daysInYear) {

		final int expm = 50000;
		double pct = 0.0;
		int total = 0;
		for (int i = 2; i <= noPeople; i ++) {
			int positive = 0;
			for (int j = 1; j <= expm; j ++) {
				if (sharedBirthdays(i, daysInYear) >= 1) {
					positive ++;
				}
				pct = positive*100/expm;
			}
		}
	}

	// pre: list != null
	// post: return true if at least one element in list is null
	// otherwise return false.
	private static boolean atLeastOneNonNull(String[] list) {
		// check precondition
		if(list == null)
			throw new IllegalArgumentException("Violation of precondition: " +
					"atLeastOneNonNull. parameter may not equal null.");

		boolean foundNonNull = false;
		int i = 0;
		while( !foundNonNull && i < list.length ){
			foundNonNull = list[i] != null;
			i++;
		}
		return foundNonNull;
	}


	/* pre: mat != null
    post: return true if mat is a square matrix, false otherwise
	 */
	private static boolean isSquare(char[][] mat) {
		if(mat == null)
			throw new IllegalArgumentException("Violation of precondition: " +
					"isSquare. paremeter may not be null.");

		final int numRows = mat.length;
		int row = 0;
		boolean isSquare = true;
		while( isSquare && row < numRows ) {
			isSquare = ( mat[row] != null) && (mat[row].length == numRows);
			row++;
		}
		return isSquare;
	}


	/* pre: mat != null, valid != null
    post: return true if all elements in mat are one of the characters in valid
	 */
	private static boolean onlyContains(char[][] mat, char[] valid) {
		// check preconditions
		if(mat == null || valid == null)
			throw new IllegalArgumentException("Violation of precondition: " +
					"onlyContains. paremeters may not be null.");

		int row = 0;
		boolean correct = true;
		while( correct && row < mat.length) {
			int col = 0;
			while(correct && col < mat[row].length) {
				correct = contains(valid, mat[row][col]);
				col++;
			}
			row++;
		}
		return correct;
	}


	/*  pre: list != null
        post: return true if c is in list
	 */
	private static boolean contains(char[] list, char tgtChar) {
		// check preconditions
		if(list == null)
			throw new IllegalArgumentException("Violation of precondition: " +
					"contains. paremeter may not be null.");

		boolean found = false;
		int index = 0;
		while( !found && index < list.length) {
			found = list[index] == tgtChar;
			index++;
		}
		return found;
	}


	// pre: mat != null, mat.length > 0
	// post: return true if mat is rectangular
	private static boolean isRectangular(int[][] mat) {
		// check preconditions
		if(mat == null || mat.length == 0)
			throw new IllegalArgumentException("Violation of precondition: " +
					"isRectangular. paremeter may not be null and must contain" +
					" at least one row.");

		boolean correct = mat[0] != null;
		int row = 0;
		while(correct && row < mat.length) {
			correct = (mat[row] != null) && (mat[row].length == mat[0].length);
			row++;
		}
		return correct;
	}

	// make constructor private so no instances of CodeCamp can be created
	private CodeCamp() {

	}
}