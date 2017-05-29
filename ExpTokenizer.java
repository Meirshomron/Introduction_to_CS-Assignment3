import java.util.Enumeration;
/**
 * the class converts a string into a series of tokens
 */
public class ExpTokenizer extends Object implements Enumeration<Object>  {
	
	
	//fields
	private String [] result;
	private boolean direction;
	private int index;
	
	//constructor
	public ExpTokenizer(String exp) {
		this.result = exp.split(" ");
		this.direction = true;
		this.index = 0;
	}

	public ExpTokenizer(String exp,boolean direction) {
		result = exp.split(" ");
		this.direction = direction;
		if(!this.direction)
			this.index=result.length-1;
		else 
			this.index = 0;
	}
	
	/**
	 * @return the next token in the string that the constructor received  
	 */
	public Object nextElement()throws ParseException{
		CalcToken resultToken = null;
		String token =  nextToken();
		if (token.equals("+"))
			resultToken =  new AddOp();
		else
			if (token.equals("*"))
				resultToken =  new MultiplyOp();
			else
				if(token.equals("-"))
					resultToken =  new SubtractOp();
				else
					if(token.equals("/"))
						resultToken =  new DivideOp();
					else
						if(token.equals("^"))
							resultToken =  new PowOp();
						else
							//checks if the char is illegal 
							if( resultToken == null && token.charAt(0)!='-'&& token.charAt(0)<'0'||token.charAt(0)>'9'){ 
									ParseException e=new ParseException("SYNTAX ERROR: a char is illegal: ");
									throw e;
							}
							else 
								/**
							      *the next token is a number,a new ValueToken is created and the token is 
								  *converted to a double.
								  */
								resultToken = new ValueToken(Double.parseDouble(token));			
							
		return resultToken;	
	}
	
	/**
	  *@return true if there is more elements in the result array, else false.
	  *@Override
	  */
	public boolean hasMoreElements() {
		if(this.direction)
			return (this.index != this.result.length);
		else
			return (this.index >= 0);
	}
	
	/**
	  *@return the next token in the result array according to the index.
	  */
	public String nextToken() {
		String ret;
		if(this.direction){
			ret= this.result[this.index];
			this.index++;
		}
		else{
			ret= this.result[this.index];
			this.index--;
		}
		return ret;
	}
	
	/**
	  *@return true if there is more tokens in the result array, else false.
	  */
	public boolean hasMoreTokens() {
		return hasMoreElements();
	}
	
	/**
	  *@return the number of tokens remaining after the index.
	  */
	public int countTokens() {
		if(this.direction)
			return (this.result.length - this.index);
		else
			return (this.index+1);
	}
	
	/**
      * @return the string that was received.
	  */
	 public String toString(){
	 String s="";
		 for(int i=0;i<result.length;i++)
			 s=s+result[i];
	 return s;
	 }
}