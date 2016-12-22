import java.util.Random;

//Version 06/19/2014
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

/* CS314 Students. Put your experiment results and
 * answers to questions here.
 
Experiment 1

- The average time for the add operation of two  800 x  800 matrices based on 1000 repetitions: 0.002536799999999999 seconds
- The average time for the add operation of two 1600 x 1600 matrices based on 1000 repetitions: 0.011771657655762398 seconds
- The average time for the add operation of two 3200 x 3200 matrices based on 1000 repetitions: 0.056058926000000016 seconds

Experiment 2

- The average time for the multiply operation of two 200 x 200 matrices based on 1000 repetitions: 0.013475689999999995 seconds
- The average time for the multiply operation of two 400 x 400 matrices based on 1000 repetitions: 0.16089362699999998 seconds
- The average time for the multiply operation of two 800 x 800 matrices based on 1000 repetitions: 1.4962407399999997 seconds

Answer

1. Based on the results of experiment 1, if I doubled the dimension size of the MathMatrix objects again,
I expect an increment of about 4 times of the average time.
	0.011771657655762398/0.002536799999999999 ~ 4.6
	0.056058926000000016/0.011771657655762398 ~ 4.76

2. The Big O of the add operation is O(N^2). My data can prove this (not exactly 100%).

3. Based on the results of experiment 2, if I doubled the dimension size of the MathMatrix objects again,
I expect an increment of about 
	0.16089362699999998/0.013475689999999995 ~ 12
	1.4962407399999997/0.16089362699999998 ~ 9.3

4. The Big O of the multiply operation is O(N^3). My data can not prove this exactly.

5.
Big O of the multiply operation is given two N by N matrices is O(N^3) I don't think my timing data supports this.
0.3222/0.0372 = 8.6612 should be ~ 8 OK
3.3997/0.3222 = 10.5515 should be ~ 8
3.3997/0.0372 = 91.3897 should be ~ 64

The largest matrix can you create before your program runs out of heap memory: 5682x5682 (32285124 elements)
(When using the default heap size. No command line flag to increase heap size.)
Estimate the amount of memory my program is allocated: 32285124*4 = 129140496 bytes


/**
 * A class to run tests on the MathMatrix class
 */
public class MathMatrixTester {

