package me.sergienko;


import me.sergienko.config.BeenConfig;
import me.sergienko.dao.StudentJdbcDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeenConfig.class);
        StudentJdbcDAOImpl bean = context.getBean(StudentJdbcDAOImpl.class);
        System.out.println(bean.getStudent(1));
    }
}
