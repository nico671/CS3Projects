import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class ItemForSale {
  private String itemName;
  private Double itemPrice;
  private Date datePutOnSale;
  
  ItemForSale() {
    itemName = "Harry Potter";
    itemPrice = 19.99;
    datePutOnSale = new Date();
  }
  
  ItemForSale(String setItemName, Double setItemPrice, Date setDatePutOnSale) {
    itemName = setItemName;
    itemPrice = setItemPrice;
    datePutOnSale = setDatePutOnSale;
  }

  String getItemName() {
    return itemName;
  }

  Double getItemPrice() {
    return itemPrice;
  }

  Date getDatePutOnSale() {
    return datePutOnSale;
  }

  abstract public String getCreatorName();
  

}
