package controllers;

import db.DBHelper;
import db.Seeds;
import models.Student;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class StudentController {
    public static void main(String[] args) {
        staticFileLocation("public");
        InstructorController instructorController = new InstructorController();
        Seeds.seedData();

        get("/students", (req, res)-> {
            Map<String, Object> model = new HashMap();
            List<Student> students = DBHelper.getAll(Student.class);
            model.put("template", "templates/students/index.vtl");
            model.put("students", students);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
