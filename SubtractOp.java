/**
  * This class represents the subtraction operator.
  */
public class SubtractOp extends BinaryOp{
	/**
	 * This function subtracts the right number from the left
	 * @param left a number 
	 * @param right a number 
	 * @return the value of the subtracted number
	 */
	public double operate(double left, double right){
		return left-right;	
	}

	/**
	  * @return the symbol that represents the subtract operation
	  */
	public String toString(){	
		return	"-";
	}	
}
