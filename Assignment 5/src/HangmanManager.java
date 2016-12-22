/*  Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name:
 *  email address:
 *  UTEID:
 *  Section 5 digit ID: 
 *  Grader name:
 *  Number of slip days used on this assignment:
 */

// add imports as necessary

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;


public class HangmanManager {

    // instance vars
    ArrayList<String> dictionary;
    ArrayList<String> activeWords = new ArrayList<String> ();
    ArrayList<Character> guessedCharcaters = new ArrayList<Character> ();
    
    int wordLength;
    int difficulty;
    int numGuessesLeft;
    String pattern;
    
    // pre: words != null, words.size() > 0
    // if debugOn = true, debuggin output is added
    public HangmanManager(List<String> words, boolean debugOn) {
    	dictionary = new ArrayList<String> (words.size());
    	for (String s : words) {
    		dictionary.add(s);
    	}
    	pattern = getPattern();
    }
    
    // pre: words != null, words.size() > 0
    // debuggin output is not added
    public HangmanManager(List<String> words) {
    	dictionary = new ArrayList<String> (words.size());
    	for (String s : words) {
    		dictionary.add(s);
    	}
    }
    

    public int numWords(int length) {
    	int numWords = 0;
    	for (String s : dictionary) {
    		if (s.length() == length) {
    			numWords ++;
    		}
    	}
        return numWords;
    }


    //pre: numWords(wordLen) > 0, numGuesses >= 1, diff = HangmanMain.EASY,
    //HangmanMain.MEDIUM, or HangmanMain.HARD
    public void prepForRound(int wordLen, int numGuesses, int diff) {
    	if (numWords(wordLen) <= 0 || numGuesses < 1 || !(diff == HangmanMain.EASY 
    			|| diff == HangmanMain.MEDIUM || diff == HangmanMain.HARD)) {
    		throw new IllegalStateException ("Violation the precondition:  The input data is invalid");
    	}
    	wordLength = wordLen;
    	numGuessesLeft = numGuesses;
    	difficulty = diff;
    	   	
    	activeWords.clear();
    	guessedCharcaters.clear();
    	pattern = createPattern();
    	
    	for (String s : dictionary) {
    		if (s.length() == wordLength) {
    			activeWords.add(s);
    		}
    	}
    }
    
