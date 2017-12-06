//Cheryl Qian
//APCS pd2
//HW46 -- Al<B> Sorted!
//2017-12-05

import java.util.ArrayList;

public class OrderedArrayList {
    public static void populate(ArrayList<Comparable> a) {
	for( int i = 0; i < 20; i++ ) {
	    a.add((int) (Math.random() * 10));
	}
    }
    public static void maintain(ArrayList<Comparable> a) {
	boolean ans = false;
	for (int i = 1; (int) a.get(i) > (int) a.get(i-1) && i < a.size() - 1; i++) {
	    if ( i == a.size() - 2 ) {
		ans = true;
	    }
	}
	if ( ans == false ) {
	    throw new RuntimeException("Array not sorted");
	}
    }
    
    public static void main(String[] args) {
	ArrayList<Comparable> test = new ArrayList<Comparable>();
	populate(test);
	System.out.println(test);
	maintain(test);
    }
}
    
