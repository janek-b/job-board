import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import java.util.ArrayList;
import java.util.List;
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

    get("/city", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String cityFilter = request.queryParams("city");
      List<City> currentCity = new ArrayList<City>();
      if (cityFilter.equals("all")) {
        model.put("currentCity", City.all());
      } else {
        City city = City.find(Integer.parseInt(cityFilter));
        currentCity.add(city);
        model.put("currentCity", currentCity);
      }
      model.put("cities", City.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/jobs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      City city = City.find(Integer.parseInt(request.queryParams("city")));

      String title = request.queryParams("title");
      String description = request.queryParams("description");
      String contact = request.queryParams("contact");
      String date = request.queryParams("start-date");
      JobOpening job = new JobOpening(title, description, contact, date);
      city.addJob(job);

      model.put("currentCity", City.all());
      model.put("cities", City.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/jobs/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("cities", City.all());
      model.put("template", "templates/job-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/cities", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      name = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
      if (!City.exists(name)) {
        City city = new City(name);
      }
      model.put("currentCity", City.all());
      model.put("cities", City.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/cities/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/city-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
