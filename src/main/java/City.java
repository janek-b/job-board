import java.util.ArrayList;
import java.util.List;

public class City {
  private String mName;
  private int mId;
  private List<JobOpening> mJobs;
  private static List<City> instances = new ArrayList<City>();


  public City(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
    mJobs = new ArrayList<JobOpening>();
  }

  public String getName() {
    return mName;
  }

  public int getId() {
    return mId;
  }

  public List<JobOpening> getJobs() {
    return mJobs;
  }

  public void addJob(JobOpening newJob) {
    mJobs.add(newJob);
  }

  public static List<City> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static City find(int id) {
    return instances.get(id - 1);
  }

}
