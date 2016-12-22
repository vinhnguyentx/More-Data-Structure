// Experiment results. CS314 students, place your experiment
// results here:
/**
 *  The operations are faster when using my LinkedList: adding at front, removing from front
 *  The operations are faster when using Java ArrayList class: getting random, getting all using Iterator
 *  															getting all using get method.
 *  The operations are about the same: adding at end
 * 
 * ---- the Big O
 * 
 * adding at end:
 * 	ArrayList: O(N) because 0.388/0.191 ~ 200000/100000 or 0.832/0.388 ~ 400000/200000
 * 	LinkedList: O(N) because 1.17/0.6 ~ 800000/400000
 * adding at front:
 * 	ArrayList: O(N^2) because 56.007/13.380 ~ 4 = (80000/40000)^2 or 267.57/56.007 ~ 4 = (160000/80000)^2
 * 	LinkedList: O(N) because 0.209/0.102 ~ 2 = 160000/80000 or 0.102/0.055 ~ 2 = 80000/40000
 * removing from front
 * 	ArrayList: O(N^2) because 268.52/56.09 ~ 4 = (160000/80000)^2 or 56.09/13.38 ~ 4 = (80000/40000)^2
 * 	LinkedList: O(N) because .509/255 ~ 2 = 160000/80000 or .255/.126 ~ 2 = 80000/40000
 * getting random
 * 	ArrayList: O(N) because 0.277/0.119 ~ 2 = 80000/40000 or 0.119/0.052 ~ 2 = 40000/20000
 * 	LinkedList: O(N^2) because 846.12/192 ~ 4 = (80000/40000)^2 or 192.21/46.86 ~ 4 = (40000/20000)^2
 * getting all using iterator:
 * 	ArrayList: O(N) because 0.0399/0.0198 ~ 2 = 160000/80000 or 0.017/0.009 ~ 2 = 40000/20000
 * 	LinkedList: O(N) because 0.769/0.0473 ~ 2 = 1600000/80000 or 0.473/0.026 ~ 2 = 80000/40000
 * getting all using get method
 * 	ArrayList: O(N) because 0.0289/0.0124 ~ 2 = 160000/80000
 * 	LinkedList: O(N^2) because 3890.181/802.945 ~ 4 = 160000/80000 or 802.945/183.973 ~ 4 = 80000/40000
 * 
Adding at end: ArrayList
N = 50000, time: 0.11449932400000001
N = 100000, time: 0.191607503
N = 200000, time: 0.38865922100000005
N = 400000, time: 0.8320579600000001
N = 800000, time: 1.476130617


Adding at end: LinkedList
N = 50000, time: 0.06882446
N = 100000, time: 0.15091810600000002
N = 200000, time: 0.23761793800000008
N = 400000, time: 0.600828956
N = 800000, time: 1.1719645199999995


Adding at front: ArrayList
N = 10000, time: 0.66084981
N = 20000, time: 3.1958138360000006
N = 40000, time: 13.38092975
N = 80000, time: 56.007321602
N = 160000, time: 267.57073261700015


Adding at front: LinkedList
N = 10000, time: 0.01760895799999999
N = 20000, time: 0.031660885000000014
N = 40000, time: 0.05538925100000001
N = 80000, time: 0.102361374
N = 160000, time: 0.20968055


Removing from front: ArrayList
N = 10000, time: 0.6220614529999999
N = 20000, time: 3.1507471949999997
N = 40000, time: 13.379875712999999
N = 80000, time: 56.094085691
N = 160000, time: 268.5210937189999


removing from front: LinkedList
N = 10000, time: 0.023325406999999996
N = 20000, time: 0.05718317799999999
N = 40000, time: 0.126078588
N = 80000, time: 0.254862321
N = 160000, time: 0.5095528410000001


Getting random: ArrayList
N = 10000, time: 0.024655681999999995
N = 20000, time: 0.05254129700000001
N = 40000, time: 0.118837758
N = 80000, time: 0.277446065
N = 160000, time: 0.74120801


Getting random: LinkedList
N = 10000, time: 11.398522648999998
N = 20000, time: 46.858043897000016
N = 40000, time: 192.21493558300006
N = 80000, time: 846.1247617050001
N = 160000, time: 4296.047781159002


Getting all using iterator: ArrayList
N = 10000, time: 0.005701713000000002
N = 20000, time: 0.00977463200000001
N = 40000, time: 0.01759513599999999
N = 80000, time: 0.019855823000000005
N = 160000, time: 0.039986091


Getting all using iterator: LinkedList
N = 10000, time: 0.008421604000000004
N = 20000, time: 0.014522711999999995
N = 40000, time: 0.026419696000000003
N = 80000, time: 0.047375076000000016
N = 160000, time: 0.07694618699999997


Getting all using get method: ArrayList
N = 10000, time: 0.003802480999999996
N = 20000, time: 0.00658573799999999
N = 40000, time: 0.013432081999999984
N = 80000, time: 0.012418643000000002
N = 160000, time: 0.028958401


Getting all using get method: LinkedList
N = 10000, time: 11.037458989999998
N = 20000, time: 45.50717389200001
N = 40000, time: 183.973547279
N = 80000, time: 802.9458133890001
N = 160000, time: 3890.1818636559974
 * 
 */

