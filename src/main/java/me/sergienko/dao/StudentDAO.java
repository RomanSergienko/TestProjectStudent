package me.sergienko.dao;

import me.sergienko.model.Student;

import java.util.List;


public interface StudentDAO {
    Integer createStudent(Student student);

    Student getStudent(Integer id);

    void deleteStudent(Integer id);

    void updateStudent(Student student);

    List<Student> listStudents();
}
