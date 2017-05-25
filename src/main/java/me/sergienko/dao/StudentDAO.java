package me.sergienko.dao;

import me.sergienko.model.Student;

import java.util.List;

/**
 * Created by Роман on 25.05.2017.
 */
public interface StudentDAO {
    Integer createStudent(Student student);

    Student getStudent(Integer id);

    void deleteStudent(Integer id);

    void updateStudent(Student student);

    List<Student> listStudents();
}
