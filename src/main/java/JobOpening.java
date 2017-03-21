import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class JobOpening {
  private String mTitle;
  private String mDescription;
  private String mContact;
  private LocalDate mDate;


  public JobOpening(String title, String description, String contact, String date) {
    mTitle = title;
    mDescription = description;
    mContact = contact;
    mDate = LocalDate.parse(date);
  }

  public String getTitle() {
    return mTitle;
  }

  public String getDescription() {
    return mDescription;
  }

  public String getContact() {
    return mContact;
  }

  public LocalDate getDate() {
    return mDate;
  }

  public long getDaysLeft() {
    LocalDate now = LocalDate.now();
    return now.until(mDate, ChronoUnit.DAYS);
  }
}