import java.util.Iterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Arrays;

public class OtherLinkedListTester {

    public static void main(String[] args) {
    	
    	 LinkedList<String> list = new LinkedList<String>();
    	 int testNum = 1;
    	 boolean success;
    	 // test 1 toString
    	 success = list.toString().equals("[]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 2 toString
    	 list.insert(list.size(), "A");
    	 success = list.toString().equals("[A]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 3 toString
    	 list.insert(list.size(), "C");
    	 success = list.toString().equals("[A, C]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 4 toString
    	 list.insert(1, "B");
    	 success = list.toString().equals("[A, B, C]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 5 insert
    	 list.insert(0, "D");
    	 success = list.toString().equals("[D, A, B, C]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 6 insert
    	 list.insert(list.size() - 1, "E");
    	 success = list.toString().equals("[D, A, B, E, C]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 7 insert
    	 list.insert(1, "F");
    	 success = list.toString().equals("[D, F, A, B, E, C]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 8 size
    	 success = list.size() == 6;
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 9 set
    	 list.set(0, "SET");
    	 success = list.toString().equals("[SET, F, A, B, E, C]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 10 set
    	 list.set(list.size() - 1, "SET");
    	 success = list.toString().equals("[SET, F, A, B, E, SET]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 11 set
    	 list.set(3, "SET");
    	 success = list.toString().equals("[SET, F, A, SET, E, SET]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 12 add
    	 list.add("new1");
    	 success = list.toString().equals("[SET, F, A, SET, E, SET, new1]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 13 add
    	 list.add("new2");
    	 success = list.toString().equals("[SET, F, A, SET, E, SET, new1, new2]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 14 add
    	 list.add("new3");
    	 success = list.toString().equals("[SET, F, A, SET, E, SET, new1, new2, new3]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 15 get
    	 String str = list.get(0);
    	 success = str.equals("SET");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 16 get
    	 str = list.get(list.size() - 1);
    	 success = str.equals("new3");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 17 get
    	 str = list.get(4);
    	 success = str.equals("E");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 18 remove pos
    	 list.remove(list.size() - 1);
    	 success = list.toString().equals("[SET, F, A, SET, E, SET, new1, new2]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 19 remove pos
    	 list.remove(0);
    	 success = list.toString().equals("[F, A, SET, E, SET, new1, new2]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 20 remove pos
    	 list.remove(4);
    	 success = list.toString().equals("[F, A, SET, E, new1, new2]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 21 remove E
    	 list.remove("F");
    	 success = list.toString().equals("[A, SET, E, new1, new2]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 22 remove E
    	 list.remove("new1");
    	 success = list.toString().equals("[A, SET, E, new2]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 23 remove E
    	 list.remove("SET");
    	 success = list.toString().equals("[A, E, new2]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 24 indexOf
    	 int index = list.indexOf("A");
    	 success = index == 0;
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 25 indexOf
    	 index = list.indexOf("new2");
    	 success = index == 2;
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 26 indexOf
    	 index = list.indexOf("nutsack");
    	 success = index == -1;
    	 success = printResults(success, testNum);
    	 testNum++;

    	 list.add("A");
    	 list.add("B");
    	 list.add("C");
    	 list.add("D");
    	 list.add("E");
    	 list.add("end");

    	 // test 27 getSublist
    	 IList<String> sublist = list.getSubList(0, list.size());
    	 success = sublist.toString().equals(list.toString());
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 28 getSublist
    	 sublist = list.getSubList(0, 3);
    	 success = sublist.toString().equals("[A, E, new2]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 29 getSublist
    	 sublist = list.getSubList(3, list.size());
    	 success = sublist.toString().equals("[A, B, C, D, E, end]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 30 indexOf E
    	 index = list.indexOf("A");
    	 success = index == 0;
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 31 indexOf E
    	 index = list.indexOf("E");
    	 success = index == 1;
    	 success = printResults(success, testNum);
    	 testNum++;
    	 // test 32 indexOf E, pos
    	 index = list.indexOf("A", 1);
    	 success = index == 3;
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 33 indexOf E, pos
    	 index = list.indexOf("E", 3);
    	 success = index == 7;
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 34 indexOf E, pos
    	 index = list.indexOf("new2", 3);
    	 success = index == -1;
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 35 makeEmpty
    	 list.makeEmpty();
    	 success = list.toString().equals("[]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 36 size
    	 success = list.size() == 0;
    	 success = printResults(success, testNum);
    	 testNum++;

    	 list.add("A");
    	 list.add("B");
    	 list.add("C");
    	 list.add("D");
    	 list.add("E");
    	 list.add("F");

    	 // test 37 equal
    	 sublist = list.getSubList(0, list.size());
    	 success = sublist.equals(list);
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 38 iterator next
    	 Iterator<String> it = list.iterator();
    	 success = it.next().equals("A");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 39 iterator remove
    	 it.remove();
    	 success = list.toString().equals("[B, C, D, E, F]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 40 - 41 hasNext and remove
    	 while (it.hasNext()) {
    	 it.next();
    	 it.remove();
    	 }
    	 success = list.toString().equals("[]");
    	 success = printResults(success, testNum);
    	 testNum++;
    	 testNum++;

    	 // test 42 hasNext
    	 success = !it.hasNext();
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 43 hasNext
    	 list.add("A");
    	 it = list.iterator();
    	 success = it.hasNext();
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 44 remove
    	 it.next();
    	 it.remove();
    	 success = list.toString().equals("[]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 45 remove
    	 success = list.size() == 0;
    	 success = printResults(success, testNum);
    	 testNum++;


    	 // test 46 illegal next
    	 try {
    	 it.next();
    	 } catch (NoSuchElementException e) {
    	 success = printResults(true, testNum);
    	 }
    	 testNum++;

    	 // test 47 removeRange
    	 sublist.removeRange(0, 0);
    	 success = sublist.toString().equals("[A, B, C, D, E, F]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 48 removeRange
    	 sublist.removeRange(0, 1);
    	 success = sublist.toString().equals("[B, C, D, E, F]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 49 removeRange
    	 sublist.removeRange(sublist.size() - 1, sublist.size());
    	 success = sublist.toString().equals("[B, C, D, E]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 50 removeRange
    	 sublist.removeRange(1, 3);
    	 success = sublist.toString().equals("[B, E]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 51 removeRange
    	 sublist.removeRange(0, sublist.size());
    	 success = sublist.toString().equals("[]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 52 addFirst
    	 list.addFirst("F");
    	 success = list.toString().equals("[F]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 53 addFirst
    	 list.addFirst("E");
    	 success = list.toString().equals("[E, F]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 54 addFirst
    	 list.addFirst("D");
    	 success = list.toString().equals("[D, E, F]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 55 addLast
    	 list.addLast("F");
    	 success = list.toString().equals("[D, E, F, F]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 56 addLast
    	 list.addLast("E");
    	 success = list.toString().equals("[D, E, F, F, E]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 57 addLast
    	 list.addLast("D");
    	 success = list.toString().equals("[D, E, F, F, E, D]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 58 removeFirst
    	 list.removeFirst();
    	 success = list.toString().equals("[E, F, F, E, D]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 59 removeFirst
    	 list.removeFirst();
    	 success = list.toString().equals("[F, F, E, D]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 60 removeFirst
    	 list.removeFirst();
    	 success = list.toString().equals("[F, E, D]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 61 removeLast
    	 list.removeLast();
    	 success = list.toString().equals("[F, E]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 62 removeLast
    	 list.removeLast();
    	 success = list.toString().equals("[F]");
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 63 removeLast
    	 list.removeLast();
    	 success = list.toString().equals("[]");
    	 success = printResults(success, testNum);
    	 testNum++;


    	 // test 64 equals
    	 success = list.equals(sublist);
    	 success = printResults(success, testNum);
    	 testNum++;

    	 list.add("~");

    	 // test 65 equals
    	 success = !list.equals(sublist);
    	 success = printResults(success, testNum);
    	 testNum++;

    	 // test 66 equals
    	 success = sublist.equals(new LinkedList<Integer>());
    	 success = printResults(success, testNum);
    	 testNum++;
    	 
    	 list.add("A");
    	 list.add("B");
    	 list.add("C");
    	 list.add("D");
    	 list.add("E");
    	 list.add("F");
    	 
    	 // test 67 getNode(int pos)
    	 success = list.getNode(0).getData() == "~";
    	 success = printResults(success, testNum);
    	 testNum++;
    	 
    	 // test 68 getNode(int pos)
    	 success = list.getNode(list.size()-1).getData() == "F";
    	 success = printResults(success, testNum);
    	 testNum++;
    	 
    	 // test 69 getNode(int pos)
    	 success = list.getNode(5).getData() == "E";
    	 success = printResults(success, testNum);
    	 testNum++;
   	 
    	// test 70 getNode(E item)
    	 success = list.getNode("~") == list.getNode(0);
    	 success = printResults(success, testNum);
    	 testNum++;
    	 
    	 // test 71 getNode(int pos)
    	 success = list.getNode("F") == list.getNode(list.size()-1);
    	 success = printResults(success, testNum);
    	 testNum++;
    	 
    	 // test 72 getNode(int pos)
    	 success = list.getNode("D") == list.getNode(4);
    	 success = printResults(success, testNum);
    	 testNum++;
    	 
    	
        //CS314 students. Add your tests here:

        // CS314 Students:
        // uncomment the following line to run tests comparing
        // your LinkedList class to the java ArrayList class.
        //comparison();
    }

    // returns false to reset success each time. No real reason, just saves a line of code each time
    private static boolean printResults(boolean success, int testNum) {
     System.out.println("Test " + testNum + (success ? " passed" : " FAILED"));
     return false;
     }
    
    private static Object[] toArray(LinkedList<String> list) {
        Object[] result = new Object[list.size()];
        Iterator<String> it = list.iterator();
        int index = 0;
        while( it.hasNext() ){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    //pre: none
    private static boolean arraysSame(Object[] one, Object[] two)  {
        boolean same;
        if( one == null || two == null ) {
            same = (one == two);
        }
        else {
            //neither one or two are null
            assert one != null && two != null;
            same = one.length == two.length;
            if( same ) {
                int index = 0;
                while( index < one.length && same ) {
                    same = ( one[index].equals(two[index]) );
                    index++;
                }
            }
        }
        return same;
    }

    // A method to be run to compare the LinkedList you are completing and the Java ArrayList class
    public static void comparison(){
        Stopwatch s = new Stopwatch();
        int initialN = 50000;
        int numTests = 5;


        addEndArrayList(s, initialN, numTests);
        addEndLinkedList(s, initialN, numTests);

        initialN = 10000;
        addFrontArrayList(s, initialN, numTests);
        addFrontLinkedList(s, initialN, numTests);

        removeFrontArrayList(s, initialN, numTests);
        removeFrontLinkedList(s, initialN, numTests);

        getRandomArrayList(s, initialN, numTests);
        getRandomLinkedList(s, initialN, numTests);

        getAllArrayListUsingIterator(s, initialN, numTests);
        getAllLinkedListUsingIterator(s, initialN, numTests);

        getAllArrayListUsingGetMethod(s, initialN, numTests);
        getAllLinkedListUsingGetMethod(s, initialN, numTests);

    }
    
    private static final int NUM_REPEATS = 100;
    
    // These pairs of method illustarte a failure to use polymorphism
    // If the students had implemented the Java list interface there
    // could be a single method. Also we could use function objects to
    // reduce the awful repitition of code.
    public static void addEndArrayList(Stopwatch s, int initialN, int numTests){

        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<Integer>();
                s.start();
                for(int j = 0; j < n; j++)
                    javaList.add(j);
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at end: ArrayList", totalTimes, initialN);
    }
    
    private static void showResults(String title, double[] times, int initialN) {
        System.out.println();
        System.out.println(title);
        for(double time : times) {
            System.out.println("N = " + initialN + ", time: " + time);
            initialN *= 2;
        }
        System.out.println();
    }

    public static void addEndLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                LinkedList<Integer> studentList = new LinkedList<Integer>();
                s.start();
                for(int j = 0; j < n; j++)
                    studentList.add(j);
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at end: LinkedList", totalTimes, initialN);
    }

    public static void addFrontArrayList(Stopwatch s, int initialN, int numTests){
        
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<Integer>();
                s.start();
                for(int j = 0; j < n; j++)
                    javaList.add(0, j);
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at front: ArrayList", totalTimes, initialN);
    }

    public static void addFrontLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                LinkedList<Integer> studentList = new LinkedList<Integer>();
                s.start();
                for(int j = 0; j < n; j++)
                    studentList.insert(0, j);
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at front: LinkedList", totalTimes, initialN);
    }

    public static void removeFrontArrayList(Stopwatch s, int initialN, int numTests){     
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                ArrayList<String> javaList = new ArrayList<String>();
                for(int j = 0; j < n; j++)
                    javaList.add(j + "");
                s.start();
                while(!javaList.isEmpty())
                    javaList.remove(0);
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Removing from front: ArrayList", totalTimes, initialN);
    }

    public static void removeFrontLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS; t++) {
            int n = initialN;    
            for(int i = 0; i < numTests; i++){
                LinkedList<String> studentList = new LinkedList<String>();
                for(int j = 0; j < n; j++)
                    studentList.add(j + "");
                s.start();
                while( studentList.size() != 0 )
                    studentList.removeFirst();
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("removing from front: LinkedList", totalTimes, initialN);
    }

    public static void getRandomArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS; t++) {
            int n = initialN;
            int total = 0;
            Random r = new Random();
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<Integer>();
                for(int j = 0; j < n; j++)
                    javaList.add(j);
                s.start();
                for(int j = 0; j < n; j++){
                    total += javaList.get( r.nextInt(n) );
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting random: ArrayList", totalTimes, initialN);
    }

    public static void getRandomLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS; t++) {
            int n = initialN;
            int total = 0;
            Random r = new Random();
            for(int i = 0; i < numTests; i++){
                LinkedList<Integer> studentList = new LinkedList<Integer>();
                for(int j = 0; j < n; j++)
                    studentList.add(j);
                s.start();
                for(int j = 0; j < n; j++){
                    total += studentList.get( r.nextInt(n) );
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting random: LinkedList", totalTimes, initialN);
    }

    public static void getAllArrayListUsingIterator(Stopwatch s, int initialN, int numTests){
        
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS; t++) {
            int n = initialN;
            int total = 0;
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<Integer>();
                for(int j = 0; j < n; j++)
                    javaList.add(j);
                Iterator<Integer> it = javaList.iterator();
                s.start();
                while( it.hasNext() ){
                    total += it.next();
                }        
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using iterator: ArrayList", totalTimes, initialN);
    }

    public static void getAllLinkedListUsingIterator(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS; t++) {
            int n = initialN;
            int total = 0;
            for(int i = 0; i < numTests; i++){
                LinkedList<Integer> studentList = new LinkedList<Integer>();
                for(int j = 0; j < n; j++)
                    studentList.add(j);
                Iterator<Integer> it = studentList.iterator();
                s.start();
                while(it.hasNext()){
                    total += it.next();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using iterator: LinkedList", totalTimes, initialN);
    }

    public static void getAllArrayListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<Integer>();
                for(int j = 0; j < n; j++)
                    javaList.add(j);

                s.start();
                int x = 0;
                for(int j = 0; j < javaList.size(); j++){
                    x += javaList.get(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using get method: ArrayList", totalTimes, initialN);
    }

    public static void getAllLinkedListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                LinkedList<Integer> studentList = new LinkedList<Integer>();
                for(int j = 0; j < n; j++)
                    studentList.add(j);

                s.start();
                int x = 0;
                for(int j = 0; j < studentList.size(); j++){
                    x += studentList.get(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using get method: LinkedList", totalTimes, initialN);
    }
    
    // for future changes
    private static interface ArrayListOp {
        public void op(ArrayList<?> list);
    }
    
    private static interface LinkedListOp<E> {
        public void op(LinkedList<E> list);
    }
}
//