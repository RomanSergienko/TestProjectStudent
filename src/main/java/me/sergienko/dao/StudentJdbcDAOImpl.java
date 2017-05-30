package me.sergienko.dao;

import me.sergienko.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//TODO replace all statement on prepared statement
//TODO close statements
//TODO use try with resources
//TODO read naming convention


public class StudentJdbcDAOImpl implements StudentDAO {

    public Integer createStudent(Student student) {
        Connection connection = null;
        String insertSql = "INSERT INTO students (id,group_id,name,sur_name,exam_result,enrolment_date)"
                + "VALUES(nextval('id'),?,?,?,?,?) RETURNING id";


        try {
            connection = new ConnectionGetter().getConnection();
            PreparedStatement st = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, student.getGroupId());
            st.setString(2, student.getName());
            st.setString(3, student.getSurName());
            st.setDouble(4, student.getRatingEge());
            st.setDate(5, (Date) student.getEnrolmentDate());

            st.executeUpdate();
            st.close();

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
        Student st = null;
        String select = "SELECT * FROM students WHERE id=" + id;

        try {
            connection = new ConnectionGetter().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);

            while (resultSet.next()) {
                st = createStudentFromResultSet(resultSet);
            }
            statement.close();

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

    private Student createStudentFromResultSet(ResultSet resultSet) throws SQLException {
        Student st = new Student();
        st.setId(resultSet.getInt("id"));
        st.setGroupId(resultSet.getInt("group_id"));
        st.setName(resultSet.getString("name"));
        st.setSurName(resultSet.getString("sur_name"));
        st.setRatingEge(resultSet.getDouble("exam_result"));
        st.setEnrolmentDate(resultSet.getDate("enrolment_date"));
        return st;
    }


    public void deleteStudent(Integer id) {
        Connection connection = null;
        String delete = "DELETE FROM students WHERE id=" + id;

        try {
            connection = new ConnectionGetter().getConnection();
            Statement statement = connection.createStatement();
            statement.execute(delete);
            statement.close();

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
                + student.getGroupId() + ", name='"
                + student.getName() + "', sur_name='"
                + student.getSurName() + "', exam_result="
                + student.getRatingEge() + ", enrolment_date='"
                + student.getEnrolmentDate() + "' WHERE id="
                + student.getId();
        try {
            connection = new ConnectionGetter().getConnection();
            Statement statement = connection.createStatement();
            statement.execute(update);
            statement.close();

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
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet;
        String select = "SELECT * FROM students";

        try {
            connection = new ConnectionGetter().getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Student st = createStudentFromResultSet(resultSet);
                studentList.add(st);
            }
            statement.close();

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
