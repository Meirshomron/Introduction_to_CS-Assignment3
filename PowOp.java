/**
  * This class represents the power operator.
  */
public class PowOp extends BinaryOp{

	/**
	 * This function calculates the power of a number with another number
	 * @param left a number 
	 * @param right a number 
	 * @return the power of left with right
	 */
	public double operate(double left, double right){
		double ans=1.0;
		boolean negative=false;
		if(right==0)
			return ans;
		if(right<0){
			negative=true;
			right=right*(-1);
		}
		for(int i=0;i<right;i++)
			ans=ans*left;
		if(negative)	
			return 1/ans;
	return ans;	}
	/**
	  * @return the symbol that represents the power operation
	  */
	public String toString(){	
		return	"^";
	}	
}

