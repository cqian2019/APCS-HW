/***
Cheryl Qian
APCS pd2
HW38 -- Put It Together
2017-11-21
***/

/******************************************
My version of Swapper takes a preset, constant array with 3 rows and 4 columns 
as the initial parameter. I wrote a function to print any string arrays called print.
In the main method, I created an instance of array to check if it's been modified, 
and to end the while loop if it does.

The user is prompted to enter the coordinates of their desired swap, and class Keyboard
converts it into a string. I used substring and parseInt to convert the string coordinates
to int coordinates after pinpointing their location (taking into account parentheses and
spaces). Instances of the two specified strings prevent the actual array from being prematurely
modified, and the values are swapped, before the array is printed again. Since the while loop
condition apparently doesn't work, though, I guess the user can keep modifiying the array until
they manually break it with an exception.


 *****************************************/
import cs1.Keyboard;
public class Swapper {
    
    private static final String[][] array = new String[][] {
	{"cat","dog","fox","yak"},
	{"yam","egg","oat","fig"},
	{"zig","zag","jig","jag"}
    };

    public static void print(String[][] s) {
	int rows = s.length;
	int columns = s[0].length;
	String str = "";
	
	for(int x = 0; x < rows; x++){
	    for(int y = 0; y < columns; y++){
		str += s[x][y];
	    }
	}

	for(int x = 0; x < rows; x++)
	    {
		for(int y = 0; y < columns; y++)
		    {
			System.out.print(s[x][y] + " ");
		    }
		System.out.println();
	    }
	System.out.println();
    }
    
    public static void main(String[] args) {
	String str = "";
	String[][] s = array;
	while (array.equals(s)) {
	    System.out.println("Current array:");
	    print(array);
	    
	    System.out.println("Input the locations of two items to swap: (x1y1) (x2y2)");
	    str = Keyboard.readString();

	    int a = Integer.parseInt(str.substring(1,2));
	    int b = Integer.parseInt(str.substring(2,3));
	    int c = Integer.parseInt(str.substring(6,7));
	    int d = Integer.parseInt(str.substring(7,8));

	    String sw = array[a][b];
	    String ap = array[c][d];

	    array[c][d] = sw;
	    array[a][b] = ap;

	    System.out.println("New array:");

	    print(array);
	}
    }

}