	/**
	 * main method that runs simple test on the MathMatrix class
	 *
	 * @param args not used
	 */
	public static void main(String[] args) {
		int[][] data1 = {{-1, 2, 3},
						 { 8, 6, 2}};
		int[][] data2 = {{ 8,  7,  3},
						 {-2, 43, 11}};
		int[][] data3 = {{ 0, -7, 3},
				 		 {-2, 13, 1},
						 {-2, 13, 1}};
		int[][] data4 = {{ 0, -7},
		 		 		 {-2, 13},
		 		 		 {-2, 13}};
		int[][] e1;

		
//Run Experiments------
        
        //Experiment 1
        //experiment1(800);
        //experiment1(1600);
        //experiment1(3285);
        
        //Experiment 2
        //experiment2(200);
        //experiment2(400);
        experiment2(3284);
        //
		
		
		//Test #1 & 2 - Deep copy
		MathMatrix mat1 = new MathMatrix(data1);
		data1[0][0] = 2;
		
		e1 = new int[][] {{2, 2, 3}, 
						  {8, 6, 2}};
		printTestResult( data1, e1, 1, "Deep copy matrix method of type int[][].");
		
		e1 = new int[][] {{-1, 2, 3}, 
						  {8, 6, 2}};
		printTestResult( get2DArray(mat1), e1, 2, "Deep copy matrix method of type int[][].");

		//Test #3 & 4 - Set to initialVal
		MathMatrix mat2 = new MathMatrix(data2);
		MathMatrix mat3 = new MathMatrix(data3);
		
		e1 = new int[][] {{ 8,  7,  3}, 
				  		  {-2, 43, 11}};
		printTestResult( get2DArray(mat2), e1, 3, "Set to initialVal method.");
		
		e1 = new int[][] {{ 0, -7, 3},
		 		 		  {-2, 13, 1},
		 		 		  {-2, 13, 1}};
		printTestResult( get2DArray(mat3), e1, 4, "Set to initialVal method.");
		
		//Test #5 & 6 - Change Element
		
		e1 = new int[][] {{ 8,  7,  3}, 
				  		  {-2, 43, 11}};
		printTestResult( get2DArray(mat2), e1, 5, "Change Element method.");
		
		e1 = new int[][] {{ 0, -7, 3},
		 		 		  {-2, 13, 1},
		 		 		  {-2, 13, 1}};
		printTestResult( get2DArray(mat3), e1, 6, "Change Element method.");
		
		//Test #7 & 8 - Number of row
		int actual = mat1.numRows();
		int expected = 2;
		if (actual == expected) 
			System.out.println("Test number 7 tests the Number of rows method.. The test passed.");
		else
			System.out.println("Test number 7 tests the Number of rows method.. The test failed.");
		
		actual = mat3.numRows();
		expected = 3;
		if (actual == expected) 
			System.out.println("Test number 8 tests the Number of rows method.. The test passed.");
		else
			System.out.println("Test number 8 tests the Number of rows method.. The test failed.");
		
		//Test #9 & 10 - Number of row
		MathMatrix mat4 = new MathMatrix(data4);
		actual = mat1.numCols();
		expected = 3;
		if (actual == expected) 
			System.out.println("Test number 9 tests the Number of columns method.. The test passed.");
		else
			System.out.println("Test number 9 tests the Number of columns method.. The test failed.");

		actual = mat4.numCols();
		expected = 2;
		if (actual == expected) 
			System.out.println("Test number 10 tests the Number of columns method.. The test passed.");
		else
			System.out.println("Test number 10 tests the Number of columns method.. The test failed.");

		//Test #11 & 12 - Get values
		actual = mat3.getVal(1, 1);
		expected = 13;
		if (actual == expected) 
			System.out.println("Test number 11 tests Get values method.. The test passed.");
		else
			System.out.println("Test number 11 tests Get values method.. The test failed.");

		actual = mat4.getVal(0, 0);
		expected = 0;
		if (actual == expected) 
			System.out.println("Test number 12 tests Get values method.. The test passed.");
		else
			System.out.println("Test number 12 tests Get values method.. The test failed.");

		
		//Test #13 & 14 - Addition
		
		MathMatrix mat13 = new MathMatrix(data2);
		MathMatrix mat14 = mat1.add(mat2);
		
		e1 = new int[][] {{ 8,  7,  3},
				 		  {-2, 43, 11}};
		printTestResult( get2DArray(mat13), e1, 13, "Add method.");
		e1 = new int[][] {{7,  9,  6},
						  {6, 49, 13}};
		printTestResult( get2DArray(mat14), e1, 14, "Add method.");
		
		//Test #15 & 16 - Subtraction

		MathMatrix mat15 = new MathMatrix(data2);
		MathMatrix mat16 = mat1.subtract(mat2);

		e1 = new int[][] {{ 8,  7,  3},
				 		  {-2, 43, 11}};
		printTestResult( get2DArray(mat15), e1, 15, "Subtract method.");
		e1 = new int[][] {{-9, -5, 0},
						  {10,-37,-9}};
		printTestResult( get2DArray(mat16), e1, 16, "Subtract method.");

		//Test #17 & 18 - Multiplication
		int[][] data171 = {{1, 0},
						   {8, 1},
						   {2, 3}};
		int[][] data172 = {{3, 2, 0},
     		   			   {2, 0, 1}};
		mat1 = new MathMatrix(data171);
		mat2 = new MathMatrix(data172);
		
		mat3 = mat2.multiply(mat1);
		e1 = new int[][] {{19, 2},
						  {4, 3}};
		printTestResult( get2DArray(mat3), e1, 17, "Multiply method");
		
		mat4 = mat1.multiply(mat2);
		e1 = new int[][] {{  3,  2, 0},
						  { 26, 16, 1},
						  { 12,  4, 3}};
		printTestResult( get2DArray(mat4), e1, 18, "Multiply method");
		
		//Test #19 & 20 - Transpose
		int[][] data19 = {{1, 0},
				{8, 1},
				{2, 3}};
		int[][] data20 = {{3, 2, 0},
				{2, 0, 1}};
		mat1 = new MathMatrix(data19);
		mat2 = new MathMatrix(data20);

		mat3 = mat1.getTranspose();
		e1 = new int[][] {{1, 8, 2},
						  {0, 1, 3}};
		printTestResult( get2DArray(mat3), e1, 19, "Get Transpose method.");

		mat4 = mat2.getTranspose();
		e1 = new int[][] {{3, 2},
						  {2, 0},
						  {0, 1}};
		printTestResult( get2DArray(mat4), e1, 20, "Get Transpose method.");
		
		//Test #21 & 22 - Equality
		boolean actualTest = mat1.equals(mat2);
		boolean expectedResult = false;
		if (actualTest == expectedResult) 
			System.out.println("Test number 21 tests the Equality.. The test passed.");
		else
			System.out.println("Test number 21 tests the Equality.. The test failed.");
		
		int[][] data22 = {{4, 2, 1},
						  {3, 0, 2}};
		int[][] data23 = {{4, 2, 1},
				  		  {3, 0, 2}};
		MathMatrix mat22 = new MathMatrix(data22);
		MathMatrix mat23 = new MathMatrix(data23);
		actualTest = mat22.equals(mat23);
		expectedResult = true;
		if (actualTest == expectedResult) 
			System.out.println("Test number 22 tests the the Equality.. The test passed.");
		else
			System.out.println("Test number 22 tests the the Equality.. The test failed.");
		
		
		//Test #23 & 24 - ToString
		data1 = new int[][] {{3, 56, 11, -1000},
							 {100, 1000, 5, 4}};
		mat1 = new MathMatrix(data1);
		String expect = "|     3    56    11 -1000|\n"
					  + "|   100  1000     5     4|\n";
		if( mat1.toString().equals( expect ) )
			System.out.println("Test number 23 tests the To String method.. The test passed.");
		else
			System.out.println("Test number 23 tests the To String method.. The test failed.");

		
		data2 = new int[][] {{123456, -3456, 678},
						     {100000, 1000, 55},
						 	 {1, 0, -1000000000}};
		mat2 = new MathMatrix(data2);
		expect = "|      123456       -3456         678|\n"
			   + "|      100000        1000          55|\n"
			   + "|           1           0 -1000000000|\n";
		if( mat2.toString().equals( expect ) )
			System.out.println("Test number 24 tests the To String method.. The test passed.");
		else
			System.out.println("Test number 24 tests the To String method.. The test failed.");

		
		//Test #25 & 26 - UpperTriangular
		data1 = new int[][] {{1, 2, 3, 0}, {7, 3, 2, 3}, {0, 0, 4, -1}, {0, 0, 0, 12}};
		mat1 = new MathMatrix(data1);
		if( !mat1.isUpperTriangular())
			System.out.println("Test number 25 tests the UpperTriangular method.. The test passed.");
		else
			System.out.println("Test number 25 tests the UpperTriangular method.. The test failed.");

		
		data1 = new int[][] {{1, 2, 3, 0}, {0, 3, 2, 3}, {0, 0, 4, -1}, {0, 0, 0, 4}};
		mat1 = new MathMatrix(data1);
		if( mat1.isUpperTriangular())
			System.out.println("Test number 26 tests the UpperTriangular method.. The test passed.");
		else
			System.out.println("Test number 26 tests the UpperTriangular method.. The test failed.");   

	}

