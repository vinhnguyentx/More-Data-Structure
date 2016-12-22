//  MathMatrix.java - CS314 Assignment 2

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

/**
 * A class that models systems of linear equations (Math Matrices)
 * as used in linear algebra.
 *
 * @version Skeleton file for students
 */
public class MathMatrix
{
    // instance variables
    /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    
	public int[][] mathMat;
	public int numRows;
	public int numCols;
	
    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
     * mat is a rectangular matrix
     */
    public MathMatrix(int[][] mat) {
        // check the precondition. rectangularMatrix is a private method at end of Matrix class
        if((mat == null) || (mat.length == 0) || (mat[0].length == 0)
                || !rectangularMatrix(mat)) 
            throw new IllegalArgumentException("Violation of precondition: " +
            		"int[][] Matrix constructor");
                
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
        
        numRows = mat.length;
        numCols = mat[0].length;
        mathMat = new int[numRows][numCols];
        
        for (int row = 0; row < numRows; row ++) {
        	for (int col = 0; col < numCols; col ++) {
        		mathMat[row][col] = mat[row][col];
        	}
        }
    }


    /**
     * create a MathMatrix of the specified size with all cells set to the intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns. 
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal 
     * for all valid r and c.
     * @param numRows numRows > 0
     * @param numCols numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	
    	this.numRows = numRows;
    	this.numCols = numCols;
    	
    	if (numRows <= 0 || numCols <= 0)
                throw new IllegalArgumentException("Violation of precondition: " +
            		"Number of row or column must be  greater than 0");
    	
    	this.mathMat = new int[numRows][numCols];
    	
    	for (int row = 0; row < numRows; row ++) {
    		for (int col = 0; col < numCols; col ++) {
    			mathMat[row][col] = initialVal;
    		}
    	}
    	
    }

    /**
     * change the value of one of the cells in this MathMatrix.
     * <br>pre: 0 <= row < numRows(), 0 <= col < numCols()
     * <br>post: getVal(row, col) = newValue
     * @param row 0 <= row < numRows()
     * @param col 0 <= col < numCols()
     */
    public void changeElement(int row, int col, int newValue) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	
    	if (row < 0 || row >= numRows())
    		throw new IllegalArgumentException("Violation of precondition: " +
            	"Value of row should be greater or equals to 0 and less than " + numRows());
    	
    	if (col < 0 || col >= numCols())
    		throw new IllegalArgumentException("Violation of precondition: " +
            	"Value of column should be greater or equals to 0 and less than " + numCols());
    	
