import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//  CodeCamp.java - CS314 Assignment 1 - Tester class

//Version 06/12/2014

/*  Student information for assignment:
 * 
 *  On my honor, VINH T NGUYEN, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name:					VINH T NGUYEN
 *  email address:			vinhnguyentx@utexas.edu
 *  UTEID:					vtn288
 *  Section 5 digit ID:		90140
 *  Grader name:			John
 *  Number of slip days used on this assignment:
 */


/* CS314 Students: place results of shared birthdays experiments in this comment.
 *  Experiment 1: Perform 1,000,000 experiments with 365 days per year and 182 people per experiment. 
	- Average number of pairs of people with shared birthdays: 45

 ** Experiment 2: Perform 50,000 experiments with 365 days per year and vary the number of people from 2 to 100.
	- 50,000 runs per experiments * 99 experiments = 4,950,000 runs
		The percentage first exceed 50%: at 24 people.
Num people: 2, number of experiments with one or more shared birthday: 134, percentage: 0.0
Num people: 3, number of experiments with one or more shared birthday: 402, percentage: 0.0
Num people: 4, number of experiments with one or more shared birthday: 841, percentage: 1.0
Num people: 5, number of experiments with one or more shared birthday: 1352, percentage: 2.0
Num people: 6, number of experiments with one or more shared birthday: 2008, percentage: 4.0
Num people: 7, number of experiments with one or more shared birthday: 2826, percentage: 5.0
Num people: 8, number of experiments with one or more shared birthday: 3683, percentage: 7.0
Num people: 9, number of experiments with one or more shared birthday: 4658, percentage: 9.0
Num people: 10, number of experiments with one or more shared birthday: 5759, percentage: 11.0
Num people: 11, number of experiments with one or more shared birthday: 7129, percentage: 14.0
Num people: 12, number of experiments with one or more shared birthday: 8229, percentage: 16.0
Num people: 13, number of experiments with one or more shared birthday: 9659, percentage: 19.0
Num people: 14, number of experiments with one or more shared birthday: 11247, percentage: 22.0
Num people: 15, number of experiments with one or more shared birthday: 12524, percentage: 25.0
Num people: 16, number of experiments with one or more shared birthday: 14038, percentage: 28.0
Num people: 17, number of experiments with one or more shared birthday: 15550, percentage: 31.0
Num people: 18, number of experiments with one or more shared birthday: 17412, percentage: 34.0
Num people: 19, number of experiments with one or more shared birthday: 19014, percentage: 38.0
Num people: 20, number of experiments with one or more shared birthday: 20622, percentage: 41.0
Num people: 21, number of experiments with one or more shared birthday: 22156, percentage: 44.0
Num people: 22, number of experiments with one or more shared birthday: 23750, percentage: 47.0
Num people: 23, number of experiments with one or more shared birthday: 25204, percentage: 50.0
Num people: 24, number of experiments with one or more shared birthday: 26987, percentage: 53.0
Num people: 25, number of experiments with one or more shared birthday: 28376, percentage: 56.0
Num people: 26, number of experiments with one or more shared birthday: 29892, percentage: 59.0
Num people: 27, number of experiments with one or more shared birthday: 31354, percentage: 62.0
Num people: 28, number of experiments with one or more shared birthday: 32876, percentage: 65.0
Num people: 29, number of experiments with one or more shared birthday: 34046, percentage: 68.0
Num people: 30, number of experiments with one or more shared birthday: 35445, percentage: 70.0
Num people: 31, number of experiments with one or more shared birthday: 36573, percentage: 73.0
Num people: 32, number of experiments with one or more shared birthday: 37749, percentage: 75.0
Num people: 33, number of experiments with one or more shared birthday: 38670, percentage: 77.0
Num people: 34, number of experiments with one or more shared birthday: 39677, percentage: 79.0
Num people: 35, number of experiments with one or more shared birthday: 40685, percentage: 81.0
Num people: 36, number of experiments with one or more shared birthday: 41578, percentage: 83.0
Num people: 37, number of experiments with one or more shared birthday: 42466, percentage: 84.0
Num people: 38, number of experiments with one or more shared birthday: 43120, percentage: 86.0
Num people: 39, number of experiments with one or more shared birthday: 43961, percentage: 87.0
Num people: 40, number of experiments with one or more shared birthday: 44584, percentage: 89.0
Num people: 41, number of experiments with one or more shared birthday: 45065, percentage: 90.0
Num people: 42, number of experiments with one or more shared birthday: 45714, percentage: 91.0
Num people: 43, number of experiments with one or more shared birthday: 46219, percentage: 92.0
Num people: 44, number of experiments with one or more shared birthday: 46683, percentage: 93.0
Num people: 45, number of experiments with one or more shared birthday: 47104, percentage: 94.0
Num people: 46, number of experiments with one or more shared birthday: 47449, percentage: 94.0
Num people: 47, number of experiments with one or more shared birthday: 47753, percentage: 95.0
Num people: 48, number of experiments with one or more shared birthday: 48039, percentage: 96.0
Num people: 49, number of experiments with one or more shared birthday: 48330, percentage: 96.0
Num people: 50, number of experiments with one or more shared birthday: 48542, percentage: 97.0
Num people: 51, number of experiments with one or more shared birthday: 48741, percentage: 97.0
Num people: 52, number of experiments with one or more shared birthday: 48877, percentage: 97.0
Num people: 53, number of experiments with one or more shared birthday: 49076, percentage: 98.0
Num people: 54, number of experiments with one or more shared birthday: 49222, percentage: 98.0
Num people: 55, number of experiments with one or more shared birthday: 49302, percentage: 98.0
Num people: 56, number of experiments with one or more shared birthday: 49429, percentage: 98.0
Num people: 57, number of experiments with one or more shared birthday: 49532, percentage: 99.0
Num people: 58, number of experiments with one or more shared birthday: 49589, percentage: 99.0
Num people: 59, number of experiments with one or more shared birthday: 49649, percentage: 99.0
Num people: 60, number of experiments with one or more shared birthday: 49692, percentage: 99.0
Num people: 61, number of experiments with one or more shared birthday: 49765, percentage: 99.0
Num people: 62, number of experiments with one or more shared birthday: 49779, percentage: 99.0
Num people: 63, number of experiments with one or more shared birthday: 49832, percentage: 99.0
Num people: 64, number of experiments with one or more shared birthday: 49860, percentage: 99.0
Num people: 65, number of experiments with one or more shared birthday: 49868, percentage: 99.0
Num people: 66, number of experiments with one or more shared birthday: 49912, percentage: 99.0
Num people: 67, number of experiments with one or more shared birthday: 49916, percentage: 99.0
Num people: 68, number of experiments with one or more shared birthday: 49942, percentage: 99.0
Num people: 69, number of experiments with one or more shared birthday: 49957, percentage: 99.0
Num people: 70, number of experiments with one or more shared birthday: 49958, percentage: 99.0
Num people: 71, number of experiments with one or more shared birthday: 49971, percentage: 99.0
Num people: 72, number of experiments with one or more shared birthday: 49960, percentage: 99.0
Num people: 73, number of experiments with one or more shared birthday: 49985, percentage: 99.0
Num people: 74, number of experiments with one or more shared birthday: 49987, percentage: 99.0
Num people: 75, number of experiments with one or more shared birthday: 49986, percentage: 99.0
Num people: 76, number of experiments with one or more shared birthday: 49987, percentage: 99.0
Num people: 77, number of experiments with one or more shared birthday: 49992, percentage: 99.0
Num people: 78, number of experiments with one or more shared birthday: 49994, percentage: 99.0
Num people: 79, number of experiments with one or more shared birthday: 49994, percentage: 99.0
Num people: 80, number of experiments with one or more shared birthday: 49998, percentage: 99.0
Num people: 81, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 82, number of experiments with one or more shared birthday: 49999, percentage: 99.0
Num people: 83, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 84, number of experiments with one or more shared birthday: 49998, percentage: 99.0
Num people: 85, number of experiments with one or more shared birthday: 49999, percentage: 99.0
Num people: 86, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 87, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 88, number of experiments with one or more shared birthday: 49999, percentage: 99.0
Num people: 89, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 90, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 91, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 92, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 93, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 94, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 95, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 96, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 97, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 98, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 99, number of experiments with one or more shared birthday: 50000, percentage: 100.0
Num people: 100, number of experiments with one or more shared birthday: 50000, percentage: 100.0
 */

