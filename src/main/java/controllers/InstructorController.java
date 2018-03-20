package controllers;
import db.DBHelper;
import models.Instructor;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;



public class InstructorController {

    public InstructorController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {
        get("/instructors", (req, res) -> {
            Map<String, Object> model = new HashMap();
            List<Instructor> instructors = DBHelper.getAll(Instructor.class);
            model.put("template", "templates/instructors/index.vtl");
            model.put("instructors", instructors);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
