package me.sergienko.dao;

import me.sergienko.config.BeanConfig;
import me.sergienko.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfig.class)
public class StudentJdbcDAOImplTest {

    @Autowired
    private StudentDAO studentDAO;

    @Test
    public void crudStudent() throws Exception {
        //Test createStudent
        Student student = new Student();
        student.setGroupId(100);
        student.setName("John");
        student.setSurName("Petrucci");
        student.setRatingEge(100.00);
        GregorianCalendar calendar = new GregorianCalendar(1980, 2, 2);
        student.setEnrolmentDate(calendar.getTime());
        Integer id = studentDAO.createStudent(student);
        assertNotNull("Method 'createStudent' returns  null id", id);

        //Test getStudent
        Student student1 = studentDAO.getStudent(student.getId());
        assertNotNull("Student id NULL", student1.getId());
        assertEquals("Method 'getStudent' returns invalid data: 'id'", student.getId(), student1.getId());
        assertEquals("Method 'getStudent' returns invalid data: 'name'", student.getName(), student1.getName());
        assertEquals("Method 'getStudent' returns invalid data: 'surName'", student.getSurName(), student1.getSurName());
        assertEquals("Method 'getStudent' returns invalid data: 'groupId'", student.getGroupId(), student1.getGroupId());
        assertEquals("Method 'getStudent' returns invalid data: 'ratingEge'", student.getRatingEge(), student1.getRatingEge(), 0);
        assertEquals("Method 'getStudent' returns invalid data: 'EnrolmentDate'", student.getEnrolmentDate(), student1.getEnrolmentDate());

        //Test deleteStudent
        studentDAO.deleteStudent(student.getId());
        Student student2 = studentDAO.getStudent(student.getId());
        assertNull("Method 'deleteSudent' doesn't delete row", student2);

        //Test updateStudent
        int i2 = studentDAO.createStudent(student);
        assertTrue(i2 != 0);
        student1.setId(i2);
        student1.setGroupId(150);
        student1.setName("Joe");
        student1.setSurName("Satriani");
        student1.setRatingEge(150.00);
        GregorianCalendar calendar1 = new GregorianCalendar(1958, 3, 4);
        student1.setEnrolmentDate(calendar1.getTime());
        studentDAO.updateStudent(student1);
        student = studentDAO.getStudent(i2);
        assertEquals("Method 'getStudent' returns invalid data: 'id'", student.getId(), student1.getId());
        assertEquals("Method 'getStudent' returns invalid data: 'name'", student.getName(), student1.getName());
        assertEquals("Method 'getStudent' returns invalid data: 'surName'", student.getSurName(), student1.getSurName());
        assertEquals("Method 'getStudent' returns invalid data: 'groupId'", student.getGroupId(), student1.getGroupId());
        assertEquals("Method 'getStudent' returns invalid data: 'ratingEge'", student.getRatingEge(), student1.getRatingEge(), 0);
        assertEquals("Method 'getStudent' returns invalid data: 'EnrolmentDate'", student.getEnrolmentDate(), student1.getEnrolmentDate());
        studentDAO.deleteStudent(student1.getId());

        //Test listStudents
        List<Student> students = studentDAO.listStudents();
        for (Student st : students) {
            System.out.println(st);
        }
        assertFalse("Method 'listStudents' return empty array", students.isEmpty());
    }
}

