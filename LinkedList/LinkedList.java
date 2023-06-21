/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/
public class LinkedList {

  // instance varialbes go here (think about what you need to keep track of!)
  private ListNode head;

  // constructors go here
  LinkedList() {
    head = null;
  }

  // precondition: the list has been initialized
  // postcondition: the ListNode containing the appropriate value has been added
  // and returned
  public ListNode addAValue(String line) {
    ListNode currentNode;
    currentNode = head;
    if (head == null) {
      head = new ListNode(line, null, null);
      return null;
    } else {
      while (head != null) {
        if (currentNode.getNext() == null) {
          currentNode.setNext(new ListNode(line, null, currentNode));
          currentNode.getNext().setPrevious(currentNode);
          break;
        } else {
          if (line.compareTo(currentNode.getNext().getValue().toString()) < 0 &&
            line.compareTo(currentNode.getValue().toString()) >= 0) {
            ListNode newNode = new ListNode(line, null, null);
            // 1, 2, ^3, 4
            // 2 next must equal 3 and 4 previous must equal 3
            newNode.setNext(currentNode.getNext());
            newNode.setPrevious(currentNode);
            currentNode.getNext().setPrevious(newNode);
            currentNode.setNext(newNode);
            break;
          } else {
            currentNode = currentNode.getNext();
          }

        }
      }
    }

    return currentNode;
  }

  public ListNode addAValueAtEnd(String line) {
    ListNode currentNode;
    currentNode = head;
    if (head == null) {
      head = new ListNode(line, null, null);
      return null;
    } else {
      while (head != null) {
        if (currentNode.getNext() == null) {
          currentNode.setNext(new ListNode(line, null, currentNode));
          currentNode.getNext().setPrevious(currentNode);
          break;
        } else {
          currentNode = currentNode.getNext();
        }

      }
    }

    return currentNode;
  }

  // precondition: the list has been initialized
  // postcondition: the ListNode containing the appropriate value has been deleted
  // and returned.
  // if the value is not in the list returns null
  public ListNode deleteAValue(String line) {
    ListNode currentNode;
    if (head == null) {
      return null;
    } else {
      currentNode = head;
      while (head != null) {
        if (currentNode.getNext() != null) {
          if (currentNode.getValue().toString() == line) {
            if (currentNode.equals(head)) {
              head = currentNode.getNext();
              head.setPrevious(null);
              return head;
            } else {
              System.out.println("found node " + currentNode.getValue());
              currentNode.getPrevious().setNext(currentNode.getNext());
              currentNode.getNext().setPrevious(currentNode.getPrevious());
              return currentNode;
            }
          } else {
            currentNode = currentNode.getNext();
          }
        } else {
          if (currentNode.getValue().toString().equals(line)) {
            currentNode.getPrevious().setNext(null);
            return currentNode;
          } else {
            return currentNode;
          }
        }
      }
    }
    return currentNode;
  }

  // precondition: the list has been initialized
  // postconditions: returns a string containing all values appended together with
  // spaces between.
  public String showValues(ListNode inputHead) {
    ListNode currentNode;
    String returnString = "";
    if (inputHead == null) {
      return "haha ur dumb it doesn't exist";
    } else {
      currentNode = inputHead;
      while (true) {
        if (currentNode.getNext() != null) {
          // System.out.println(currentNode.getValue());
          returnString += currentNode.getValue().toString();
          currentNode = currentNode.getNext();
        } else {
          returnString += currentNode.getValue().toString();
          break;
        }
      }
    }
    return returnString;
  }

  // spaces between.
  public String showValues() {
    ListNode currentNode;
    ListNode inputHead = head;
    String returnString = "";
    if (inputHead == null) {
      return "haha ur dumb it doesn't exist";
    } else {
      currentNode = inputHead;
      while (true) {
        if (currentNode.getNext() != null) {
          // System.out.println(currentNode.getValue());
          returnString += currentNode.getValue().toString();
          currentNode = currentNode.getNext();
        } else {
          returnString += currentNode.getValue().toString();
          break;
        }
      }
    }
    return returnString;
  }
  
  // precondition: the list has been initialized
  // postconditions: reverses the list.
  public void reverseList(ListNode inputHead) {
    ListNode previousNode = inputHead;
    ListNode currentNode = inputHead.getNext();
    ListNode tailNode = null;
    if (inputHead == null) {
      return;
    } else {
      while (currentNode != null) {
        ListNode nextNode = currentNode.getNext();
        currentNode.setNext(previousNode);
        previousNode = currentNode;
        currentNode = nextNode;
      }
      tailNode = inputHead;
      tailNode.setNext(null);
      inputHead = previousNode;
    }
    head = inputHead;
  }

  public int getSize(ListNode inputHead) {
    int i = 0;
    ListNode currentNode = inputHead;
    while (currentNode != null) {
      currentNode = currentNode.getNext();
      // System.out.println(i);
      i++;
    }

    return i;
  }

  public void nReverse(int n) {

    if (n < 2 || head == null) {
      return;
    }

    ListNode currentNode = head;
    clear();
    while (currentNode != null) {
      LinkedList newList = new LinkedList();
      System.out.print(".");
      for (int i = 0; i < n; i++) {
        if (currentNode.getNext() == null) {
          newList.addAValueAtEnd(currentNode.getValue().toString());
          currentNode = currentNode.getNext();
          break;
        } else {
          // System.out.print(currentNode.getValue());
          newList.addAValueAtEnd(currentNode.getValue().toString());
          currentNode = currentNode.getNext();
        }
      }
      
      System.out.println(showValues(newList.getHead()));
      newList.reverseList(newList.getHead());
      ListNode workerHead = newList.getHead();
      System.out.println(showValues(workerHead));

      while (workerHead != null) {
        if (workerHead.getNext() != null) {
          addAValueAtEnd(workerHead.getValue().toString());
          workerHead = workerHead.getNext();
        } else {
          addAValueAtEnd(workerHead.getValue().toString());
          break;
        }
      }

      

      workerHead = null;

    }
  }

  // precondition: the list has been initialized
  // postconditions: clears the list.
  public void clear() {
    if (head == null) {
      return;
    } else {
      head = null;
    }
  }

  public ListNode getHead() {
    return head;
  }
}