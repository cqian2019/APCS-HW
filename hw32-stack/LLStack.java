//Cheryl Qian
//APCS2 pd1
//HW #32: Leon Leonwood Stack
//2018-04-12

import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE> {

    private LinkedList<PANCAKE> _stack; 
    private int _stackSize; 

    public LLStack(){
	_stack = new LinkedList<PANCAKE>();
	_stackSize = 0;
    }

    public boolean isEmpty(){
	return _stackSize == 0;
    }

    public PANCAKE peek(){
	if ( !isEmpty() ) {
	    return _stack.get(_stackSize - 1);
	}
	return null;
    }

    public PANCAKE pop(){
	if( !isEmpty() ){ 
	    PANCAKE top = _stack.get(_stackSize - 1); 
	    _stack.remove(_stackSize - 1);
	    _stackSize--; 
	    return top;
	}
	return null;
    }
    
    public void	push( PANCAKE x ){
	_stack.add(x);
	_stackSize += 1; 
    }

}

