import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Author {

  private String name;
  private Date dateOfBirth;
  
  Author() {
    name = "John Doe";
    dateOfBirth = new Date((long) 1000);
  }
  
  Author(String setName, Date setDateOfBirth) {
    name = setName;
    dateOfBirth = setDateOfBirth;
  }
  


  public String getName() {
    return name;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

}