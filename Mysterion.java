//Cheryl Qian
//APCS pd2
//HW16 -- About Face
//2018-03-08

/**********************
mysterion() takes an array and its median index, and moves all 
values less than the median to its left, and all vals greater 
than the median to its right. lo and hi and the bounds of the
array, and median is the median index.

***********************/


public class Mysterion {
    
    public static void swap(int[] a, int i, int j) {
        int init = a[i];
        a[i] = a[j];
        a[j] = init;
    }
        
    public static int mysterion( int[] a, int lo, int hi, int median) {
        int m = a[median]; //creates a constant for median
        swap( a, hi, median ); //swap ints at max and med indices
        int s = lo; //creates var that increases from the min index 
        for ( int i = lo; i <= hi-1; i++ ) {
            if ( a[i] < m ) { //if int at index i < median
                swap(a, s, i); //swap int at index s with int at index i
                s++;//add 1 to s if successfully swapped
            }
        } 
        swap(a, hi, s);
        return s;
    }
    
    private static void printArray(int[] a) {
        System.out.print("[");
	for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                System.out.print(", ");
	    }
            System.out.print(a[i]);
	}
        System.out.print("]");
        System.out.println();
    }

    public static void main(String args[]) {
        int a[] = { 7, 3 ,2 ,12 ,1 };
        printArray(a);
        mysterion(a, 0, 4, 1);
        printArray(a);

	int b[] = { 6, 5, 4, 3, 2, 1 };
	printArray(b);
	mysterion(b, 0, 5, 3);
	printArray(b);

	int c[] = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 ,1};
	printArray(c);
	mysterion(c, 0, 10, 5);
	printArray(c);
    }
}
