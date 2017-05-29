/**
  * This class represents the multiplication operator.
  */
public class MultiplyOp extends BinaryOp{
	/**
	 * This function multiplies the two numbers
	 * @param right a number
	 * @param left a number 
	 * @return the value of the multiplied numbers that the function received
	 */
	public double operate(double left, double right){
		return left*right;	
	}
	
	/**
      * @return the symbol that represents the multiplication operation
	  */
	public String toString(){	
		return	"*";
	}	
	
}
