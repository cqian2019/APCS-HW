//Cheryl Qian
//APCS pd1
//HW31 -- Stack: What Is It Good For?
//2018-04-10

/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{
  /**********************************************************
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **********************************************************/
  public static String flip( String s )
  {
      Latkes stack = new Latkes( s.length() );
      String ret = "";
      for ( int i = 0; i < s.length(); i++ ) {
	  stack.push( s.substring(i, i + 1));
      }
      for ( int i = 0; i < s.length(); i++ ) {
	  ret += stack.pop();
      }
      return ret;
      
  }//end flip()


  /**********************************************************
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **********************************************************/
    public static boolean allMatched( String s )
    {
	if ( s.length() == 0 )
	    return true;
	
	Latkes stack = new Latkes( s.length() );
	Latkes popper = new Latkes( s.length() );

	for ( int i = 0; i < s.length(); i++ ) {
	    String tmp =  s.substring(i, i + 1);
	    stack.push(tmp);
	}
	
	while ( !stack.isEmpty() ) {
	    String q = "";
	    String p = stack.pop();
	    
	    if ( p.equals("}") || p.equals("]") || p.equals(")") ) {
		popper.push(p);
	    }
	    else {
		if ( popper.isEmpty() ) {
		    return false;
		}
		
		q = popper.pop();
		//System.out.println(q + " and " + p);
		if ( q.equals("}") && !p.equals("{") ||
		     q.equals("]") && !p.equals("[") ||
		     q.equals(")") && !p.equals("(")
		     ) {
		    return false;
		}
	    }
	}

	return popper.isEmpty();
	
    }//end allMatched()


  //main method to test
  public static void main( String[] args )
  {

    System.out.println(flip("stressed"));
    
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
    ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
