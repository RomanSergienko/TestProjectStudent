package me.sergienko.dao;

import me.sergienko.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component

public class StudentJdbcDAOImpl implements StudentDAO {

    private DataSource dataSource;

    @Autowired
    public StudentJdbcDAOImpl(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    @Override
    public Integer createStudent(Student student) {
        String insertSql = "INSERT INTO students (id,group_id,name,sur_name,exam_result,enrolment_date)"
                + " VALUES(nextval('id'),?,?,?,?,?)";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement st = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {

            st.setInt(1, student.getGroupId());
            st.setString(2, student.getName());
            st.setString(3, student.getSurName());
            st.setDouble(4, student.getRatingEge());
            st.setDate(5, new Date(student.getEnrolmentDate().getTime()));

            st.executeUpdate();

            ResultSet genKeys = st.getGeneratedKeys();
            if (genKeys.next()) {
                student.setId(genKeys.getInt(1));
            }
        } catch (Exception ex) {
            throw new RuntimeException("Create student failed!");
        }

        return student.getId();
    }

    @Override
    public Student getStudent(Integer id) {
        Student student = null;
        String select = "SELECT * FROM students WHERE id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(select)) {

            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                student = createStudentFromResultSet(resultSet);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Get student failed!");
        }
        return student;
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

    @Override
    public void deleteStudent(Integer id) {
        String delete = "DELETE FROM students WHERE id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(delete)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception ex) {
            throw new RuntimeException("Delete student failed!");
        }
    }

    @Override
    public void updateStudent(Student student) {
        String update = "UPDATE students SET group_id=?, name=?, sur_name=?, exam_result=?, enrolment_date=? WHERE id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(update)) {

            preparedStatement.setInt(1, student.getGroupId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSurName());
            preparedStatement.setDouble(4, student.getRatingEge());
            preparedStatement.setDate(5, new Date(student.getEnrolmentDate().getTime()));
            preparedStatement.setInt(6, student.getId());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("Update student failed!");
        }
    }

    @Override
    public List<Student> listStudents() {
        List<Student> studentList = new ArrayList<>();
        ResultSet resultSet;
        String select = "SELECT * FROM students";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Student st = createStudentFromResultSet(resultSet);
                studentList.add(st);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Getting list of student failed!");
        }
        return studentList;
    }

    @Override
    public Integer getStudentCount() {
        int result = 0;
        String selectCount = "SELECT COUNT(*) FROM students";
        try (Connection connection = dataSource.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet genKeys = st.executeQuery(selectCount);
            if (genKeys.next()) {
                result=genKeys.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Student> listStudents(Integer limit, Integer offset) {
        List<Student> studentListLimitOffset = new ArrayList<>();
        ResultSet resultSet;
        String selectLimitOffset = "SELECT * FROM students LIMIT ? OFFSET ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectLimitOffset)) {
            statement.setInt(1, limit);
            statement.setInt(2,offset);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student st = createStudentFromResultSet(resultSet);
                studentListLimitOffset.add(st);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Getting list of student with limit and offset failed!");
        }
        return studentListLimitOffset;
    }
}