    	mathMat[row][col] = newValue;
    }


    /**
     * Get the number of rows.
     * @return the number of rows in this MathMatrix
     */
    public int numRows() {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	return mathMat.length;
    }


    /**
     * Get the number of columns.
     * @return the number of columns in this MathMatrix
     */
    public int numCols() {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
        return mathMat[0].length;
    }


    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < numRows(), col  0 <= col < numCols()
     * @param  row  0 <= row < numRows()
     * @param  col  0 <= col < numCols()
     * @return the value at the specified position
     */
    public int getVal(int row, int col) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	if (row < 0 || row > numRows)
    		throw new IllegalArgumentException("Violation of precondition: " +
            	"Value of row should be greater or equals to 0 and less than " + numRows);
    	
    	if (col < 0 || col >= numCols)
    		throw new IllegalArgumentException("Violation of precondition: " +
            	"Value of column should be greater or equals to 0 and less than " + numCols);
    	
        return mathMat[row][col];
    }


   /**
    * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
    * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * <br>post: This method does not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
    * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned Matrix is equal to the number of columns in this MathMatrix.
    */
    public MathMatrix add(MathMatrix rightHandSide) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	if (rightHandSide == null || rightHandSide.numRows() != numRows() || rightHandSide.numCols() != numCols())
    		throw new IllegalArgumentException("Violation of precondition: " +
                	"Two matrices must have the same numbers of rows and columns");
    	
    	MathMatrix newAddMat = new MathMatrix(this.mathMat);
    	
    	for (int row = 0; row < newAddMat.numRows(); row ++) {
    		for (int col = 0; col < newAddMat.numCols(); col ++) {
    			newAddMat.mathMat[row][col] += rightHandSide.mathMat[row][col];
    		}
    	}
        return newAddMat;
    }


   /**
    * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
    * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * <br>post: This method does not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * @return a new MathMatrix that is the result of subtracting rightHandSide from this MathMatrix.
    * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned MathMatrix is equal to the number of columns in this MathMatrix.
    */
    public MathMatrix subtract(MathMatrix rightHandSide) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	
    	if (rightHandSide == null || rightHandSide.numRows() != numRows() || rightHandSide.numCols() != numCols())
    		throw new IllegalArgumentException("Violation of precondition: " +
                	"Two matrices must have the same numbers of rows and columns");
    	
    	MathMatrix newSubtractMat = new MathMatrix(this.mathMat);
    	
    	for (int row = 0; row < newSubtractMat.numRows(); row ++) {
    		for (int col = 0; col < newSubtractMat.numCols(); col ++) {
    			newSubtractMat.mathMat[row][col] -= rightHandSide.mathMat[row][col];
    		}
    	}
        return newSubtractMat;
    }


   /**
    * implements matrix multiplication, (this MathMatrix) * rightHandSide.
    * <br>pre: rightHandSide.numRows() = numCols()
    * <br>post: This method should not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numCols()
    * @return a new MathMatrix that is the result of multiplying this MathMatrix and rightHandSide.
    * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned MathMatrix is equal to the number of columns in rightHandSide.
    */
    public MathMatrix multiply(MathMatrix rightHandSide) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	if (rightHandSide == null || rightHandSide.numRows() != numCols())
    		throw new IllegalArgumentException("Violation of precondition: " +
                	"Two matrices must have the same numbers of rows and columns");
    	
    	MathMatrix newMultiplyMat = new MathMatrix(this.numRows(), rightHandSide.numCols(), 0);
    	
    	for (int row = 0; row < this.numRows(); row ++) {
    		for (int rhsCol = 0; rhsCol < rightHandSide.numCols(); rhsCol ++) {
    			for (int col = 0; col < this.numCols(); col ++) {
    				newMultiplyMat.mathMat[row][rhsCol] += mathMat[row][col] * rightHandSide.mathMat[col][rhsCol];
    			}
    		}
    	}
    	
        return newMultiplyMat;
    } 


   /**
    * Multiply all elements of this MathMatrix by factor.
    * <br>pre: none
    * <br>post: all elements in this matrix have been multiplied by factor. 
    * In other words after this method has been called getVal(r,c) = old getVal(r, c) * factor
    * for all valid r and c.
    * @param factor the value to multipy every cell in this Matrix by.
    */
    public void scale(int factor) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	
    	for (int row = 0; row < this.numRows(); row ++) {
    		for (int col = 0; col < this.numCols(); col ++) {
    			mathMat[row][col] *= factor;
    		}
    	}
    }


    /**
     * accessor: get a transpose of this MathMatrix. 
     * This Matrix is not changed.
     * <br>pre: none
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose() {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	MathMatrix newTransMat = new MathMatrix(this.numCols(), this.numRows(), 0);
    	
    	for (int row = 0; row < newTransMat.numRows(); row ++) {
    		for (int col = 0; col < newTransMat.numCols(); col ++) {
    			newTransMat.mathMat[row][col] = mathMat[col][row];
    		}
    	}
    	
        return newTransMat;
    }


    /**
     * override equals.
     * @return true if rightHandSide is the same size as this MathMatrix and all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide) {
        /* CS314 Students. The following is standard equals
         * method code. We will learn about it in a few weeks.
         */
        boolean result = false;
        if( rightHandSide != null && this.getClass() == rightHandSide.getClass()) {
            // rightHandSide is a non null MathMatrix
            MathMatrix otherMatrix = (MathMatrix)rightHandSide;
            
            // cs314 students: determine if otherMatrix is equal
            // to this MathMatrix and set result to true if they are.
            
            /*CS314 STUDENTS: ADD YOUR CODE HERE*/
            
            //test numbers of rows and columns
            result = (numRows() == otherMatrix.numRows() && numCols() == otherMatrix.numCols());
            
            //test elements
            int row = 0;
            while (result && row < numRows()) {
            	int col = 0;
            	while (result && col < numCols()) {
            		result = (mathMat[row][col] == otherMatrix.mathMat[row][col]);
            		col ++;
            	}
            	row ++;
            }
        }
        return result;
    }


    /**
     * override toString.
     * @return a String with all elements of this MathMatrix. 
     * Each row is on a seperate line.
     * Spacing based on longest element in this Matrix.
     * Each row stats and ends with a vertical bar: '|'
     */
    public String toString(){
    	/*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	//find the longest element (method below)
    	int cellLength = longestElement();
    	
    	StringBuilder sb = new StringBuilder("");
    	for (int row = 0; row < mathMat.length; row ++) {
    		sb.append("|");
    		for (int col = 0; col < mathMat[0].length; col ++) {
    			int elementLength = ("" + mathMat[row][col]).length();

    			//filling spaces
    			while (elementLength <= cellLength) {
    				sb.append(" ");
    				elementLength ++;
    			}
    			sb.append(Integer.toString(mathMat[row][col]));
    		}
    		sb.append("|\n");
    	}
    	return sb.toString();
    }
    
    	//find the longest element
    	public int longestElement() {
    		int maxLength = 0;
    		for (int row = 0; row < numRows(); row ++) {
    			for (int col = 0; col < numCols(); col ++) {
    				maxLength = Math.max(maxLength, ("" + mathMat[row][col]).length() );
    			}
    		}
    		return maxLength;
    	}
    
    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main 
     * diagonal must be 0.<br>
     * pre: this is a square matrix. numRows() == numCols()  
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise. 
     */
    public boolean isUpperTriangular() {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	
    	boolean result = true;
    	if (numRows() != numCols())
    		throw new IllegalArgumentException("Violation of precondition: This matrix is not square");
    	
    	//check from the cell with the index of (1,0)
    	int row = 1;
    	int col = 0;
    	while (result && col < numCols()) {
    		while (result && row < numRows()) {
    			result = mathMat[row][col] == 0;
    			row ++;
    		}
    		col ++;
    		row = col + 1;		//row increment after each column increment
    	}
        return result;
    }
    
    // method to ensure mat is rectangular
    // pre: mat != null
    public static boolean rectangularMatrix(int[][] mat) {
        if(mat == null)
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null");
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;

        while( isRectangular && row < mat.length ) {
            isRectangular = ( mat[row].length == COLUMNS );
            row++;
        }

        return isRectangular;
    }
}