    public String createPattern() {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < wordLength; i ++) {
    		sb.append('-');
    	}
    	return sb.toString();
    }
    
      
    public int numWordsCurrent() {
        return activeWords.size();
    }
    

    public int getGuessesLeft() {
        return numGuessesLeft;
    }
    
    
    public String getGuessesMade() {
    	ArrayList<Character> guessesMade = new ArrayList<Character>();
    	for (int i = 0; i < guessedCharcaters.size(); i ++) {
    		guessesMade.add(guessedCharcaters.get(i));
    	}
    	Collections.sort(guessesMade);
        return guessesMade.toString();
    }
    
    
    public boolean alreadyGuessed(char guess) {
    	for (int i = 0; i < guessedCharcaters.size(); i ++) {
    		if (guess == guessedCharcaters.get(i)) {
    			return true;
    		}
    	}
        return false;
    }
    
    
    public String getPattern() {
        return pattern;
    }
    

    public String getSecretWord() {
    	if (numWordsCurrent() == 0) {
    		throw new IllegalStateException ("There is no word matching!");
    	} else if (numWordsCurrent() == 1) {
    		return activeWords.get(0);
    	} else {
    		Random r = new Random();
    		return activeWords.get(r.nextInt(activeWords.size()));
    	}
    }
    
    // pre: !alreadyGuessed(ch)
    // post: return a tree map with the resulting patterns and the number of
    // words in each of the new patterns.
    // the return value is for testing and debugging purposes
    public TreeMap<String, Integer> makeGuess(char guess) {
    	if (alreadyGuessed(guess)) {
    		throw new IllegalStateException ("Violation of precondition: " 
    				+ "The character has already been guessed");
    	}
    	numGuessesLeft--;
    	guessedCharcaters.add(guess);

    	TreeMap<String, ArrayList<String>> listOfPatternsWords = updateActiveWords(guess);
    	TreeMap<String, Integer> listOfPatternsInts = groupActiveWordsAndCount(listOfPatternsWords); 
    	String newPattern = getLargestNumWords(listOfPatternsInts, guess);

    	if (listOfPatternsInts.size() > 1) {
    		TreeMap<String, Integer> TreeMapRemoveMax = new TreeMap<String, Integer>();
    		TreeMapRemoveMax.putAll(listOfPatternsInts);
    		TreeMapRemoveMax.remove(newPattern);
    		newPattern = getLargestNumWords(TreeMapRemoveMax, guess);
    	}

    	if (pattern.equals(newPattern)) 
    		numGuessesLeft--;
    	pattern = newPattern;
    	activeWords = listOfPatternsWords.get(pattern);

    	return listOfPatternsInts;
    }


    //get a list with the largest number of words, if tie, choose fewest total revealed character, if still
    // tie, choose "smallest" based on the ASCIIbetical
    private String getLargestNumWords(
    		TreeMap<String, Integer> listOfPatternsInts, char guess) {	
    	String key = getKeyHasMaxValue(listOfPatternsInts);
    	int countKey = 0;
    	int countKeyTemp = 0;
    	int max = listOfPatternsInts.get(key);
    	if (listOfPatternsInts.containsValue(max)) {
    		for (Entry<String, Integer> entry : listOfPatternsInts.entrySet()) {
    			countKeyTemp = entry.getKey().replaceAll("-", "").length();
    			countKey = key.replaceAll("-", "").length();
    			if (entry.getValue() == max) {
    				if (countKeyTemp < countKey)
    					key = entry.getKey();
    				else if (countKeyTemp == countKey) {
    					if (key.compareTo(entry.getKey()) > 0)
    						key = entry.getKey();
    				}
    			}
    		}
    	}	
    	return key;
    }


    //get a pattern with maximum number of words
    private String getKeyHasMaxValue(TreeMap<String, Integer> listOfPatternsInts) {
    	int max = 0;
    	String key = "";
    	for (Entry<String, Integer> entry : listOfPatternsInts.entrySet()) {
    		if (max < entry.getValue()) {
    			max = entry.getValue();
    			key = entry.getKey();
    		}
    	}
    	return key;
    }


    //creates the TreeMap for patterns and number of words of these patterns.
    // @return: A TreeMap
    private TreeMap<String, Integer> groupActiveWordsAndCount(TreeMap<String, ArrayList<String>> listOfPatternsWords) {
    	TreeMap<String, Integer> temp = new TreeMap<String, Integer>();
    	for (Entry<String, ArrayList<String>> entry : listOfPatternsWords.entrySet()) {
    		temp.put(entry.getKey(), entry.getValue().size());
    	}
    	return temp;
    }


    //creates a TreeMap to update patterns and words
    private TreeMap<String, ArrayList<String>> updateActiveWords(char guess) {
    	TreeMap<String, ArrayList<String>> temp = new TreeMap<String, ArrayList<String>>();

    	for (int i = 0; i < activeWords.size(); i ++) {
    		String pattern = updatePattern(i, guess);

    		if(temp.containsKey(pattern))
    			temp.get(pattern).add(activeWords.get(i));
    		else {
    			temp.put(pattern, new ArrayList<String>());
    			temp.get(pattern).add(activeWords.get(i));
    		}
    	}	    
    	return temp;
    }


    //update the patterns.
    private String updatePattern(int count, char guess) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < wordLength; i++) {
    		if (activeWords.get(i).charAt(i) == guess) {
    			sb.append(guess);
    		} else if (pattern.charAt(i) != '-') {
    			sb.append(pattern.charAt(i));
    		} else {
    			sb.append('-');		
    		}
    	}
    	return sb.toString();	
    }
    
}
