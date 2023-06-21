import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie extends ItemForSale {

  private String creatorName;
  // minutes
  private Double runtime;

  Movie() {
    super();
    creatorName = "Steven Spielberg";
    runtime = 125.0;
  }

  Movie(String setItemName, Double setItemPrice, Date setDatePutOnSale, String setCreatorName, Double setRuntime) {
    super(setItemName, setItemPrice, setDatePutOnSale);
    creatorName = setCreatorName;
    runtime = setRuntime;
  }

  public String getCreatorName() {
    return creatorName;
  }

  public Double getRuntime() {

    return runtime;
  }

}
