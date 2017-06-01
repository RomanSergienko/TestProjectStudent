package me.sergienko.dao;

import me.sergienko.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.sql.Date;

import static org.junit.Assert.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class StudentJdbcDAOImplTest {
    @Test
    public void createStudent() throws Exception {
        StudentJdbcDAOImpl studentJdbcDAO = new StudentJdbcDAOImpl();
        Student student = new Student();
        student.setId(1);
        student.setGroupId(100);
        student.setName("John");
        student.setSurName("Petrucci");
        student.setRatingEge(100.00);
        student.setEnrolmentDate(new Date(2000, 10, 10));

        assertTrue("createStudent return  null id", studentJdbcDAO.createStudent(student) != null);
    }

    @Test
    public void getStudent() throws Exception {

    }

    @Test
    public void deleteStudent() throws Exception {

    }

    @Test
    public void updateStudent() throws Exception {

    }

    @Test
    public void listStudents() throws Exception {

    }

}