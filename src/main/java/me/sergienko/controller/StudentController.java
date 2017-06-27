package me.sergienko.controller;

import me.sergienko.model.Student;
import me.sergienko.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "students", method = RequestMethod.GET)
    public String listStudent(Model model){
        model.addAttribute("listStudents", this.studentService.listStudents());

        return "students";
    }
}
