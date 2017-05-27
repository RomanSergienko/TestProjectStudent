package me.sergienko.dao;

import me.sergienko.model.Student;


import java.sql.*;
import java.util.List;


public class StudentJdbcDAOImpl implements StudentDAO{

    public Integer createStudent(Student student) {


        return null;
    }


    public Student getStudent(Integer id) {

        Student st =  new Student();
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String name = "postgres";
        String password = "postgres";
        String select = "SELECT * FROM students WHERE id="+id;

        try {

            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, name, password);

            Statement  statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);


            st.setGroup_id(resultSet.getInt("group_id"));
            st.setName(resultSet.getString("name"));
            st.setSur_name(resultSet.getString("sur_name"));
            st.setRating_ege(resultSet.getDouble("exam_result"));
            st.setEnrolment_date(resultSet.getDate("enrolment_date"));



        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return st;
    }


    public void deleteStudent(Integer id) {


    }


    public void updateStudent(Student student) {

    }


    public List<Student> listStudents() {
        return null;
    }






}
