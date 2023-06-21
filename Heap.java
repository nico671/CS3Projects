import java.io.*;
import java.util.*;
public class Heap {

  // the actual storage structure for your heap

  private int[] arr;

  private int fillLevel = 0;

  // constructor for your heap

  // feel free to make one that takes in an array if you prefer for your testing
  // purposes.

  // note that we will not be inserting more than 100 elements into our array so
  // you need not worry about re-sizing

  // the array

  public Heap() {

    arr = new int[100];

  }

  // create this function to add elements to your heap

  // all heap properties must be preserved

  // 5 points
  // precondition: a valid int is passed into the method
  // postcondition: adds the int to the heap and restores the heap characteristics all the way up the tree
  public void add(int toAdd) {
    arr[++fillLevel] = toAdd;

    int current = fillLevel;
    siftUp(current);
  }

  // remove the largest element of the heap (the root) and re-heapify

  // 5 points
    // precondition: array has at least 1 node
    // postcondition: removes the top node and restores the heap characteristics all the way down the tree
    public void extractMax() {
      if (arr.length > 0) {
         arr[0] = arr[fillLevel--];
        siftDown(0);
      }
       

    }


  // this should check and alter the tree after an item is inserted

  // 3 points
  // precondition: a node was just added to the tree
  // postcondition: the heap requirements have been restored
  private void siftUp(int index) {
    int temp = arr[index];
    while (index > 0 && temp > arr[parent(index)]) {
      arr[index] = arr[parent(index)];
      index = parent(index);
    }
    arr[index] = temp;
  }

  // this should check and alter the tree after an item is deleted.

  // 3 points

  // precondition: a node was just deleted from the tree
  // postcondition: the heap requirements have been restored
  private void siftDown(int index) {
    if (index >= (fillLevel / 2) && index <= fillLevel)
      return;

    if (arr[index] < arr[leftChild(index)] ||
        arr[index] < arr[rightChild(index)]) {

      if (arr[leftChild(index)] > arr[rightChild(index)]) {
        swap(index, leftChild(index));
        siftDown(leftChild(index));
      } else {
        swap(index, rightChild(index));
        siftDown(rightChild(index));
      }
    }
  }

  // helper function to return the position of a given nodes parent
  private int parent(int index) {
    return (index - 1) / 2;
  }

  // helper function to return the position of a given nodes left child
  private int leftChild(int index) {
    return ((index - 1) / 2) + 1;
  }

  // helper function to return the position of a given nodes right child
  private int rightChild(int index) {
    return ((index - 1) / 2) + 2;
  }

  // helper function to swap 2 nodes
  private void swap(int first, int second) {
    int temp;
    temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }

  public void print() {
    System.out.println(Arrays.toString(arr));
  }

  // 4 points for syntax conventions.
}