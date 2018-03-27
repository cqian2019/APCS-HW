//Cheryl Qian
//APCS pd2
//HW23 -- Give and Take
//2018-03-23

/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

public class LList implements List //your List interface must be in same dir
{ 

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( )
    {
	_head = null; //at birth, a list has no elements
	_size = 0;
    }


    //--------------v  List interface methods  v--------------
    
    public boolean add( String newVal )
    {
	LLNode tmp = new LLNode( newVal, _head );
	_head = tmp;
	_size++;
	return true;
    }

    public void add( int index, String newVal )
    {
	if ( index == 0 ) {
	    add(newVal);
	}
	else {
	    LLNode current = _head;
	    for ( int i = 0; i + 1 < index; i++ ) {
		current = current.getNext();
	    }
	    LLNode newN = new LLNode( newVal, null );
	    newN.setNext(current.getNext());
	    current.setNext(newN);
	    _size++;
	}
    }

    public String remove( int index ) {
	
	String ret;
	if ( index == 0 ) {
	    ret = _head.getCargo();
	    _head = _head.getNext();
	    return ret;
	}

	else {
	    LLNode current = _head;
	    for ( int i = 0; i + 1 < index; i++ ) {
		current = current.getNext();
	    }
	    ret = current.getNext().getCargo();
	    current.setNext( current.getNext().getNext() );
	    return ret;
	}
    }

    
    public String get( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }


    public String set( int index, String newVal )
    {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	String oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }


    //return number of nodes in list
    public int size() { return _size; }
    
    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString()
    {
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );

	james.add(0, "Hey!");
	System.out.println("Added 'Hey!' at index 0:\n" + james);

	james.add(3, "you");
	System.out.println("Added 'you' at index 3:\n" + james);

	james.remove(3);
	System.out.println(james);

	james.remove(0);
	System.out.println(james);
    }

}//end class LList


