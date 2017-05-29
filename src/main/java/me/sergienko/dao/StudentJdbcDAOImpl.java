package me.sergienko.dao;

import me.sergienko.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class StudentJdbcDAOImpl  implements StudentDAO{

    public Integer createStudent(Student student) {
        Connection connection = null;
        String insertSql = "INSERT INTO students (id,group_id,name,sur_name,exam_result,enrolment_date)"
                + "VALUES(nextval('id'),?,?,?,?,?) RETURNING id";


        try {
            connection = new GetterConnect().getConnection();
            PreparedStatement st = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, student.getGroup_id());
            st.setString(2, student.getName());
            st.setString(3, student.getSur_name());
            st.setDouble(4, student.getRating_ege());
            st.setDate(5, (Date) student.getEnrolment_date());

            st.executeUpdate();

            ResultSet genKeys = st.getGeneratedKeys();
            if (genKeys.next()) {
                student.setId(genKeys.getInt(1));
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

        return student.getId();
    }


    public Student getStudent(Integer id) {

        Connection connection = null;
        Student st =  new Student();
        String select = "SELECT * FROM students WHERE id="+id;

        try {
            connection = new GetterConnect().getConnection();
            Statement  statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);

            while (resultSet.next()){
                st.setId(resultSet.getInt("id"));
                st.setGroup_id(resultSet.getInt("group_id"));
                st.setName(resultSet.getString("name"));
                st.setSur_name(resultSet.getString("sur_name"));
                st.setRating_ege(resultSet.getDouble("exam_result"));
                st.setEnrolment_date(resultSet.getDate("enrolment_date"));
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
        Connection connection = null;
        String update = "UPDATE students SET group_id="
                + student.getGroup_id() + ", name='"
                + student.getName() + "', sur_name='"
                + student.getSur_name() + "', exam_result="
                + student.getRating_ege() + ", enrolment_date='"
                + student.getEnrolment_date() + "' WHERE id="
                + student.getId();
        try {
            connection = new GetterConnect().getConnection();
            Statement  statement = connection.createStatement();
            statement.execute(update);

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
                st.setId(resultSet.getInt("id"));
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

    //for testing
    public static void main(String[] args) {
        StudentJdbcDAOImpl studentJdbcDAO = new StudentJdbcDAOImpl();
        Student st = new Student();
        st.setGroup_id(150);
        st.setName("Лера");
        st.setSur_name("Лысова");
        st.setRating_ege(80.99);
        st.setEnrolment_date(new Date(Calendar.getInstance().getTimeInMillis()));
        System.out.println(studentJdbcDAO.createStudent(st));
    }

}
