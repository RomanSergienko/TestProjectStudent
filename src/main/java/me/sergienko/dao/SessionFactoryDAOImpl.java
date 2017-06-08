package me.sergienko.dao;


import me.sergienko.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SessionFactoryDAOImpl implements StudentDAO {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Integer createStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        int id = (int) session.save(student);
        student.setId(id);

        return id;
    }

    @Override
    public Student getStudent(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.load(Student.class, id);
    }

    @Override
    public void deleteStudent(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = session.load(Student.class, id);
        if (student != null)
            session.delete(student);

    }

    @Override
    public void updateStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(student);
    }

    @Override
    public List<Student> listStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from students").list();
    }
}
