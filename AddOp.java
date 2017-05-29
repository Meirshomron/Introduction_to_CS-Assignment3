/**
* This class represents the adding operator.
 */
public class AddOp extends BinaryOp {

/**
 * This function combines the values of two numbers
 * @param left a number that we add to another number
 * @param right a number 
 * @return the value of the combined numbers
 */
public double operate(double left, double right){
	return left+right;	
}
/**
* @return the symbol that represents the adding operation
*/
public String toString(){	
	return	"+";
}	
}