	// method that sums elements of mat, may overflow int!
	// pre: mat != null
	private static int sumVals(MathMatrix mat) {
		if(mat == null)
			throw new IllegalArgumentException("mat may not be null");

		int result = 0;
		final int ROWS =  mat.numRows();
		final int COLS = mat.numCols();
		for(int r = 0; r < ROWS; r++)
			for(int c = 0; c < COLS; c++) 
				result += mat.getVal(r, c); // likely to overflow, but can still do simple check
		return result;
	}

	// create a matrix with random values
	// pre: rows > 0, cols > 0, randNumGen != null
	private static MathMatrix createMat(Random randNumGen, int rows,
			int cols, final int LIMIT) {

		if(randNumGen == null)
			throw new IllegalArgumentException("randomNumGen variable may no be null");
		else if(rows <= 0 || cols <= 0)
			throw new IllegalArgumentException("rows and columns must be greater than 0. " +
					"rows: " + rows + ", cols: " + cols);

		int[][] temp = new int[rows][cols];
		final int SUB = LIMIT / 4;
		for(int r = 0; r < rows; r++)
			for(int c = 0; c < cols; c++)
				temp[r][c] = randNumGen.nextInt(LIMIT) - SUB;

		return new MathMatrix(temp);
	}

	private static void printTestResult(int[][] data1, int[][] data2, int testNum, String testingWhat) {
		System.out.print( "Test number " + testNum + " tests the " + testingWhat +". The test ");
		String result = equals(data1, data2) ? "passed" : "failed";
		System.out.println( result );
	}

	// pre: m != null, m is at least 1 by 1 in size
	private static int[][] get2DArray(MathMatrix m) {
		//check precondition
		assert ( m != null ) && ( m.numRows() > 0 ) && ( m.numCols()> 0 )
		: "Violation of precondition: get2DArray";

		int[][] result = new int[m.numRows()][m.numCols()];
		for(int r = 0; r < result.length; r++)
		{   for(int c = 0; c < result[0].length; c++)
		{   result[r][c] = m.getVal(r,c);
		}
		}
		return result;
	}

	// pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
	//      data1 and data2 are rectangular matrices
	// post: return true if data1 and data2 are the same size and all elements are
	//      the same
	private static boolean equals(int[][] data1, int[][] data2) {
		//check precondition
		if( ( data1 == null ) || ( data1.length == 0 )
				|| ( data1[0].length == 0 ) || !rectangularMatrix(data1)
				||  ( data2 == null ) || ( data2.length == 0 )
				|| ( data2[0].length == 0 ) || !rectangularMatrix(data2))
			throw new IllegalArgumentException( "Violation of precondition: equals check on 2d arrays of ints");

		boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
		int row = 0;
		while( result && row < data1.length ) {
			int col = 0;
			while( result && col < data1[0].length ) {
				result = (data1[row][col] == data2[row][col]);
				col++;
			}
			row++;
		}

		return result;
	}


	// method to ensure mat is rectangular
	// pre: mat != null, mat is at least 1 by 1
	private static boolean rectangularMatrix( int[][] mat ) {
		if(mat == null || mat.length == 0 || mat[0].length == 0)
			throw new IllegalArgumentException("Violation of precondition: "
					+ " Parameter mat may not be null" 
					+ " and must be at least 1 by 1");
		return MathMatrix.rectangularMatrix(mat);
	}
	
	
	//Pre: dimensionOfMatrix > 0
    //post: Create MathMatrix object which has a matrix is filled with random values
    //@param dimensionOfMatrix > 0
    public static MathMatrix randomMatrix(int dimensionOfMatrix)
    {
        if (dimensionOfMatrix <=0){
            throw new IllegalArgumentException("Violation of precondition: " + "Dimension must be positive.");
        }
        final int maxRandom = 5999;
        Random RandomValues = new Random();

        MathMatrix matrix = new MathMatrix(dimensionOfMatrix, dimensionOfMatrix, 0);
        int randomValue;
        // fill matrix1 with random values
        for (int row = 0; row < dimensionOfMatrix; row++)
            for (int col = 0; col < dimensionOfMatrix; col++)
            {
                randomValue = RandomValues.nextInt(maxRandom);
                matrix.changeElement(row, col, randomValue);
            }

        return matrix;
    }
    	// Experiment 1 - 
    	// create two square matrices filled with random values
    	// add them together 1000 times
    	// Record the dimension of the matrix and the average time it took for the add operation
        private static void experiment1(int dimensionOfTwoMatrix){
        	Stopwatch checkTime = new Stopwatch();
        	final int numberOfRepetition = 100;
        	double totalTime = 0;
        	// print the dimension of two square matrix
        	System.out.println("Add two " + dimensionOfTwoMatrix + "x" + dimensionOfTwoMatrix + " matrices:" );
        	for (int count = 0; count < numberOfRepetition; count++)
        	{
        		MathMatrix matrix1 = randomMatrix(dimensionOfTwoMatrix);
        		MathMatrix matrix2 = randomMatrix(dimensionOfTwoMatrix);

                checkTime.start();
                matrix1.add(matrix2);
                checkTime.stop();

                totalTime += checkTime.time();
                System.out.println("Experiment " + (count+1) + ": " + checkTime );
        	}
    	
    	double averageTime = totalTime / numberOfRepetition;
    	System.out.println("The average time of " + numberOfRepetition+ " repetitions when adding two "
    						+ dimensionOfTwoMatrix + "x" + dimensionOfTwoMatrix + " matrices: " + averageTime + " seconds");
        }

        // Experiment 2
    	// create two square matrices filled with random values
    	// multiply them together 1000 times
    	// Record the dimension of the matrix and the average time it took for the add operation
        private static void experiment2(int dimensionOfTwoMatrix){
        	Stopwatch checkTime = new Stopwatch();
        	final int numberOfRepetition = 100;
        	double totalTime = 0;
        	// print the dimension of two square matrix
        	System.out.println("multiply two " + dimensionOfTwoMatrix + "x" + dimensionOfTwoMatrix + " matrices:" );
        	for (int count = 0; count < numberOfRepetition; count++)
        	{
        		MathMatrix matrix1 = randomMatrix(dimensionOfTwoMatrix);
        		MathMatrix matrix2 = randomMatrix(dimensionOfTwoMatrix);

                checkTime.start();
                matrix1.multiply(matrix2);
                checkTime.stop();

                totalTime += checkTime.time();
                System.out.println("Experiment " + (count+1) + ": " + checkTime );
        	}
    	
    	double averageTime = totalTime / numberOfRepetition;
    	System.out.println("The average time of " + numberOfRepetition + " repetitions when multiply two "
    						+ dimensionOfTwoMatrix + "x" + dimensionOfTwoMatrix + " matrices: " + averageTime + " seconds");
    	

        
	

}
}
