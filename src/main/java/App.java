import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import java.util.ArrayList;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.time.LocalDate;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/job", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<JobOpening> jobs = request.session().attribute("jobs");
      if (jobs == null) {
        jobs = new ArrayList<JobOpening>();
        request.session().attribute("jobs", jobs);
      }

      String title = request.queryParams("title");
      String description = request.queryParams("description");
      String contact = request.queryParams("contact");
      String date = request.queryParams("start-date");
      JobOpening job = new JobOpening(title, description, contact, date);
      jobs.add(job);

      model.put("jobs", jobs);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
