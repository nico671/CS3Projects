
//This file contains an example of how to read user input. Use this in conjunction with your linked list class to test your program.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    // LinkedList list = new LinkedList();
    // list.addAValue("a");
    // list.addAValue("c");
    // list.addAValue("b");
    // list.addAValue("b");
    // list.addAValue("b");
    // list.addAValue("c");
    // System.out.println("List: " + list.showValues(list.getHead()));
    // System.out.println("Size: " + list.getSize(list.getHead()));

    // System.out.println("List: " + list.showValues(list.getHead()));
    // list.reverseList(list.getHead());
    // System.out.println("List Reversed: " + list.showValues(list.getHead()));
    // list.nReverse(4);
    // System.out.println("List Reversed Every 4 Nodes: " + list.showValues(list.getHead()));
    // System.out.println("clearing list");
    // list.clear();
    // System.out.println(list.showValues(list.getHead()));
    // Enter data using BufferReader
    BufferedReader reader = new BufferedReader(
    new InputStreamReader(System.in));

    // Reading data using readLine
    LinkedList list = new LinkedList();
    String input= reader.readLine();
    while(!input.equals("exit"))
    {
    if(input.length()>3 && input.substring(0, 3).equals("add"))
    {
    System.out.println(list.addAValue(input.substring(4)));
    }
    else if(input.equals("show"))
    {
    System.out.println(list.showValues());
    }

      
    else if(input.length() > 6 && input.substring(0, 7).equals("reverse")){
    System.out.println("reversing ");
    list.reverseList(list.getHead());
    }
    else if(input.length() > 7 && input.substring(0, 6).equals("remove")){
    System.out.println("removing "+input.substring(7));
    System.out.println(list.deleteAValue(input.substring(7)));
    }
      
    else if(input.length() > 8 && input.substring(0, 8).equals("nreverse")){
    System.out.println("reversing "+input.substring(9));
    list.nReverse(Integer.parseInt(input.substring(9)));
    }
    else if(input.equals("clear"))
    {
    list.clear();
    }
    else if(!input.equals("exit")){
    System.out.println("I don't know how to "+input);
    }
    input= reader.readLine();
    }

    // Printing the read line
    System.out.println("thanks for playing!");
  }
}