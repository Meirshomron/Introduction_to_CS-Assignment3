/**
 * the class creates a  type of Calculator.
 */
public class PostfixCalculator extends Calculator {
	/**
	 *  calculates the value of a certain math expression.
	 *  @param expr a string that represents a postfix math expression 
	 */	
	
	public void evaluate(String expr) throws ParseException{
		ParseException e;
		boolean found=true;
		if(expr==null){
				e=new ParseException("SYNTAX ERROR: The input is null: ");
				throw e;
		}
		for(int i=0;i<expr.length()&&found;i+=1)
			if(expr.charAt(i)<'0'||expr.charAt(i)>'9')
				found=false;
		if((!found)&&(expr.length()<5||expr.charAt(0)==' ')){
				e=new ParseException("SYNTAX ERROR: The input is too short: ");
				throw e;
		}
		ExpTokenizer b= new ExpTokenizer(expr);
		CalcToken first=null;
		while(b.hasMoreElements()){
			CalcToken temp=(CalcToken)b.nextElement();
				if(temp instanceof ValueToken){
					first=(ValueToken)temp;
					a.push(first);
				}
			else{
				if(temp instanceof BinaryOp){
						first=(BinaryOp)temp;
						if(a.isEmpty()){
								e=new ParseException("SYNTAX ERROR: not inuff numbers: ");
								throw e;
						}
					double right=((ValueToken)a.pop()).getValue();
					if(a.isEmpty()){
							e=new ParseException("SYNTAX ERROR: not inuff numbers: ");
							throw e;
					}
					double left=((ValueToken)a.pop()).getValue();
					CalcToken bbb=new ValueToken(((BinaryOp)(temp)).operate(left,right));
					a.push((ValueToken)bbb);
					
				}	
			}				 
		}	
		Object num=a.pop();
		if (!a.isEmpty()){
				e=new ParseException("SYNTAX ERROR: The input is illegal: ");
				throw e;
		}
		a.push(num);
		
	}
}



