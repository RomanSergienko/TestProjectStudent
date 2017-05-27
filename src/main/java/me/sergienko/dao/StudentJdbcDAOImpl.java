package me.sergienko.dao;

import me.sergienko.model.Student;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentJdbcDAOImpl  implements StudentDAO{

    public Integer createStudent(Student student) {
        return null;
    }


    public Student getStudent(Integer id) {

        Connection connection = null;
        Student st =  new Student();
        String select = "SELECT * FROM students WHERE id="+id;

        try {
            connection = new GetterConnect().getConnection();
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
        Connection connection = null;
        String delete = "DELETE FROM students WHERE id=" + id;

        try {
            connection = new GetterConnect().getConnection();
            Statement  statement = connection.createStatement();
            statement.execute(delete);

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

    }


    public void updateStudent(Student student) {

    }


    public List<Student> listStudents() {
        List<Student> studentList  = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet;
        String select = "SELECT * FROM students";

        try {
            connection = new GetterConnect().getConnection();
            Statement  statement = connection.createStatement();
            resultSet = statement.executeQuery(select);
            while(resultSet.next()) {
                Student st = new Student();
                st.setGroup_id(resultSet.getInt("group_id"));
                st.setName(resultSet.getString("name"));
                st.setSur_name(resultSet.getString("sur_name"));
                st.setRating_ege(resultSet.getDouble("exam_result"));
                st.setEnrolment_date(resultSet.getDate("enrolment_date"));
                studentList.add(st);
            }

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
       return studentList;
    }

}
