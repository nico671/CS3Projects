import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Main {
  // Your tests go here! I expect you to make sure various parts of your program
  // work.

  public static void main(String[] args) {
    Store s = new Store();
    for (int i = 0; i < 5; i++) {
      if (i % 2 == 0) {
        s.addItem(new Book("Harry Potter and The Philosopher's Stone", 15.99, new Date((long) 1000000), new Author("JK Rowling", new Date()), "Bloomsbury Publishing"));
      }
      else {
        s.addItem(new Movie("Star Wars: A New Hope", 20.99, new Date((long) 0), "George Lucas", 105.00));
      }
    }

    s.showItems();

    System.out.println("Selling A Star Wars Movie");
    s.sellItem("Star Wars: A New Hope");

    System.out.println(s.getStoreItems().get(0).getCreatorName());
    System.out.println(s.getStoreItems().get(2).getCreatorName());

    System.out.println(s.getStoreItems().get(2).getItemPrice());
    System.out.println(s.getStoreItems().get(2).getDatePutOnSale().toString());

    Book b = (Book) s.getStoreItems().get(0);
    System.out.println(b.getAuthor().getName());
    System.out.println(b.getAuthor().getDateOfBirth());
    System.out.println(b.getPublisherName());

    Movie m = (Movie) s.getStoreItems().get(2);
    System.out.println(m.getRuntime());
    
  }
}