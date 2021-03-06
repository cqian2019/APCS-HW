import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE> {

    private ArrayList<PANCAKE> _stack; 
    private int _stackSize; 

    public ALStack(){
	_stack = new ArrayList<PANCAKE>();
	_stackSize = 0;
    }

    public boolean isEmpty(){
	return _stackSize == 0;
    }

    public PANCAKE peek(){
	return _stack.get(_stackSize - 1);
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


