import java.text.SimpleDateFormat;
import java.util.Date;

public class Book extends ItemForSale {

  private String publisher;
  private Author author;

  Book() {
    super();
    author = new Author("John Doe", new Date((long) 100000));
    publisher = "Best Publishers";
  }

  Book(String setItemName, Double setItemPrice, Date setDatePutOnSale, Author setAuthor, String setPublisher) {
    super(setItemName, setItemPrice, setDatePutOnSale);
    author = setAuthor;
    publisher = setPublisher;
  }

  public String getCreatorName() {
    return author.getName();
  }

  public Author getAuthor() {
    return author;
  }

  public String getPublisherName() {
    return publisher;
  }

}