import java.util.*;
import java.io.*;

public class HashTable {

    private int tableSize = 100;
    private String[][] table = new String[tableSize][1];
    private int fillLevel = 0;

    // iterator stuff

    
    // Methods you have to supply:
    // precondition: table exists
    // postcondition: adds key to hashtable unless key already exists
    public void put(String key) {

        int arrayIndex = getArrayIndexFromKey(key);


        if (table[arrayIndex] == null) {

            String[] newList = {key};
            table[arrayIndex] = newList;
             fillLevel++;

        } else {

            String[] array = table[arrayIndex];
            List arrList = new ArrayList(Arrays.asList(array));
            arrList.add(key);
            table[arrayIndex] = (String[]) arrList.toArray(array);
        }
     

    }

    // precondition: table exists
    // postcondition: returns the value of the key you are looking for if it exists in the hastable
    public String get(String key) {
        int arrayIndex = getArrayIndexFromKey(key);

        if (table[arrayIndex][table[arrayIndex].length - 1] == null) {

            return "Nothing at this index (does key exist?)";

        } else {
            return table[arrayIndex][table[arrayIndex].length - 1];
        }

    }

  // precondition: table exists
  // postcondition: removes the key value pair as long as it exists within the hastable
    public String remove(String key){
        int arrayIndex = getArrayIndexFromKey(key);

        if (table[arrayIndex][table[arrayIndex].length - 1] == null) {

            return "Nothing at this index (does key exist?)";

        } else {
            table[arrayIndex][table[arrayIndex].length - 1] = null;
            return table[arrayIndex][table[arrayIndex].length - 1];
        }
    }

    public Iterator<String> iterator()
    {
        return new ListIterator<String>(table);
    }
    

    public void print() {
        for (int i = 0; i < table.length - 1; i++) {
          for (int j = 0; j < table[i].length - 1; j++) {
            String data = table[i][j];
            if (data != null) {
              System.out.println("Key: " + data + " value: " + data);
            }
          }
        }
    }

    private int getArrayIndexFromKey(String key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % tableSize;
    }


  

    // private boolean isloadFactorPassable
    /**
     * Loads this HashTable from a file named "Lookup.dat".
     */
    // public void load() {
    // FileReader fileReader;
    // BufferedReader bufferedReader = null;

    // // Open the file for reading
    // try {
    // File f = new File(System.getProperty("user.home"), "Lookup.dat");
    // fileReader = new FileReader(f);
    // bufferedReader = new BufferedReader(fileReader);
    // }
    // catch (FileNotFoundException e) {
    // System.err.println("Cannot find input file \"Lookup.dat\"");
    // }

    // // Read the file contents and save in the HashTable
    // try {
    // while (true) {
    // String key = bufferedReader.readLine();
    // if (key == null) return;
    // String value = bufferedReader.readLine();
    // if (value == null) {
    // System.out.println("Error in input file");
    // System.exit(1);
    // }
    // String blankLine = bufferedReader.readLine();
    // if (!"".equals(blankLine)) {
    // System.out.println("Error in input file");
    // System.exit(1);
    // }
    // put(key, value);
    // }
    // }
    // catch (IOException e) {
    // e.printStackTrace(System.out);
    // }

    // // Close the file when we're done
    // try {
    // bufferedReader.close( );
    // }
    // catch(IOException e) {
    // e.printStackTrace(System.out);
    // }
    // }

    // /**
    // * Saves this HashTable onto a file named "Lookup.dat".
    // */
    // public void save() {
    // FileOutputStream stream;
    // PrintWriter printWriter = null;
    // Iterator iterator;

    // // Open the file for writing
    // try {
    // File f = new File(System.getProperty("user.home"), "Lookup.dat");
    // stream = new FileOutputStream(f);
    // printWriter = new PrintWriter(stream);
    // }
    // catch (Exception e) {
    // System.err.println("Cannot use output file \"Lookup.dat\"");
    // }

    // // Write the contents of this HashTable to the file
    // iterator = keys();
    // while (iterator.hasNext()) {
    // String key = (String)iterator.next();
    // printWriter.println(key);
    // String value = (String)get(key);
    // value = removeNewlines(value);
    // printWriter.println(value);
    // printWriter.println();
    // }

    // // Close the file when we're done
    // printWriter.close( );
    // }

    /**
     * Replaces all line separator characters (which vary from one platform
     * to the next) with spaces.
     * 
     * @param value The input string, possibly containing line separators.
     * @return The input string with line separators replaced by spaces.
     */
    // private String removeNewlines(String value) {
    //     return value.replaceAll("\r|\n", " ");
    // }
}


class ListIterator<T> implements Iterator<T> {
    T[][] list;
    int i = 0;
    int j = 0;
    // initialize pointer to head of the list for iteration
    public ListIterator(T[][] inTable)
    {
        list = inTable;
    }
      
    // returns false if next element does not exist
    public boolean hasNext()
    {
        if (list[i][j] != null) {
          return true;
        } else {
          if (setLocationOfNext() == null) {
            return false;
          }
        }
      return false;
    }
      
    // return current data and update pointer
    public T next()
    {
        T data = list[i][j];
        setLocationOfNext();
        return data;
    }
      
    // implement if needed
    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    private T setLocationOfNext() {
      while (i < list.length) {
            while (j < list[i].length) {
              if (list[i][j] != null) {
                return list[i][j];
              }
              j++;
            }
            i++;
          }
      return null;
    }
}