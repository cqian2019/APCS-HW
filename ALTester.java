//Cheryl Qian
//APCS pd2
//HW46 -- Al<B> Sorted!
//2017-12-05

import java.util.ArrayList;

public class ALTester {
    
    public static void populate(ArrayList f) {
    	for(int i = 0; i < 23; i++) {
	    int random = (int) (Math.random() * 10);
	    f.add(random);
	}
    }

    public static void check(ArrayList f) {
	boolean ans = false;
	for (int i = 0; i < 22 && (int) f.get(i) < (int) f.get(i+1); i++) {
	    if ( i == 21 )
		ans = true;
	}
        System.out.println(ans);
    }
	    
    
    public static void main(String[] args) {
	ArrayList<Comparable> foo = new ArrayList<Comparable>();
	populate(foo);
	System.out.println(foo);
	check(foo);
	
    }
}
    
