package me.sergienko;


import me.sergienko.config.BeanConfig;
import me.sergienko.dao.StudentJdbcDAOImpl;
import me.sergienko.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class StudentApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        StudentJdbcDAOImpl bean = context.getBean(StudentJdbcDAOImpl.class);
        List<Student> students = bean.listStudents();
        for (Student st : students) {
            System.out.println(st);
        }
    }
}
