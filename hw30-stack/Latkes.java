//Cheryl Qian
//APCS pd1
//HW30 -- Stacks on Stacks on Stacks on Stacks...
//2018-04-10 T

/*****************************************************
 * skeleton for class Latkes
 * Implements a stack of Strings using an encapsulated array
 *****************************************************/

public class Latkes
{
  private String [] _stack;
  private int _stackSize;

  //constructor
  public Latkes( int size )
  {
      _stack = new String[size];
      _stackSize = 0;
  }

  //means of insertion
  public void push( String s )
  {
      if ( !isFull() ) {
	  if ( isEmpty() ) {
	      _stack[0] = s;
	      _stackSize++;
	  }
	  else {
	      int n = _stackSize;
	      while ( n > 0 ) {
		  String tmp = _stack[n - 1];
		  _stack[n] = tmp;
		  n--;
	      }
	      _stack[0] = s;
	      _stackSize++;
	  }
      }

      else {
	  System.out.println("Stack overflow...");
      }
  }

  

  //means of removal
  public String pop( )
  {
      String oldVal = _stack[0];
      if ( !isEmpty() ) {	 
	  int n = 0;
	  while ( n < _stackSize - 1) {
	      String tmp = _stack[n + 1];
	      _stack[n] = tmp;
	      n++;
	  }
	  _stackSize--;
	  return oldVal;
      }

      else {
	  return null;
      }
  }

  //chk for emptiness
  public boolean isEmpty()
  {
      if ( _stackSize == 0 )
	  return true;
      return false;
  }

  //chk for fullness
  public boolean isFull()
  {
      if ( isEmpty() )
	  return false;
      else if ( _stack[_stack.length - 1] == null )
	  return false;
      else
	  return true;
  }

    public void printA() {
	int n = 0;
	for ( String s : _stack ) {
	    System.out.println(_stack[n]);
	    n++;
	}
    }


  //main method for testing
  public static void main( String[] args )
  {
      Latkes tastyStack = new Latkes(10);

      tastyStack.push("aoo");
      tastyStack.push("boo");
      tastyStack.push("coo");
      tastyStack.push("doo");
      tastyStack.push("eoo");
      tastyStack.push("foo");
      tastyStack.push("goo");
      tastyStack.push("hoo");
      tastyStack.push("ioo");
      tastyStack.push("joo");
      tastyStack.push("coocoo");
      tastyStack.push("cachoo");
      tastyStack.printA();

      //cachoo
      System.out.println( tastyStack.pop() );
      //coocoo
      System.out.println( tastyStack.pop() );
      //joo
      System.out.println( tastyStack.pop() );
      //ioo
      System.out.println( tastyStack.pop() );
      //hoo
      System.out.println( tastyStack.pop() );
      //goo
      System.out.println( tastyStack.pop() );
      //foo
      System.out.println( tastyStack.pop() );
      //eoo
      System.out.println( tastyStack.pop() );
      //doo
      System.out.println( tastyStack.pop() );
      //coo
      System.out.println( tastyStack.pop() );
      //boo
      System.out.println( tastyStack.pop() );
      //aoo
      System.out.println( tastyStack.pop() );

      //stack empty by now; SOP(null)
      System.out.println( tastyStack.pop() );
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes
