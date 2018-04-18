//Team Cookie Monsters
//Roster: Cheryl Qian, Sophia Xia
//APCS2 pd1
//HW36 -- Now Let's Consider You Lot at Fake Terry's
//2018-04-17

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/

//getValue()
//getNext()
//setValue(T newCargo)
//setNext(LLNode<T> newNext)
//toString()

public class RQueue<T> implements Queue<T>{

  //instance variables
  private LLNode<T> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue() {
    _front = new LLNode<T>(null,null);
    _end = new LLNode<T>(null,null);
    _size = 0;

  }//end default constructor


  public void enqueue( T enQVal ){
    LLNode<T> newNode = new LLNode<T>(enQVal,null);
    if(_size == 0){
      _front = newNode;
      _end = _front;
    }
    else if ( _size == 1 ) {
	_front.setNext(newNode);
	_end = newNode;
    }
    else {
	_end.setNext(newNode);
	_end = newNode;
    }
    _size++;
  }//end enqueue()


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue(){
      T temp = front();
      _front = _front.getNext();
      _size--;
      return temp;
  }//end dequeue()


  public T front() {
      sample();
      return _front.getValue();
  }


  /******************************************
  * void sample() -- a means of "shuffling" the queue
  * Algo:
  * 1. Create dummy node and traverse to a random node
  * 2. Set the value of the first node to the value of the random node 
  * 3. Set the value of the random node to the first node
  * 4. ???
  * 5. Profit
  ******************************************/
  public void sample (){
      LLNode<T> dummy = new LLNode<T>(null, _front);
      int r = (int) (Math.random() * _size) + 1;
    for ( int i = 0; i < r; i++ )
	//makes the head of dummy node point to the next node in the list
	dummy = dummy.getNext();
    //change value of the _first node
    T temp = _front.getValue();
    _front.setValue(dummy.getValue());
    //change value of the node the dummy is pointing to
    dummy.setValue(temp);    
  }//end sample()
  

  public boolean isEmpty(){
    return _size == 0;
  } //O(?)

  
  public T peekFront(){
    return _front.getValue();
  }
  
  // print each node, separated by spaces
    public String toString(){ 
        int i = 0;
      String ret = " ";
      LLNode<T> temp = _front;
      while ( i < _size ) {
        ret += " " + temp.getValue();
        temp = temp.getNext();
	i++;
     	 }
      return ret;
    }//end toString()

  
  
  //main method for testing
  public static void main( String[] args )
  {
   
    
    Queue<String> PirateQueue = new RQueue<String>();
    
    System.out.println("\nnow enqueuing..."); 
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Robert");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");
    
    System.out.println("\nnow testing toString()..."); 
    System.out.println( PirateQueue ); //for testing toString()...
    
    System.out.println("\nnow dequeuing..."); 
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    
    System.out.println("\nnow dequeuing fr empty queue..."); 
    System.out.println( PirateQueue.dequeue() );
     /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
    ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    
  }//end main
  
}//end class RQueue
