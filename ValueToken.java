
	/**
	  * This class which extends CalcToken, represents a number.
	  */
	public class ValueToken extends CalcToken{

		private double value;	
		//constructor	
		public ValueToken(double value){
			this.value=value;
		}	
		/**
		  * @return the value of the token.
		  */
		public double getValue(){
			return this.value;
		}
		/**
		  * @return the string that represents the value of the token
		  */
		public String toString(){
			return String.valueOf(value);
	
		}
	}
