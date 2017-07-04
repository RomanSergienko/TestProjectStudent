package me.sergienko.controller;

import me.sergienko.model.Student;
import me.sergienko.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "students", method = RequestMethod.GET)
    public String listStudent(Model model){
        int rowsOnPage = 20;
        model.addAttribute("listStudents", this.studentService.listStudents());
        int recCount = (int) Math.ceil(this.studentService.getRecordsCount()*1.0/rowsOnPage);
        model.addAttribute("allpage", recCount);

        return "students";
    }

    @RequestMapping(value = "/addstudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student")Student student){
        if(student.getId()==0)
            this.studentService.createStudent(student);
        else {
            this.studentService.updateStudent(student);
        }
        return "redirect:/students";
    }

    @RequestMapping(value = "delete/{id}")
    public String  deleteStudent(@PathVariable("id")int id){
        this.studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @RequestMapping(value = "edit/{id}")
    public String  editStudent(@PathVariable("id")int id,Model model){
        model.addAttribute("student",this.studentService.getStudent(id));
        return "editstudent";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

}
