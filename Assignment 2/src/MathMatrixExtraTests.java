public class MathMatrixExtraTests {
 
        /**
         * main method that runs simple test on the MathMatrix class
         *
         * @param args not used
         */
        public static void main(String[] args) {
 
                MathMatrix m1=new MathMatrix(3, 3, 0);
                //test 19
                resultsHeader(19, "add preconditions #3");
                try{
                        m1.add(null);
                        System.out.println("Test failed, did not throw an exception\n");
                }
                catch(NullPointerException e){
                        System.out.println("Test failed, NullPointerException thrown. Was this intentional?\n");
                }
                catch(IllegalArgumentException e){
                        System.out.println("Test passed\n");
                }
 
                //test 24
                resultsHeader(24, "subtract preconditions #3");
                try{
                        m1.subtract(null);
                        System.out.println("Test failed, did not throw an exception\n");
                }
                catch(NullPointerException e){
                        System.out.println("Test failed, NullPointerException thrown. Was this intentional?\n");
                }
                catch(IllegalArgumentException e){
                        System.out.println("Test passed\n");
                }
               
                //test 27
                resultsHeader(27, "multiply preconditions #2");
                try{
                        m1.multiply(null);
                        System.out.println("Test failed, did not throw and exception\n");
                }
                catch(NullPointerException e){
                        System.out.println("Test failed, NullPointerException thrown. Was this intentional?\n");
                }
                catch(IllegalArgumentException e){
                        System.out.println("Test passed\n");
                }
               
                //test 32
                m1=new MathMatrix(5, 5, 0);
                MathMatrix m2=m1;
                resultsHeader(32, "equals test #1");
                System.out.println("Test "+(m1.equals(m2) ? "pased\n" : "failed\n"));
 
                //test 33
                m2=new MathMatrix(5, 5, 0);
                resultsHeader(33, "equals test #2");
                System.out.println("Test "+(m1.equals(m2) ? "pased\n" : "failed\n"));
               
                //test 34
                resultsHeader(34, "equals test #3");
                System.out.println("Test "+(m1.equals(null) ? "failed\n" : "passed\n"));
               
                //test 35
                resultsHeader(35, "equals test #4");
                System.out.println("Test "+(m1.equals(new Object()) ? "failed\n" : "passed\n"));
               
                //test 36
                m1=new MathMatrix(2,2,0);
                String expectedString="| 0 0|\n| 0 0|\n";
                testResults(m1.toString(), expectedString, 36, "toString test #1");
               
                //test 37
                m1.changeElement(0, 0, -1);
                expectedString="| -1  0|\n|  0  0|\n";
                testResults(m1.toString(), expectedString, 37, "toString test #2");
 
 			
        }
       
        private static void testResults(String actual, String expected, int test, String name){
                resultsHeader(test, name);
                System.out.println("Expected:\n"+expected+"\nActual:\n"+actual);
                System.out.println("Test "+(actual.equals(expected) ? "passed\n" : "failed\n"));
        }
 
        private static void resultsHeader(int test, String name){
                System.out.println("Test "+test+": "+name);
        }
}