package me.sergienko.dao;

import me.sergienko.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class StudentJdbcDAOImplTest {


    @Test
    public void crudStudent() throws Exception {
        StudentJdbcDAOImpl studentJdbcDAO = new StudentJdbcDAOImpl();
        //Test createStudent
        Student student = new Student();
        student.setGroupId(100);
        student.setName("John");
        student.setSurName("Petrucci");
        student.setRatingEge(100.00);
        student.setEnrolmentDate(new java.util.Date());
        Integer id = studentJdbcDAO.createStudent(student);
        assertNotNull("Method 'createStudent' returns  null id", id);

        //Test getStudent
        Student student1 = studentJdbcDAO.getStudent(student.getId());
        assertEquals("Method 'getStudent' returns invalid data", student.getId(), student1.getId());
        //TODO assert all fields

        //Test deleteStudent
        studentJdbcDAO.deleteStudent(student.getId());
        Student student2 = studentJdbcDAO.getStudent(student.getId());
        assertNull("Method 'deleteSudent' doesn't delete row", student2);
        //Test updateStudent
        studentJdbcDAO.createStudent(student);
        Student student3 = new Student();
        student3.setGroupId(150);
        student3.setName("Joe");
        student3.setSurName("Satriani");
        student3.setRatingEge(150.00);
        student3.setEnrolmentDate(new Date());
        studentJdbcDAO.updateStudent(student3);
        studentJdbcDAO.deleteStudent(student3.getId());
        //TODO add asserts
        //Test listStudents
        List<Student> students = studentJdbcDAO.listStudents();
        for (Student st : students) {
            System.out.println(st);
        }

    }
}

