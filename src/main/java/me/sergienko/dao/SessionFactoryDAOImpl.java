package me.sergienko.dao;

import me.sergienko.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository

public class SessionFactoryDAOImpl implements StudentDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Integer createStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
        return student.getId();
    }

    @Override
    @Transactional
    public Student getStudent(Integer id) {
        Student student = sessionFactory.getCurrentSession().get(Student.class, id);
        return student;
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.load(Student.class, id);
        if (student != null) {
            session.delete(student);
        }
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        sessionFactory.getCurrentSession().update(student);
    }

    @Override
    @Transactional
    public List<Student> listStudents() {
        Session session = sessionFactory.getCurrentSession();
        List<Student> studentsList = session.createCriteria(Student.class).list();

        return studentsList;
    }
}
