/**
 * Abstract "superclass" that represents all types of calculators
 */
public abstract class Calculator {
	
	protected StackAsArray a=new StackAsArray();
	
	/**
	 * By making this method abstract, all subclasses MUST implement it.
	 * this function that will be implemented, calculates the value of a certain math expression.
	 */	
	public abstract void evaluate(String expr);

	/**
	 * @return the value that was calculated 
	 * @see evaluate function in the calculator class.
	 */
	public double getCurrentResult(){//לזכור לזרוק אקספשן אם הערך לא נכון
		return ((ValueToken)a.pop()).getValue();

	}
	
}
	

