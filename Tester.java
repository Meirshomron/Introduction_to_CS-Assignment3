/**
  * This is a testing framework. Use it extensively to verify that your code is working
  * properly.
  */
public class Tester {

	private static boolean testPassed = true;
	private static int testNum = 0;
	
	/**
	  * This entry function will test all classes created in this assignment.
	  * @param args command line arguments
	  */
	public static void main(String[] args) {
	
		testValueToken();
		testPostfixCalculator();
		testAddOp();
		testPowOp();
		testMultiplyOp();
		testSubtractOp();
		testDivideOp();
		testExpTokenizer();
		testStackAsArray();
	
		
		// Notifying the user that the code have passed all tests. 
		if (testPassed) {
			System.out.println("All " + testNum + " tests passed!");
		}
	}

	/**
	  * This utility function will count the number of times it was invoked. 
	  * In addition, if a test fails the function will print the error message.  
	  * @param exp The actual test condition
	  * @param msg An error message, will be printed to the screen in case the test fails.
	  */
	private static void test(boolean exp, String msg) {
		testNum++;
		if (!exp) {
			testPassed = false;
			System.out.println("Test " + testNum + " failed: "  + msg);
		}
	}
	
	/**
	  * Checks the ValueToken class.
	  */
	private static void testValueToken() {
		
		ValueToken t1 = new ValueToken(5.1);
		ValueToken t2 = new ValueToken(5.1666666);
		CalcToken t3 = new ValueToken(4);
		test(t1.getValue() == 5.1, "Value should be 5.1.");
		test(t1.toString().equals("5.1"), "Value toString should be 5.1.");
		test(t2.toString().equals("5.1666666"), "Value toString should be 5.1666666");
		test(t3.toString().equals("4.0"), "Value toString should be 4");

	}

	/**
	 * Checks the PostfixCalculator class.
	 */
	private static void testPostfixCalculator() {
	
		PostfixCalculator p1= new PostfixCalculator();
		p1.evaluate("3 2 + ");
		test((p1.getCurrentResult()==5.0),"this should be 5.0" );
		p1.evaluate("3 2 -");
		test((p1.getCurrentResult()==1.0),"this should be 1.0" );
		p1.evaluate("3 2 ^ ");
		test((p1.getCurrentResult()==9.0),"this should be 9.0" );
		p1.evaluate("3 2 * ");
		test((p1.getCurrentResult()==6.0),"this should be 6.0" );
		p1.evaluate("3 2 / ");
		test((p1.getCurrentResult()==1.5),"this should be 1.5" );
		p1.evaluate("4 2 / 5 1 * ^");
		test((p1.getCurrentResult()==32.0),"this should be 32.0" );
		p1.evaluate("-4 -5 +");
		test((p1.getCurrentResult()==-9.0),"this should be -9.0" );
		p1.evaluate("2 -2 ^");
		test((p1.getCurrentResult()==0.25),"this should be 0.25" );
		p1.evaluate("-2 -2 ^");
		test((p1.getCurrentResult()==0.25),"this should be 0.25" );
		p1.evaluate("-2 2 ^");
		test((p1.getCurrentResult()==4.0),"this should be 4.0" );
		p1.evaluate("646");
		test((p1.getCurrentResult()==646.0),"this should be 646.0" );
	
	}
	
	/**
	  * Checks the AddOp class.
	  */
	private static void testAddOp(){
		AddOp a1=new AddOp();
		test(a1.operate(444, 2)==446.0,"this should be 446.0");
		test(a1.operate(-7, 2)==-5.0,"this should be -5.0");
		test(a1.toString().equals("+"),"this should be +");
		
	}
	
	/**
	  * Checks the PowOp class.
	  */
	private static void testPowOp(){
		PowOp p2=new PowOp();
		test(p2.operate(5, 2)==25.0,"this should be 25.0");
		test(p2.operate(-3, 2)==9.0,"this should be 9.0");
		test(p2.operate(0, 8)==0.0,"this should be 0.0");
		test(p2.operate(1, 0)==1.0,"this should be 1.0");
		test(p2.toString().equals("^"),"this should be ^");
		
	}
	
	/**
	  * Checks the MultiplyOp class.
	  */
	private static void testMultiplyOp(){
		MultiplyOp m1=new MultiplyOp();
		test(m1.operate(7, 3)==21.0,"this should be 21.0");
		test(m1.operate(-3, 2)==-6.0,"this should be -6.0");
		test(m1.operate(0, -2)==0.0,"this should be 0.0");
		test(m1.toString().equals("*"),"this should be *");	
		
	}
	
	/**
	  * Checks the SubtractOp class.
	  */
	private static void testSubtractOp(){
		SubtractOp s1=new SubtractOp();
		test(s1.operate(7, 3)==4.0,"this should be 4.0");
		test(s1.operate(-3, 2)==-5.0,"this should be -5.0");
		test(s1.operate(-3, -2)==-1.0,"this should be -1.0");
		test(s1.operate(3, -2)==5.0,"this should be 5.0");
		test(s1.toString().equals("-"),"this should be -");		
		
	}
	
	/**
	  * Checks the DivideOp class.
	  */
	private static void testDivideOp(){
		DivideOp d1= new DivideOp();
		test(d1.operate(30, 3)==10.0,"this should be 10.0");
		test(d1.operate(-7, 2)==-3.5,"this should be -3.5");
		test(d1.operate(-7,-3)==2.3333333333333335,"this should be 2.3333333333333335");
		test(d1.toString().equals("/"),"this should be /");		
		
	}
	
	/**
	  * Checks the ExpTokenizer class.
	  */
	private static void testExpTokenizer(){
		ExpTokenizer e1= new ExpTokenizer("5 2 +");
		ExpTokenizer e2= new ExpTokenizer("4 7 -");
		test(((ValueToken)e1.nextElement()).getValue()==5.0,"this should be 5.0");
		test(((ValueToken)e1.nextElement()).getValue()==2.0,"this should be 5.0");
		test(e1.hasMoreElements()==true,"this should be true");
		test(e1.countTokens()==1,"this should be 1");
		test(e1.nextElement() instanceof AddOp ,"this should be true");
		test(e1.hasMoreElements()==false,"this should be false");
		test(e2.nextToken().equals("4"),"this should be true");
		test(!(e2.nextToken().equals("4")),"this should be false");
		test(e2.hasMoreTokens(),"this should be true");
		test(e2.countTokens()==1,"this should be 1");
		test(e2.nextToken().equals("-"),"this should be true");
		test(e2.hasMoreTokens()==false,"this should be false");
		test(e2.countTokens()==0,"this should be 0");
		test(e2.toString().equals("47-"),"this should be true");
		
	}
	
	/**
	  * Checks the StackAsArray class.
	  */
	private static void testStackAsArray(){
		StackAsArray sa= new StackAsArray();
		ValueToken t1 = new ValueToken(5.1);
		sa.push(t1);
		test(!sa.isEmpty(),"this should be true");
		test(sa.pop() instanceof ValueToken,"this should be true");
		sa.push(t1);
		test(((ValueToken)sa.pop()).getValue()==5.1 ,"this should be true");
		test(sa.isEmpty(),"this should be true");

	}

}

