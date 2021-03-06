//Cheryl Qian
//APCS pd1
//HW32 -- Leon Leonwood Stack
//2019-04-12 R\
/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr 
{
    public static void main( String[] args )
    {
        
	//--------LLStack Test Cases------------//
	System.out.println("===========LLSTACK===========");
	Stack cakepops = new LLStack<String>();
	cakepops.push("A");
	cakepops.push("B");
	cakepops.push("C");
	cakepops.push("D");

	System.out.println(cakepops.pop()); //D
	System.out.println(cakepops.pop()); //C

	System.out.println(cakepops.peek()); //B
	
	System.out.println(cakepops.pop()); //B

	System.out.println(cakepops.peek()); //A
	
	System.out.println(cakepops.pop()); //A

	System.out.println(cakepops.peek()); //null
	
	System.out.println(cakepops.isEmpty()); //true
	cakepops.push("soup"); 
	System.out.println(cakepops.isEmpty()); //false
	
	System.out.println("===============================");

	System.out.println("==============ALSTACK===========");
	Stack lollipops = new ALStack<String>();
	lollipops.push("A");
	lollipops.push("B");
	lollipops.push("C");
	lollipops.push("D");

	System.out.println(lollipops.pop()); //D
	System.out.println(lollipops.peek()); //C
	System.out.println(lollipops.isEmpty()); //false
	lollipops.pop(); //C
	lollipops.pop(); //B
	System.out.println(lollipops.isEmpty()); //false
	lollipops.pop(); //A
	System.out.println(lollipops.isEmpty()); //true
	System.out.println("=================================");
	
    }//end main

}//end class