public class CodeCampTester {

	public static void main(String[] args){
		final String newline = System.getProperty("line.separator");


		// CS314 Students: add tests here.

		// test 1, hamming distance
		int [] h1 = new int[] {1, 8, 9, 18, 4, 0};
		int [] h2 = new int[] {1, 8, 8, 18, 3, 0};
		int expected = 2;
		int actual = CodeCamp.hammingDistance(h1, h2);
		System.out.println(newline + "Test 1 hamming distance: expected value: " 
				+ expected + ", actual value: " + actual);
		if( expected == actual )          
			System.out.println(" passed test 1, hamming distance");
		else
			System.out.println(" ***** FAILED ***** test 1, hamming distance");

		// test 2, hamming distance
		h1 = new int[] {1, 3, 0, -6, 7, -146, 125, 876, -765, 15};
		h2 = new int[] {0, 3, 5, -5, 4, 9, 12, 4, 654, -98};
		expected = 9;
		actual = CodeCamp.hammingDistance(h1, h2);
		System.out.println(newline + "Test 2 hamming distance: expected value: " 
				+ expected + ", actual value: " + actual);
		if( expected == actual )          
			System.out.println(" passed test 2, hamming distance");
		else
			System.out.println(" ***** FAILED ***** test 2, hamming distance");
		
		
		// test 3, mostVowels
		String[] sList = new String[] {"", null, "100,000,000", "XXX", "", "!!!!>>+_)(*&^%$#@!>)))???\\///\n\n/n", null};
		int expectedResult = 0;
		int actualResult = CodeCamp.mostVowels(sList);
		System.out.println(newline + "Test 3 mostVowels: expected result: " 
				+ expectedResult + ", actual result: " + actualResult);
		if( actualResult == expectedResult )
			System.out.println("passed test 3, mostVowels");
		else
			System.out.println("***** FAILED ***** test 3, mostVowels"); 


		// test 4, mostVowels
		sList = new String[] {null, null, "mnhgbvf"};
		expectedResult = 2;
		actualResult = CodeCamp.mostVowels(sList);
		System.out.println(newline + "Test 4 mostVowels: expected result: " 
				+ expectedResult + ", actual result: " + actualResult);
		if( actualResult == expectedResult )
			System.out.println("passed test 4, mostVowels");
		else
			System.out.println("***** FAILED ***** test 4, mostVowels");

		//test 5, is Permutation
		int[] a = new int[]{-32, 1, 6};
		int[] b = new int[]{-32, 1, -32, 6};
		boolean expectedBool = false;
		boolean actualBool = CodeCamp.isPermutation(a, b);
		System.out.println(newline + "Test 5 isPermutation: expected value: " 
				+ expectedBool + ", actual value: " + actualBool);
		if ( expectedBool == actualBool )
			System.out.println(" passed test 5, isPermutation");
		else
			System.out.println(" ***** FAILED ***** test 5, isPermutation");

		//test 6, is Permutation
		a = new int[]{1000, 10, 1};
		b = new int[]{1000, 1, 10};
		expectedBool = true;
		actualBool = CodeCamp.isPermutation(a, b);
		System.out.println(newline + "Test 6 isPermutation: expected value: " 
				+ expectedBool + ", actual value: " + actualBool);
		if ( expectedBool == actualBool )
			System.out.println(" passed test 6, isPermutation");
		else
			System.out.println(" ***** FAILED ***** test 6, isPermutation");
		
		//test 7, sharedBirthdays, simple test
        int pairs = CodeCamp.sharedBirthdays(4, 365);
        System.out.println(newline + "Test 7 shared birthdays: expected: 0, actual: " + pairs);
        int expectedShared = 0;
        if( pairs == expectedShared )
            System.out.println("passed test 7, shared birthdays");
        else
            System.out.println("***** FAILED ***** test 7, shared birthdays");
        
        //test 8, sharedBirthdays, simple test
        pairs = CodeCamp.sharedBirthdays(156, 365);
        System.out.println(newline + "Test 8 shared birthdays: expected: " +
                "a value of 1 or more, actual: " + pairs);
        if( pairs > 0 )
            System.out.println("passed test 8, shared birthdays");
        else
            System.out.println("***** FAILED ***** test 8, shared birthdays");      

/*
		//experiment 1, sharedBirthdays experiment 1
		pairs = CodeCamp.experiment1(182, 365);

		//experiment 2, sharedBirthdays experiment 2
		CodeCamp.experiment2(100, 365);  
*/
        
		// test 9, queensAreSafe, no queens
		char[][] board = new char[][]{{'.', '.', '.', '.'},
				{'.', 'q', '.', '.'},
				{'.', '.', '.', '.'},
				{'.', '.', '.', '.'}};
		expectedBool = true;
		actualBool = CodeCamp.queensAreSafe(board);

		System.out.println(newline + "Test 9 queensAreSafe: expected value: "
				+ expectedBool + ", actual value: " + actualBool);
		if (expectedBool == actualBool) {
			System.out.println(" passed test 9, queensAreSafe");
		} else {
			System.out.println(" ***** FAILED ***** test 9, queensAreSafe");
		}

		//test 10, queensAreASafe
		board = new char[][] {{'q', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', 'q', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', 'q', '.'},
				{'.', '.', 'q', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', 'q'},
				{'.', '.', '.', '.', '.', '.', '.'}};
		expectedBool = true;
		actualBool = CodeCamp.queensAreSafe(board);
		System.out.println(newline + "Test 10 queensAreSafe: expected value: " 
				+ expectedBool + ", actual value: " + actualBool);
		if ( expectedBool == actualBool )
			System.out.println(" passed test 10, queensAreSafe");
		else
			System.out.println(" ***** FAILED ***** test 10, queensAreSafe");


		// test 11, getValueOfMostValuablePlot
		int[][] city = {{  0, -2, -7,  0, -1},
				{  9,  2, -6,  2,  0},
				{ -4, 10, -4,  1,  2},
				{ -1,  8,  0, -2,  1},
				{ -1,  1,  8, -5, -6}};


		expected = 24;
		actual = CodeCamp.getValueOfMostValuablePlot(city);
		System.out.println(newline + "Test 11 getValueOfMostValuablePlot: expected value: " 
				+ expected + ", actual value: " + actual);
		if( expected == actual )          
			System.out.println(" passed test 11, getValueOfMostValuablePlot");
		else
			System.out.println(" ***** FAILED ***** test 11, getValueOfMostValuablePlot");


		// test 12, getValueOfMostValuable Plot, single column
		city = new int[][] {{ 0,  -5, -16, -60,  -1},
				{ 3, -22,  -3, -23,  16},
				{-1,  -6,   0,  -4, -10},
				{ 0,   0,   9,   0,  -2}};
		expected = 16;
		actual = CodeCamp.getValueOfMostValuablePlot(city);

		System.out.println(newline + "Test 12 getValueOfMostValuablePlot: expected value: "
				+ expected + ", actual value: " + actual);
		if (expected == actual) {
			System.out.println(" passed test 12, getValueOfMostValuablePlot");
		} else {
			System.out.println(" ***** FAILED ***** test 12, getValueOfMostValuablePlot");
		}
		
		
		
	} // end of main method

	// pre: list != null
	private static int[] intListToArray(List<Integer> list) {
		if(list == null)
			throw new IllegalArgumentException("list parameter may not be null.");
		int[] result = new int[list.size()];
		int arrayIndex = 0;
		for(int x : list) {
			result[arrayIndex++] = x;
		}
		return result;
	}
}

