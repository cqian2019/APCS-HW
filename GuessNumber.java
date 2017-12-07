//Cheryl Qian
//APCS pd2
//HW48 -- Keep Guessing
//2017-12-06

/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
	_lo = a;
	_hi = b;
	_guessCtr = 1;
	_target = _lo +(int)(Math.random()*((_hi-_lo) + 1));
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() 
    {
	System.out.println("Guess a number from " + _lo + " to " + _hi);
	int guess = Keyboard.readInt();
	if ( guess != _target ) {
	    _guessCtr++;
	    if ( guess < _target ) {
		System.out.println("Too low, try again...");
		_lo = guess + 1;
		playRec();
	    }
	    else {
		System.out.println("Too high, try again...");
		_hi = guess - 1;
		playRec();
	    }
	}
	else {
	    System.out.println( guess + " is correct! It took " + _guessCtr + " guesses.");
	}
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
	int guess = _lo - 1;
	while ( guess != _target ) {
	    System.out.println("Guess a number from " + _lo + " to " + _hi);
	    guess = Keyboard.readInt();
	    _guessCtr++;
	    if ( guess < _target ) {
		System.out.println("Too low, try again...");
		_lo = guess + 1;	        
	    }
	    else {
		System.out.println("Too high, try again...");
		_hi = guess - 1;
	    }
	}
	
	    System.out.println( guess + " is correct! It took " + _guessCtr + " guesses.");
	    
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 
	//use one or the other below:
	//playRec();
	playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {
	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();
    }//end main

}//end class
