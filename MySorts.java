/******************************
 Team Art Heart -- Cheryl Qian and Nadine Jackson
 APCS1 pd2
 HW55 -- Never Fear, Big Oh Is Here!
 2017-12-14
******************************/
import java.util.ArrayList;

/*================== OrderedArrayList.java ====================

  get( int index ) -- CONSTANT: takes 1 full or partial traversal through the array.
  size() -- CONSTANT: takes 1 full or partial traversal through the array. 
  remove( int index ) -- CONSTANT: takes 1 full or partial traversal through the array.

  add( Comparable newVal ) -- LINEAR: compares each element to the argument
  addBin( Comparable newVal ) -- LOGARITHMIC: compares the argument to the center element between the upper and lower
  bounds each time, so it's less costly than a linear search for the correct position, but still dependent on the number
  of elements in the array.

  ==============================================================*/

public class MySorts
{
    //=================== HELPER METHODS ===================
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi )
    {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al )
    {
	int randomIndex;
	//setup for traversal fr right to left
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    //======================================================

 
    // BEST CASE: LINEAR O(n) -- Elements are sorted in ascending order, requires data.size() passes. (Each pass consisting of going through the entire ArrayList, comparing and never swapping.)
    // WORST CASE: LINEAR O(n) -- Elements are sorted in descending order, requires data.size() passes (Each pass consisting of going through the al, comparing and swapping each pair.)

    public static void bubbleSort( ArrayList<Comparable> data )
    {
	//make n-1 passes across collection
	for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
	    System.out.println( "commencing pass #" + passCtr + "..." );

	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size() - passCtr; i++ ) { //it's more efficient not to go through the whole list each time
		//if element at i > element at i+1, swap
		if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) 
		    data.set( i, data.set(i+1,data.get(i)) );   
		//System.out.println(data); //diag: show current state of list
	    }
	}
    }


    // BEST CASE == WORST CASE
    // LINEAR O(n): Both require data.size() passes, since the number of passes varies directly with the size of the collection, as selectionSort requires precisely data.size() locations of the minimum and swaps.
    
    public static void selectionSort( ArrayList<Comparable> data ) 
    {
	//note: this version places greatest value at rightmost end,

	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;

	for( int pass = data.size()-1; pass > 0; pass-- ) {
	    System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
	    maxPos = 0;
	    for( int i = 1; i <= pass; i++ ) {
		System.out.println( "maxPos: " + maxPos );//diag
		System.out.println( data );//diag
		if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
		    maxPos = i;
	    }
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
	    System.out.println( "after swap: " +  data );//diag
	}
    }//end selectionSort
    
    // BEST CASE: Elements are sorted in ascending order
    // WORST CASE: Elements are sorted in descending order
    // LINEAR: Both require exactly data.size() passes, each pass finding an element's final resting place, so both are directly variant with the size of the collection.
  
    public static void insertionSort( ArrayList<Comparable> data )
    {
	for( int pass = 0; pass < data.size() - 1; pass++ ) {
      
	    for( int index  = pass + 1; index > 0 ; index-- ) {
		if ( data.get(index).compareTo(data.get(index - 1)) < 0 ) {
		    data.set( index - 1, data.set( index, data.get(index - 1) ) );
		}
	    }
	}
    }//end insertionSort

    public static void main( String [] args )
    {
    }//end main
}
