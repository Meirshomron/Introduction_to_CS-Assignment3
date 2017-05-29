/**
* This class represents the division operator.
 */
public class DivideOp extends BinaryOp{
	/**
	  * This function divides the second number from the first number 
	  * @param right a number
	  * @param left a number 
	  * @return the value of the divided number
	  */
	public double operate(double left, double right){
		return left/right;	
	}

	/**
	  * @return the symbol that represents the dividing operation
	  */
	public String toString(){	
		return	"/";
	}	
	
}


