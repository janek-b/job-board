import org.junit.*;
import static org.junit.Assert.*;

public class CityTest {

  @Test
  public void City_instantiatesCorrectly() {
    City testCity = new City("portland");
    assertEquals(true, testCity instanceof City);
  }

  @Test
  public void getName_returnsCorrectly_String() {
    City testCity = new City("portland");
    assertEquals("portland", testCity.getName());
  }

  @Test
  public void all_returnsAllInstancesOfCity_true() {
    City firstCity = new City("portland");
    City secondCity = new City("denver");
    assertEquals(true, City.all().contains(firstCity));
    assertEquals(true, City.all().contains(secondCity));
  }

  @Test
  public void clear_emptiesAllCitiesFromList_0() {
    City testCity = new City("portland");
    City.clear();
    assertEquals(City.all().size(), 0);
  }

  @Test
  public void getId_citiesInstantiateWithAnId_1() {
    City testCity = new City("portland");
    assertEquals(1, testCity.getId());
  }

  @Test
  public void find_returnsCityWithSameId_secondCity() {
    City.clear();
    City firstCity = new City("portland");
    City secondCity = new City("denver");
    assertEquals(City.find(secondCity.getId()), secondCity);
  }

  @Test
  public void getJobs_initiallyReturnsEmptyList_ArrayList() {
    City.clear();
    City testCity = new City("portland");
    assertEquals(0, testCity.getJobs().size());
  }

  @Test
  public void addJob_addsJobToList_true() {
    City.clear();
    City testCity = new City("portland");
    JobOpening testJob = new JobOpening("title", "description", "contact", "2017-08-18");
    testCity.addJob(testJob);
    assertTrue(testCity.getJobs().contains(testJob));
  }

}
