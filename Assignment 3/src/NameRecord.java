//  NameRecord.java - CS314 Assignment 3

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

public class NameRecord {
	
	private final int baseDecade = Names.baseDecade;
	private final int numDecades = Names.numDecades;
	public String name;
	public ArrayList<Integer> ranks = new ArrayList<Integer> (numDecades);
	
	//Constructor to create a new NameRecord 
	
	public NameRecord (String data) {
		
		String[] parsedData = data.split("\\s+");

		name = parsedData[0];

		for (int i = 1; i < parsedData.length; i++) {
			ranks.add(Integer.parseInt(parsedData[i]));
		}
	}
	
	public String getName() {
		return this.name;
	}

	public int baseDecade() {
		return this.baseDecade;
	}

	public int rankOfDecade(int givenDecade) {
		return ranks.get((givenDecade - ranks.size())/10);
	}

	public int bestDecade() {
		int min = 1000;
		int index = 0;
		for (Integer rank : ranks) {
			if (rank != 0 && rank < min) {
				min = rank;
				index = ranks.indexOf(min);
			}
		}
		return index * 10 + baseDecade;
	}
	
	public int decadesInTop () {
		int result = 0;
		for (Integer rank : ranks) {
			if (rank != 0 && rank <= 1000) {
				result ++;
			}
		}

		return result;
	}
	
	public boolean everyDecadeInTop() {
		if (decadesInTop() == ranks.size()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean oneDecadeInTop() {
		if (this.decadesInTop() == 1)
			return true;
			else return false;
	}
	
	public boolean morePopular() {
		boolean result = true;
		for (int index = 1; index < ranks.size(); index ++) {
			if ((ranks.get(index) > ranks.get(index - 1) && ranks.get(index) != 0)
					|| (ranks.get(index) == 0))
				result = false;			
		}
		return result;
	}
	
	public boolean lessPopular() {
		boolean result = true;
	
		for (int index = ranks.size() - 1; index > 0; index --) {
			if (ranks.get(index) < ranks.get(index - 1) || ranks.get(index) == 0) {
				result = false;			
			}
		}
		
		return result;
	}
	
	public String toString() {
		String result = name + "\n";
		for (int index = 0; index < ranks.size(); index ++) {
			result += ranks.size() + index * 10 + ": " + ranks.get(index) + "\n";
			System.out.println(baseDecade + index * 10 + ": " + this.ranks.get(index));
		}
		return result;
	}

	public int size() {
		return ranks.size();
	}
}
