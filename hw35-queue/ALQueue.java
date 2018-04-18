/*
  Team Last Supper - Cheryl Qian, Lily Yan
  APCS2 pd1
  HW35 - ...Nor Do Aussies
  2018-04-16
*/

import java.util.ArrayList;

public class ALQueue<Quasar> implements Queue<Quasar> {

    //instance variables
    ArrayList<Quasar> _queue;
    int _headIndex; //prevents having to use methods with linear runtime
    
    //constructor
    public ALQueue() {
	_queue = new ArrayList<Quasar>(); //empty at birth
	_headIndex = 0; //at birth, front element should be the head of the queue
    }

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public Quasar dequeue() {
	if (isEmpty()) return null; //return null if empty
        Quasar ans = _queue.get(_headIndex); //get element at head of queue, which is at _headIndex (not necessarily at beginning of ArrayList)
	_headIndex += 1; //adjust which part of the array represents the queue by moving the head index to the right by one
	return ans;
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue(Quasar x) {
	_queue.add(x); //add x to the end of the ArrayList
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty() {
	return (_headIndex >= _queue.size()); //if _headIndex equals size of ArrayList, it has gone past the last element of the ArrayList. This means there's nothing in the queue itself.
    }

    //Returns the first element of the queue without dequeuing it.
    public Quasar peekFront() {
	if (isEmpty()) return null; //return nothing if empty
	return _queue.get(_headIndex); //return element at head index
    }
    
    public static void main(String[] args) {

	ALQueue<String> quiche = new ALQueue<String>();

	System.out.println("\nThe stack is empty: " + quiche.isEmpty());

	quiche.enqueue("vanilla");
	quiche.enqueue("chocolate");
	quiche.enqueue("strawberry");
	quiche.enqueue("caramel");
	quiche.enqueue("lemon");
	quiche.enqueue("redvelvet");
	quiche.enqueue("carrot");
	quiche.enqueue("coffee");
	quiche.enqueue("icecream");
	quiche.enqueue("matcha");

	System.out.println("\nThe stack is STILL empty: " + quiche.isEmpty());

	//vanilla
	System.out.println("\nElement at front: " + quiche.peekFront());
	System.out.println("Element dequeued: " + quiche.dequeue() + "\n");
	//chocolate
	System.out.println("Element at front: " + quiche.peekFront());
	System.out.println("Element dequeued: " + quiche.dequeue() + "\n");
	//strawberry
	System.out.println("Element at front: " + quiche.peekFront());
	System.out.println("Element dequeued: " + quiche.dequeue() + "\n");
	//caramel
	System.out.println("Element at front: " + quiche.peekFront());
	System.out.println("Element dequeued: " + quiche.dequeue() + "\n");
	//lemon
	System.out.println("Element at front: " + quiche.peekFront());
	System.out.println("Element dequeued: " + quiche.dequeue() + "\n");
	//redvelvet
	System.out.println("Element at front: " + quiche.peekFront());
	System.out.println("Element dequeued: " + quiche.dequeue() + "\n");
	//carrot
	System.out.println("Element at front: " + quiche.peekFront());
	System.out.println("Element dequeued: " + quiche.dequeue() + "\n");
	//coffee
	System.out.println("Element at front: " + quiche.peekFront());
	System.out.println("Element dequeued: " + quiche.dequeue() + "\n");
	//icecream
	System.out.println("Element at front: " + quiche.peekFront());
	System.out.println("Element dequeued: " + quiche.dequeue() + "\n");
	//matcha
	System.out.println("Element at front: " + quiche.peekFront());
	System.out.println("Element dequeued: " + quiche.dequeue() + "\n");

	//tester for when queue is empty:
	System.out.println("Element at front: " + quiche.peekFront());
	System.out.println("Element dequeued: " + quiche.dequeue() + "\n");	
	
	/* ~~~~~~~~~~~~~~ MOVE ME DOWN ~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~YOU MADE IT ~~~~~~~~~~~~~~*/	
    }
}
