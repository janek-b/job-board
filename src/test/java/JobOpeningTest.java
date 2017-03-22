import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class JobOpeningTest {

  @Test
  public void JobOpening_instantiatedCorrectly() {
    JobOpening newJob = new JobOpening("title", "description", "contact", "2017-08-18");
    assertEquals(true, newJob instanceof JobOpening);
  }

  @Test
  public void getTitle_returnsCorrectly_String() {
    JobOpening newJob = new JobOpening("title", "description", "contact", "2017-08-18");
    assertEquals("title", newJob.getTitle());
  }

  @Test
  public void getDescription_returnsCorrectly_String() {
    JobOpening newJob = new JobOpening("title", "description", "contact", "2017-08-18");
    assertEquals("description", newJob.getDescription());
  }

  @Test
  public void getContact_returnsCorrectly_String() {
    JobOpening newJob = new JobOpening("title", "description", "contact", "2017-08-18");
    assertEquals("contact", newJob.getContact());
  }

  @Test
  public void getDate_returnsLocalDateObject() {
    JobOpening newJob = new JobOpening("title", "description", "contact", "2017-08-18");
    LocalDate date = LocalDate.parse("2017-08-18");
    assertEquals(date, newJob.getDate());
  }

  @Test
  public void getDaysLeft_returnsNumberOfDays_1() {
    LocalDate date = LocalDate.now().plusDays(1);
    JobOpening newJob = new JobOpening("title", "description", "contact", date.toString());
    assertEquals(1, newJob.getDaysLeft());
  }

}
