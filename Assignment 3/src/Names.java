//  Names.java - CS314 Assignment 3

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

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A collection of NameRecords. 
 * Stores NameRecord objects and provides methods to select
 * NameRecords based on various criteria.
 */
public class Names {
	public static int baseDecade;
	public static int numDecades;
	private ArrayList<NameRecord> records = new ArrayList<NameRecord>();
	
	public Names (Scanner file) {
		baseDecade = file.nextInt();
		numDecades = file.nextInt();
		
		NameRecord temp;
		while (file.hasNextLine()) {
			temp = new NameRecord(file.nextLine());
			if (temp.size() == numDecades) {
				records.add(temp);
			}
		}
	}

	
	/**
	 * A method that returns the NameRecord whose name is equal to a given String ignoring case.
	 * @param 
	 * @return a NameRecord whose name equals to a given name ignoring case
	 */
	public NameRecord searchOneName (String name) {
		NameRecord result = null;

		for (NameRecord record : records) {
			if (name.equalsIgnoreCase(record.getName())) {
				result = record;
			}
		}
		return result;
	}
	
    /**
     * Returns an ArrayList of NameRecord objects that contain a 
     * given substring, ignoring case.  The names must be in sorted order based 
     * on name.
     * @param partialName != null, partialName.length() > 0
     * @return an ArrayList of NameRecords whose names contains
     * partialName. If there are no NameRecords that meet this
     * criteria returns an empty list. 
     */
	
    public ArrayList<NameRecord> getMatches(String partialName) {
        ArrayList<NameRecord> result = new ArrayList<NameRecord> ();
        
        String name;
        for (NameRecord record : records) {
        	name = record.getName();
        	if (name.toLowerCase().contains(partialName.toLowerCase())) {
        		result.add(record);
        	}
        }
        return result;
    }

    /**
     * Returns an ArrayList of Strings of names that have been ranked in the
     * top 1000 or better for every decade. The Strings  must be in sorted 
     * order based on name. 
     * @return A list of the names that have been ranked in the top
     * 1000 or better in every decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list.
     */
    
    public ArrayList<String> rankedEveryDecade() {
        ArrayList<String> result = new ArrayList<String> ();
        
        for (NameRecord record : records) {
        	if (record.everyDecadeInTop()) {
        		result.add(record.getName());
        	}
        }
        return result;
    }

    /**
     * Returns an ArrayList of Strings of names that have been ranked in the 
     * top 1000 or better in exactly one decade. The Strings must be in sorted 
     * order based on name. 
     * @return A list of the names that have been ranked in the top
     * 1000 or better in exactly one decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list.
     */
    public ArrayList<String> rankedOnlyOneDecade() {
        ArrayList<String> result = new ArrayList<String> ();
        
        for (NameRecord record : records) {
        	if (record.oneDecadeInTop()) {
        		result.add(record.getName());
        	}
        }
        return result;
    }

    /**
     * Returns an ArrayList of Strings of names that have been getting more
     * popular every decade. The Strings  must be in sorted order based on name.
     * @return A list of the names that have been getting more popular in
     * every decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list. 
     */
    public ArrayList<String> alwaysMorePopular() {
    	ArrayList<String> result = new ArrayList<String> ();
    	
        for (NameRecord record : records) {
        	if (record.morePopular()) {
        		result.add(record.getName());
        	}
        }
        return result;
    }

    /**
     * Returns an ArrayList of Strings of names that have been getting less
     * popular every decade. The Strings  must be in sorted order based on name.
     * @return A list of the names that have been getting less popular in
     * every decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list. 
     */
    public ArrayList<String> alwaysLessPopular() {
    	ArrayList<String> result = new ArrayList<String> ();
    	
        for (NameRecord record : records) {
        	if (record.lessPopular()) {
        		result.add(record.getName());
        	}
        }
        return result;
    }
 
}
