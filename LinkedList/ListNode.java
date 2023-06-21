public class ListNode {
  // instance properties

  private Object value;
  private ListNode next;
  private ListNode previous;

  // constructor

  public ListNode(Object initValue, ListNode initNext, ListNode initPrevious)
  // pre-condition: initValue is a valid Object and initNext is valid ListNode.
  // post-condition: value equals initValue and next equals initNext.
  {
    value = initValue;
    next = initNext;
    previous = initPrevious;
    return;
  }

  // accessors

  public Object getValue()
  // pre-condition: value is either null or a valid Object.
  // post-condition: value is returned.
  {
    return value;
  }

  public ListNode getNext()
  // pre-condition: next is either null or a valid ListNode.
  // post-condition: next is returned.
  {
    return next;
  }

  public ListNode getPrevious()
  // pre-condition: previous is either null or a valid ListNode.
  // post-condition: previous is returned.
  {
    return previous;
  }

  // mutators

  public void setValue(Object theNewValue)
  // pre-condition: theNewValue is a valid Object.
  // post-condition: value equals theNewValue.
  {
    value = theNewValue;
  }

  public void setNext(ListNode theNewNext)
  // pre-condition: theNewNext is a valid ListNode.
  // post-condition: next equals theNewNext.
  {
    next = theNewNext;
  }

  public void setPrevious(ListNode theNewPrevious)
  // pre-condition: theNewNext is a valid ListNode.
  // post-condition: next equals theNewNext.
  {
    previous = theNewPrevious;
  }
}