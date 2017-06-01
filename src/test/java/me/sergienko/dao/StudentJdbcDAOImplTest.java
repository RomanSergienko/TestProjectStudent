package me.sergienko.dao;

import me.sergienko.model.Student;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.MethodSorters;

import java.sql.Date;
import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(BlockJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentJdbcDAOImplTest {
    static StudentJdbcDAOImpl studentJdbcDAO = new StudentJdbcDAOImpl();
    static Student student = new Student();

    @Test
    public void a_createStudent() throws Exception {

        student.setGroupId(100);
        student.setName("John");
        student.setSurName("Petrucci");
        student.setRatingEge(100.00);
        student.setEnrolmentDate(new Date(Calendar.getInstance().getTimeInMillis()));
        Integer id = studentJdbcDAO.createStudent(student);
        assertTrue("Method 'createStudent' return  null id", id != null);
    }

    @Test
    public void b_getStudent() throws Exception {
        Student student1 = studentJdbcDAO.getStudent(student.getId());
        assertEquals(student.getId(), student1.getId());


    }

    @Test
    public void c_deleteStudent() throws Exception {
        studentJdbcDAO.deleteStudent(student.getId());
        Student student1 = studentJdbcDAO.getStudent(student.getId());
        assertTrue(student1 == null);
    }

    @Test
    public void d_updateStudent() throws Exception {
        System.out.println("Test updateStudent");


    }

    @Test
    public void e_listStudents() throws Exception {
        System.out.println("Test listStudents");

    }

}