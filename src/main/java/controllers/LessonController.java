package controllers;

import db.DBHelper;
import models.Lesson;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class LessonController {

    public LessonController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {
        get("/lessons", (req, res) -> {
            Map<String, Object> model = new HashMap();
            List<Lesson> lessons = DBHelper.getAll(Lesson.class);
            model.put("template", "templates/lessons/index.vtl");
            model.put("lessons", lessons);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }

}
