package me.sergienko.service;

import me.sergienko.dao.StudentDAO;
import me.sergienko.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDAO studentDAO;

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public Integer createStudent(Student student) {
        return null;
    }

    @Override
    public Student getStudent(Integer id) {
        return null;
    }

    @Override
    public void deleteStudent(Integer id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public List<Student> listStudents() {
        return null;
    }
}
