//Cheryl Qian
//APCS2 pd1
//Hw33 -- What a Racket
//2018-04-13
/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Find the first operator
 *   2. Check if next el is a number. If yes, use the operator on that num and store its val in an int
 *   3. Repeat Step 2 till you reach another ( or if you reach a ), in which case you end and return the int
     4. If you hit a (, find the next operator and start from step 2 again.
 *
 * STACK OF CHOICE: ALStack b/c the algo doesn't require the attributes of a LList
 *
 ******************************************************/

public class Scheme
{

    /******************************************************
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr )
    {

	String[] arr = expr.split("//s+");
	String ret = "";
	ALStack<String> stack = new ALStack<String>();
	for( String s: arr)
	    stack.push(s);

	if( stack.peek().equals("(")){
	    stack.pop();
	    int operator = findOp(stack.pop());
	    ret = unload(operator, stack);
	    return ret;
	}
	return "";
    }//end evaluate()

    public static int findOp(String s) {
	if ( s == "+")
	    return 1;
	else if ( s == "-" )
	    return 2;
	else
	    return 3;
    }


    /******************************************************
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, ALStack<String> numbers )
    {
	int i = 0;
	int operand = 0;
	String ret = "";
	while( !(numbers.peek().equals(")") )) {
		int next = Integer.parseInt(numbers.pop());
		if(op == 1)
		    i += next;

		else if(op == 2)
		    i -= next;
		
		else if(op == 3)
		    i *= next;

	}
	if(numbers.peek().equals(")")) {
	    return ret += i;
	}
	if( numbers.peek().equals("(")){
	    
	    if(op == 1){
		numbers.pop();
		operand = findOp(numbers.pop());
		return ret += (i + Integer.parseInt(unload(operand,numbers))) ;
	    }
	    
	    else if(op == 2){
		numbers.pop();
		operand = findOp(numbers.pop());
		return ret += (i - Integer.parseInt(unload(operand,numbers)));
	    }
	
	    else if(op == 3){
		numbers.pop();
		operand = findOp(numbers.pop());
		return ret += (i - Integer.parseInt(unload(operand,numbers)));
	    }
	}
	ret += i;
	return ret;
    }//end unload()


	/*
	//optional check-to-see-if-its-a-number helper fxn:
	public static boolean isNumber( String s ) {
	try {
	Integer.parseInt(s);
	return true;
	}
	catch( NumberFormatException e ) {
	return false;
	}
	}
	*/


	//main method for testing
    public static void main( String[] args )
    {
	    String zoo1 = "( + 4 3 )";
	    System.out.println(zoo1);
	    System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	    //...7

	    String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	    System.out.println(zoo2);
	    System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	    //...17

	    String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	    System.out.println(zoo3);
	    System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	    //...29

	    String zoo4 = "( - 1 2 3 )";
	    System.out.println(zoo4);
	    System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	    //...-4

    }//main

}//end class Scheme
