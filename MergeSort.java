//Cheryl Qian
//APCS pd02
//HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
//2018-02-06

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:

  ======================================*/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
    private static int[] merge( int[] a, int[] b )
    {
	int[] merged = new int[(a.length + b.length)];
	int faceA = 0;
	int faceB = 0;
	for( int x = 0; x < merged.length; x++){
	    if ( faceA < a.length && faceB < b.length ) {
		if( a[faceA] < b[faceB] ){
		    merged[x] = a[faceA];
		    faceA += 1;
		} else {
		    merged[x] = b[faceB];
		    faceB += 1;
		}
      
	    } else if( faceA == a.length){
	        merged[x] = b[faceB];
		faceB += 1;
	    } else if( faceB == b.length){
		merged[x] = a[faceA];
		faceA += 1;
	    }
	    
	}
	return merged;
    }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
      int[] first = { arr[0] };
      int[] second = { arr[1] };

      while( first.length < arr.length - 1) {
	  first = merge( first, second );
	  second[0] = arr[first.length];
      }
      arr = first;
      return arr;
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
	a[i] = 0;
       
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {

  
      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      // System.out.println("\nTesting mess-with-array method...");
      // printArray( arr3 );
      // mess(arr3);
      // printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr3: ");
      printArray( merge(arr4,arr3) );

       
      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
      /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
