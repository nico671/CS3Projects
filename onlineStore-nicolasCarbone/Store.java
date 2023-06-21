/*Implement the following functionality into the store:

  instance variables: 
    profit: how much money the store has made
    items:  instance variable (could be an array or LinkedList or ArrayList of one of the other classes)

  methods:
    showItems: displays all items available for sale
    addItem: adds an item for sale
    sellItem(itemName): removes the item from the store and adds its price to profit
    creator(itemName): displays who created the item in question

    You will need to include the following information to be stored in the inheritance heiarchy using the other classes:
      name of thing being sold
      price for things that are on sale
      names of creators of movies and books
      date of birth of book authors
      date that things are placed on sale
      duration of movies
      publisher of books

    Where these variables are stored and how to name them is up to you!
*/
import java.util.ArrayList;

public class Store {

  private ArrayList<ItemForSale> storeItems = new ArrayList<ItemForSale>();

  public void showItems() {
    for (ItemForSale item : storeItems) {
      System.out.println(item.getItemName());
    }
  }

  public ArrayList<ItemForSale> getStoreItems() {
    return storeItems;
  }

  public void addItem(ItemForSale newItem) {
    storeItems.add(newItem);
  }

  public ItemForSale sellItem(String itemName) {
    for (int i = 0; i < storeItems.size(); i++) {
      ItemForSale item = storeItems.get(i);
      if (item.getItemName() == itemName) {
        storeItems.remove(i);
        System.out.println(i);
        return item;
      }
    }
    return null;
  }

  public int differentItemsCount(String itemName) {
    int counter = 0;
    for (ItemForSale item : storeItems) {
      if (item.getItemName() == itemName) {
        counter++;
      }
    }
    return counter;
  }

  public String getCreator(String itemName) {
    String returnString = "";
    for (ItemForSale item : storeItems) {
      if (item.getItemName() == itemName) {
        returnString = item.getCreatorName();
      }
    }
     return returnString;
  }
 

}
