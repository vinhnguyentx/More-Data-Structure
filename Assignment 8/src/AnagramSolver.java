import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class AnagramSolver {
	
	private Map<String, LetterInventory> wordsMap;

	/**
	 * create and store letter inventory
	 * pre: none
	 * post: return a map contains a key string and their LetterInventory
	 */
	public AnagramSolver(List<String> dict) {
		this.wordsMap = new HashMap<String, LetterInventory> ();

		for (int i = 0; i < dict.size(); i ++) {
			String temp = dict.get(i);
			wordsMap.put(temp, new LetterInventory(temp));
		}
	}

	/**
	 * finding anagrams
	 * pre: String != null, String contains at least 1 letter
	 * post:  return a List<List<String>>
	 */
	public List<List<String>> getAnagrams(String target, int max) {

		if (target == null || target.length() <= 1)
			throw new IllegalArgumentException("Violation of precondition: "
					+ "the String must not be null and contains at least 1 letter.");
		if (max < 0)
			throw new IllegalArgumentException("Violation of precondition: "
					+ "maximum number of words must be greater than or equal to 0.");

		LetterInventory wordInventory = new LetterInventory(target);
		List<List<String>> anagrams = new ArrayList<List<String>>();
		LinkedList<String> emptyList = new LinkedList<String>();
		Set<String> possibleAnagrams = new TreeSet<String>();

		//
		for (Map.Entry<String, LetterInventory> dictEntry : this.wordsMap.entrySet()) {
			if (wordInventory.subtract(dictEntry.getValue()) != null) {
				possibleAnagrams.add(dictEntry.getKey());
			}
		}

		List<String> potentialList = new ArrayList<String>(possibleAnagrams);

		computeAnagrams(potentialList, anagrams, (max == 0) ? -1 : max, emptyList, wordInventory, 0);
		Collections.sort(anagrams, new AnagramComparator());

		return anagrams;
	}


	private void computeAnagrams(List<String> possibleAnagrams, List<List<String>> anagrams,
			int max, LinkedList<String> currentWords, LetterInventory currentInvent, int index) {		
		if (max == 0 || currentInvent.isEmpty()) {
			if (currentInvent.isEmpty()) {
				List<String> valid = new ArrayList<String>(currentWords);
				Collections.sort(valid);

				if (!anagrams.contains(valid)) {
					anagrams.add(valid);
				}
			}
		} else {

			for (int i = index; i < possibleAnagrams.size(); i++) {
				String newCurrentWord = possibleAnagrams.get(i);
				LetterInventory newCurrentInventory = this.wordsMap.get(newCurrentWord);
				LetterInventory difference = currentInvent.subtract(newCurrentInventory);

				if (difference != null) {
					currentWords.addLast(newCurrentWord);
					computeAnagrams(possibleAnagrams, anagrams, max - 1, currentWords, difference, i + 1);
					currentWords.removeLast();
				}
			}
		}
	}

	private static class AnagramComparator implements Comparator<List<String>> {

		public int compare(List<String> listStr1, List<String> listStr2) {
			int size1 = listStr1.size();
			int size2 = listStr2.size();

			int temp = 0;
			
			if (size1 != size2) {
				return size1 - size2;
			} else {
				for (int index = 0; index < size1; index ++) {
					temp = listStr1.get(index).compareTo(listStr2.get(index));
					if (temp != 0) {
						return temp;
					}
				}
			}
			return temp;
		}
	}

//	 private static class AnagramComparator implements Comparator<List<String>> {
//	        public int compare(List<String> a1, List<String> a2) {
//	        	int temp = 0;
//	            if (a1.size() < a2.size())
//	            	return a1.size() - a2.size();
//	            else if (a1.size() > a2.size())
//	            	return a1.size()- a2.size();
//	            else {
//	            	for (int i = 0; i < a1.size(); i++) {
//	            		temp = a1.get(i).compareTo(a2.get(i));
//	            		if (a1.get(i).compareTo(a2.get(i)) != 0)
//	            			return temp;
//	            	}
//	            }
//				return temp;
//	        }
//	 }

	//	/*
	//	 * return words that possibly appear in anagrams
	//	 * pre: noe
	//	 * post: return words possibly appear in anagrams
	//	 */
	//	private HashMap<String, LetterInventory> getPossibleWords(LetterInventory words) {
	//		HashMap<String, LetterInventory> possibleWordMap = new HashMap<String, LetterInventory> ();
	//		LetterInventory temp = new LetterInventory();
	//		for (String s : wordsMap.keySet()) {
	//			temp = wordsMap.get(s);
	//			
	//			if (words.subtract(temp) != null) {
	//				possibleWordMap.put(s, temp);
	//			}
	//		}
	//		return possibleWordMap;
	//	}
}
