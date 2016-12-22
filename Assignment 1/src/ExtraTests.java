import java.util.Random;
public class ExtraTests {
	
	 
	
	 
	    public static void main(String[] args) {
	        final String newline = System.getProperty("line.separator");
	       
	        // test 4, hamming distance
	        int[] h1 = {Integer.MAX_VALUE};
	        int[] h2 = {Integer.MIN_VALUE};
	        int expected = 1;
	        int actual = CodeCamp.hammingDistance(h1, h2);
	       
	        System.out.println("Test 4 hamming distance: expected value: "
	                + expected + ", actual value: " + actual);
	        if (expected == actual) {
	                System.out.println(" passed test 4, hamming distance");
	        } else {
	                System.out.println(" ***** FAILED ***** test 4, hamming distance");
	        }
	       
	        // test 5, hamming distance, empty list
	        h1 = new int[] {};
	        h2 = new int[] {};
	        expected = 0;
	        actual = CodeCamp.hammingDistance(h1, h2);
	       
	        System.out.println(newline + "Test 5 hamming distance: expected value: "
	                + expected + ", actual value: " + actual);
	        if (expected == actual) {
	                System.out.println(" passed test 5, hamming distance");
	        } else {
	                System.out.println(" ***** FAILED ***** test 5, hamming distance");
	        }
	 
	        // test 9, isPermutation, mirror image arrays
	        Random rand = new Random();
	        int[] a = new int[1000];
	        int[] b = new int[1000];
	        /*
	         * give every entry in 'a' a random int and give 'b' the same ints in
	         * reverse order
	         */
	        for (int i = 0, j = 999; i < 1000; i++, j--) {
	                a[i] = rand.nextInt();
	                b[j] = a[i];
	        }
	        boolean expectedBool = true;
	        boolean actualBool = CodeCamp.isPermutation(a, b);
	       
	        System.out.println(newline + "Test 9 isPermutation: expected value: "
	                + expectedBool + ", actual value: " + actualBool);
	        if (expectedBool == actualBool) {
	                System.out.println(" passed test 9, isPermutation");           
	        } else {
	                System.out.println(" ***** FAILED ***** test 9, isPermutation");
	        }  
	       
	        // test 10, isPermutation, mirror image arrays + 1 extra
	        a = new int[1000];
	        b = new int[1001]; // this time we make b a larger array => should return false
	        for (int i = 0, j = 999; i < 1000; i++, j--) {
	                a[i] = rand.nextInt();
	                b[j] = a[i];
	        }
	        expectedBool = false;
	        actualBool = CodeCamp.isPermutation(a, b);
	       
	        System.out.println(newline + "Test 10 isPermutation: expected value: "
	                + expectedBool + ", actual value: " + actualBool);
	        if (expectedBool == actualBool) {
	                System.out.println(" passed test 10, isPermutation");          
	        }
	        else {
	                System.out.println(" ***** FAILED ***** test 10, isPermutation");
	        }  
	       
	        // test 11, isPermutation, empty list
	        a = new int[] {};
	        b = new int[] {};
	        expectedBool = true;
	        actualBool = CodeCamp.isPermutation(a, b);
	       
	        System.out.println(newline + "Test 11 isPermutation: expected value: "
	                + expectedBool + ", actual value: " + actualBool);
	        if (expectedBool == actualBool) {
	                System.out.println(" passed test 11, isPermutation");          
	        } else {
	                System.out.println(" ***** FAILED ***** test 11, isPermutation");
	        }
	       
	        // test 12, isPermutation, single large element
	        a = new int[] {Integer.MAX_VALUE};
	        b = new int[] {Integer.MAX_VALUE};
	        expectedBool = true;
	        actualBool = CodeCamp.isPermutation(a, b);
	       
	        System.out.println(newline + "Test 12 isPermutation: expected value: "
	                + expectedBool + ", actual value: " + actualBool);
	        if (expectedBool == actualBool) {
	                System.out.println(" passed test 12, isPermutation");          
	        } else {
	                System.out.println(" ***** FAILED ***** test 12, isPermutation");
	        }
	 
	        // test 17, queensAreSafe, all safe
	        char[][] board = new char[][]{{'.', '.', 'q', '.'},
	                                      {'q', '.', '.', '.'},
	                                      {'.', '.', '.', 'q'},
	                                      {'.', 'q', '.', '.'}};
	        expectedBool = true;
	        actualBool = CodeCamp.queensAreSafe(board);
	       
	        System.out.println(newline + "Test 17 queensAreSafe: expected value: "
	                        + expectedBool + ", actual value: " + actualBool);
	        if (expectedBool == actualBool) {
	                System.out.println(" passed test 17, queensAreSafe");
	        } else {
	                System.out.println(" ***** FAILED ***** test 17, queensAreSafe");
	        }
	       
	        // test 18, queensAreSafe, diagonal check
	        board = new char[][]{{'.', 'q', '.', '.', '.', '.', '.'},
	                             {'.', '.', '.', '.', '.', 'q', '.'},
	                             {'q', '.', '.', '.', '.', '.', '.'},
	                             {'.', '.', 'q', '.', '.', '.', '.'},
	                             {'.', '.', '.', '.', '.', '.', 'q'},
	                             {'.', '.', '.', '.', '.', '.', '.'},
	                             {'.', '.', '.', '.', 'q', '.', '.'}};
	        expectedBool = false;
	        actualBool = CodeCamp.queensAreSafe(board);
	 
	        System.out.println(newline + "Test 18 queensAreSafe: expected value: "
	                        + expectedBool + ", actual value: " + actualBool);
	        if (expectedBool == actualBool) {
	                System.out.println(" passed test 18, queensAreSafe");
	        } else {
	                System.out.println(" ***** FAILED ***** test 18, queensAreSafe");
	        }
	       
	        // test 19, queensAreSafe, diagonal check
	        board = new char[][]{{'.', 'q', '.', '.', '.', '.', '.'},
	                             {'.', '.', '.', '.', '.', 'q', '.'},
	                             {'q', '.', '.', '.', '.', '.', '.'},
	                             {'.', '.', 'q', '.', '.', '.', '.'},
	                             {'.', '.', '.', '.', '.', '.', 'q'},
	                             {'.', '.', '.', '.', '.', '.', '.'},
	                             {'.', '.', '.', '.', '.', 'q', '.'}};
	        expectedBool = false;
	        actualBool = CodeCamp.queensAreSafe(board);
	 
	        System.out.println(newline + "Test 19 queensAreSafe: expected value: "
	                        + expectedBool + ", actual value: " + actualBool);
	        if (expectedBool == actualBool) {
	                System.out.println(" passed test 19, queensAreSafe");
	        } else {
	                System.out.println(" ***** FAILED ***** test 19, queensAreSafe");
	        }
	       
	        // test 20, queensAreSafe, horizontal check
	        board = new char[][]{{'.', '.', '.', '.'},
	                             {'q', '.', 'q', '.'},
	                             {'.', '.', '.', '.'},
	                             {'.', '.', '.', 'q'}};
	        expectedBool = false;
	        actualBool = CodeCamp.queensAreSafe(board);
	 
	        System.out.println(newline + "Test 20 queensAreSafe: expected value: "
	                        + expectedBool + ", actual value: " + actualBool);
	        if (expectedBool == actualBool) {
	                System.out.println(" passed test 20, queensAreSafe");
	        } else {
	                System.out.println(" ***** FAILED ***** test 20, queensAreSafe");
	        }
	       
	        // test 21, queensAreSafe, vertical check
	        board = new char[][]{{'.', '.', '.', '.'},
	                             {'.', '.', 'q', '.'},
	                             {'q', '.', '.', '.'},
	                             {'.', '.', 'q', '.'}};
	        expectedBool = false;
	        actualBool = CodeCamp.queensAreSafe(board);
	 
	        System.out.println(newline + "Test 21 queensAreSafe: expected value: "
	                        + expectedBool + ", actual value: " + actualBool);
	        if (expectedBool == actualBool) {
	                System.out.println(" passed test 21, queensAreSafe");
	        } else {
	                System.out.println(" ***** FAILED ***** test 21, queensAreSafe");
	        }
	       
	        // test 22, queensAreSafe, no queens
	        board = new char[][]{{'.', '.', '.', '.'},
	                             {'.', '.', '.', '.'},
	                             {'.', '.', '.', '.'},
	                             {'.', '.', '.', '.'}};
	        expectedBool = true;
	        actualBool = CodeCamp.queensAreSafe(board);
	 
	        System.out.println(newline + "Test 22 queensAreSafe: expected value: "
	                        + expectedBool + ", actual value: " + actualBool);
	        if (expectedBool == actualBool) {
	                System.out.println(" passed test 22, queensAreSafe");
	        } else {
	                System.out.println(" ***** FAILED ***** test 22, queensAreSafe");
	        }
	       
	        // test 23, queensAreSafe, single queen
	        board = new char[][]{{'.', '.', '.', '.'},
	                             {'.', 'q', '.', '.'},
	                             {'.', '.', '.', '.'},
	                             {'.', '.', '.', '.'}};
	        expectedBool = true;
	        actualBool = CodeCamp.queensAreSafe(board);
	 
	        System.out.println(newline + "Test 23 queensAreSafe: expected value: "
	                        + expectedBool + ", actual value: " + actualBool);
	        if (expectedBool == actualBool) {
	                System.out.println(" passed test 23, queensAreSafe");
	        } else {
	                System.out.println(" ***** FAILED ***** test 23, queensAreSafe");
	        }
	       
	        // test 24, getValueOfMostValuable Plot, single block
	        int[][] city = {{0, 12, 15, -32, 58},
	                        {3, -5, -6, -2, 1},
	                        {3, -20, -4, 3, -16},
	                        {-1, 60, 0, -20, 10},
	                        {-10, 0, -1, -5, -6}};
	        expected = 60;
	        actual = CodeCamp.getValueOfMostValuablePlot(city);
	       
	        System.out.println(newline + "Test 24 getValueOfMostValuablePlot: expected value: "
	                + expected + ", actual value: " + actual);
	        if (expected == actual) {
	                System.out.println(" passed test 24, getValueOfMostValuablePlot");
	        } else {
	                System.out.println(" ***** FAILED ***** test 24, getValueOfMostValuablePlot");
	        }
	       
	        // test 25, getValueOfMostValuable Plot, single row
	        city = new int[][] {{0, 0, 0, 0, 0},
	                            {-5, -5, -6, -20, -1},
	                            {3, 22, 14, -3, 16},
	                            {-1, -6, 0, -4, -10},
	                            {0, 0, -1, 0, -2}};
	        expected = 52;
	        actual = CodeCamp.getValueOfMostValuablePlot(city);
	       
	        System.out.println(newline + "Test 25 getValueOfMostValuablePlot: expected value: "
	                + expected + ", actual value: " + actual);
	        if (expected == actual) {
	                System.out.println(" passed test 25, getValueOfMostValuablePlot");
	        } else {
	                System.out.println(" ***** FAILED ***** test 25, getValueOfMostValuablePlot");
	        }
	       
	        // test 26, getValueOfMostValuable Plot, single column
	        city = new int[][] {{0, 0, 42, -5, 2},
	                            {0, -5, -16, -20, -1},
	                            {3, -22, -3, -33, 16},
	                            {-1, -6, 0, -4, -10},
	                            {0, 0, 90, 0, -2}};
	        expected = 113;
	        actual = CodeCamp.getValueOfMostValuablePlot(city);
	       
	        System.out.println(newline + "Test 26 getValueOfMostValuablePlot: expected value: "
	                + expected + ", actual value: " + actual);
	        if (expected == actual) {
	                System.out.println(" passed test 26, getValueOfMostValuablePlot");
	        } else {
	                System.out.println(" ***** FAILED ***** test 26, getValueOfMostValuablePlot");
	        }
	       
	        // test 27, getValueOfMostValuable Plot, 2x3 square
	        city = new int[][] {{0, 0, 42, -5, 2},
	                            {0, -5, -56, -20, -1},
	                            {3, -22, -3, -33, -16},
	                            {-1, -6, 40, -4, -10},
	                            {0, -12, 16, -18, 90}};
	        expected = 114;
	        actual = CodeCamp.getValueOfMostValuablePlot(city);
	       
	        System.out.println(newline + "Test 27 getValueOfMostValuablePlot: expected value: "
	                + expected + ", actual value: " + actual);
	        if (expected == actual) {
	                System.out.println(" passed test 27, getValueOfMostValuablePlot");
	        } else {
	                System.out.println(" ***** FAILED ***** test 27, getValueOfMostValuablePlot");
	        }
	       
	        // test 28, getValueOfMostValuable Plot, entire city
	        city = new int[][] {{123, 0, 42, -5, 2},
	                            {0, -15, -56, -21, 6},
	                            {32, -22, -3, -33, -16},
	                            {-1, -6, 40, -4, -10},
	                            {0, -12, 16, -18, 130}};
	        expected = 169;
	        actual = CodeCamp.getValueOfMostValuablePlot(city);
	       
	        System.out.println(newline + "Test 28 getValueOfMostValuablePlot: expected value: "
	                + expected + ", actual value: " + actual);
	        if (expected == actual) {
	                System.out.println(" passed test 28, getValueOfMostValuablePlot");
	        } else {
	                System.out.println(" ***** FAILED ***** test 28, getValueOfMostValuablePlot");
	        }
	       
	    } // end of main method
	
}
