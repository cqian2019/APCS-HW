/******************************
 Team Art Heart -- Cheryl Qian and Nadine Jackson
 APCS1 pd2
 HW54 -- One File to Bring Them All...
 2017-12-13
 ******************************/
import java.util.ArrayList;
/*
BubbleSort:
-The best case scenario for bubble sort would be to have an input that is already sorted. While the same number of comparisons would be made because it has to check if a swap needs to be made at each pair of elements for each pass, there would be no swaps, and swaps are "expensive" in memory terms.
-The worst case scenario would be that the list is sorted in descending order because each pair of elements would be swapped every time.

SelectionSort:
-No matter what the input, this algorithm makes the same number of comparisons and swaps, even if an elemant "swaps" with itself, or the list is already in order. Therefore, there is no best nor worst case.

InsertionSort:
-The best case scenario would be that the ArrayList is already ordered because during each pass, when the algorithm "walks the element down" to its final resting place, the element is already there, and there is the minimum number or comparisons (1) and swaps (0) each time.
 */
 
public class SortTester{
    public static void main(String[] args){
        ArrayList<Comparable> test = new ArrayList<Comparable>();
        test.add(29);
        test.add(6);
        test.add(5);
        test.add(4);
        test.add(0);
        test.add(-2);
        
        System.out.println("Initial ordering of test (worst case scenario for BubbleSort):\n" + test);
        MySorts.bubbleSort(test);
        System.out.println("After BubbleSorting test, this is what we have:\n" + test);
        MySorts.shuffle(test);
        System.out.println("After shuffling test:\n" + test);
        MySorts.selectionSort(test);
        System.out.println("After SelectionSorting test, this is what we have:\n" + test);
        MySorts.shuffle(test);
        System.out.println("After shuffling test:\n" + test);
        MySorts.insertionSort(test);
        System.out.println("After InsertionSorting test, this is what we have:\n" + test);
           
        test.set(0, 38);
        test.set(1, 17);
        test.set(2, 16);
        test.set(3, 16);
        test.set(4, 0);
        test.set(5, -2);
        System.out.println("After manually setting values in test to be in descending order:\n" + test);
        MySorts.insertionSort(test);
        System.out.println("After using InsertionSort on this ArrayList (worst case scenario):\n" + test);
         MySorts.insertionSort(test);
        System.out.println("After using InsertionSort on this ArrayList (best case scenario (already sorted)):\n" + test);
        
    }
}

