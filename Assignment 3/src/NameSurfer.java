//  NameSurfer.java - CS314 Assignment 3

//Version 06/27/2014
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
 *  Number of slip days used on this assignment: 2
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class NameSurfer {

	// constants for menu choices
	
	public static final int SEARCH = 1;
	public static final int ONE_NAME = 2;
	public static final int APPEAR_ONCE = 3;
	public static final int APPEAR_ALWAYS = 4;
	public static final int MORE_POPULAR = 5;
	public static final int LESS_POPULAR = 6;
	
	
	public static final int QUIT = 8;
	
	// CS314 students, explain your menu option 7 here:
		//SORRY, DUE TO FAMILY ISSUE I CAN NOT FINISH THIS PART IN TIME
	
	// CS314 students, Explain your interesting search / trend here:
		//SORRY, DUE TO FAMILY ISSUE I CAN NOT FINISH THIS PART IN TIME

	// CS314 students, add test code for NameRecord class here:
		//SORRY, DUE TO FAMILY ISSUE I CAN NOT FINISH THIS PART IN TIME
	
    // simple test for toString
		//SORRY, DUE TO FAMILY ISSUE I CAN NOT FINISH THIS PART IN TIME

	// main method. Driver for the whole program
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
		    System.out.println("Unable to set look at feel to local settings. " +
		    		"Continuing with default Java look and feel.");
		}
	    try {
		    Scanner fileScanner = new Scanner(new File("names2.txt"));
			Names n = new Names(fileScanner);
			fileScanner.close();
			int choice;
			Scanner keyboard = new Scanner(System.in);
			
			do {
				showMenu();
				choice = getChoice(keyboard);
				if( choice == SEARCH)
					search(n, keyboard);
				else if( choice == ONE_NAME )
					oneName(n, keyboard);
				else if( choice == APPEAR_ONCE )
					appearOnce(n);
				else if( choice == APPEAR_ALWAYS )
					appearAlways(n);
				// CS314 students, complete this section
				else if (choice == MORE_POPULAR)
					morePopular(n);
				else if (choice == LESS_POPULAR)
					lessPopular(n);

			} while( choice != QUIT);
		}
		catch(FileNotFoundException e) {
			System.out.println("Problem reading the data file. Exiting the program." + e);
		}
	}

	// method that shows names that have appeared in every decade
	// pre: n != null
	// post: print out names that have appeared in every decade
	private static void appearAlways(Names n) {
		if (n == null)
			throw new IllegalArgumentException ("Violation of precondition. No data entered.");
		
		ArrayList<String> result = n.rankedEveryDecade();
		
		System.out.println(result.size() + " names appear in all decades.");
		for (String name : result) {
			System.out.println(name);
		}
	}

	// method that shows names that have appeared in only one decade
	// pre: n != null
	// post: print out names that have appeared in only one decade
	private static void appearOnce(Names n) {
		if (n == null)
			throw new IllegalArgumentException ("Violation of precondition. No data entered.");
		
		ArrayList<String> result = n.rankedOnlyOneDecade();

		System.out.println(result.size() + " names appear in only on decade.");
		for (String name : result) {
			System.out.println(name);
		}
	}
	
	// method that shows names that have been getting more popular every decade
	// pre: n != null
	// post: print out names that have been getting more popular every decade. 
	private static void morePopular(Names n) {
		if (n == null)
			throw new IllegalArgumentException ("Violation of precondition. No data entered.");
		
		ArrayList<String> result = n.alwaysMorePopular();

		System.out.println(result.size() + " names have been getting more popular every decade.");
		for (String name : result) {
			System.out.println(name);
		}
	}
	
	// method that shows names that have been getting less popular every decade
	// pre: n != null
	// post: print out names that have been getting less popular every decade. 
	private static void lessPopular(Names n) {
		if (n == null)
			throw new IllegalArgumentException ("Violation of precondition. No data entered.");
		
		ArrayList<String> result = n.alwaysLessPopular();

		System.out.println(result.size() + " names have been getting less popular every decade.");
		for (String name : result) {
			System.out.println(name);
		}
	}


	// method that shows data for one name, or states that name has never been ranked
	// pre: n != null, keyboard != null and is connected to System.in
	// post: print out the data for n or a message that n has never been in the top 1000 for any decade
	private static void oneName(Names n, Scanner keyboard) {
		System.out.println("Enter a new to search for: ");
		String name = keyboard.nextLine();
		
		if (name == null)
			throw new IllegalArgumentException ("Violation of precondition. No data entered.");
		
		NameRecord result = n.searchOneName(name);
		if (result == null) {
			System.out.println("\n" + name + " does not appear in any decade.");
		} else {
			result.toString();
		}
	}

	// method that shows all names that contain a substring from the user
	// and the decade they were most popular in
	// pre: n != null, keyboard != null and is connected to System.in
	// post: show the correct data		
	private static void search(Names n, Scanner keyboard) {
		System.out.print("Enter a partial name: ");
		String name = keyboard.nextLine();

		ArrayList<NameRecord> results = n.getMatches(name);
		System.out.println("\nThere are " + results.size() + " matches for " + name +".\n");
		System.out.println("The matches with their highest ranking decade are:");

		for (NameRecord record : results) {
			System.out.println(record.getName() + " " + record.bestDecade());
		}

	}

	// get choice from the user
	// keyboard != null and is connected to System.in
	// return an int that is >= SEARCH and <= QUIT
	private static int getChoice(Scanner keyboard) {
		int choice = getInt(keyboard, "Enter choice: ");
		keyboard.nextLine();
		while( choice < SEARCH || choice > QUIT){
			System.out.println("\n" + choice + " is not a valid choice");
			choice = getInt(keyboard, "Enter choice: ");
			keyboard.nextLine();
		}
		return choice;
	}
	
	// ensure an int is entered from the keyboard
	// pre: s != null and is connected to System.in
    private static int getInt(Scanner s, String prompt) {
        System.out.print(prompt);
        while( !s.hasNextInt() ){
            s.next();
            System.out.println("That was not an int.");
            System.out.print(prompt);
        }
        return s.nextInt();
    }

    // show the user the menu
	private static void showMenu() {
		System.out.println("\nOptions:");
		System.out.println("Enter " + SEARCH + " to search for names.");
		System.out.println("Enter " + ONE_NAME + " to display data for one name.");
		System.out.println("Enter " + APPEAR_ONCE+ " to display all names that appear in only one decade.");
		System.out.println("Enter " + APPEAR_ALWAYS + " to display all names that appear in all decades.");
		// CS314 students fill in other options
		System.out.println("Enter " + MORE_POPULAR + " to display all names that are more popular in every decade.");
		System.out.println("Enter " + LESS_POPULAR + " to display all names that are less popular in every decade.");
		
		
		System.out.println("Enter " + QUIT + " to quit.\n");
	}

	/** Method to choose a file using a traditional window.
     * @return the file chosen by the user. Returns null if no file picked.
     */ 
    public static File getFile() {
        // create a GUI window to pick the text to evaluate
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Select File With Baby Names Data.");
        int retval = chooser.showOpenDialog(null);
        File f =null;
        chooser.grabFocus();
        if (retval == JFileChooser.APPROVE_OPTION)
           f = chooser.getSelectedFile();
        return f;
    }

}
