package me.sergienko.dao;

import me.sergienko.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class SessionFactoryDAOImpl implements StudentDAO {


    private SessionFactory sessionFactory;

    @Autowired
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
    @Transactional(readOnly = true)
    public Student getStudent(Integer id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
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
    @Transactional(readOnly = true)
    public List<Student> listStudents() {
        Session session = sessionFactory.getCurrentSession();

        return (List<Student>) session.createCriteria(Student.class).list();
    }

    @Override
    @Transactional
    public Integer getRecordsCount () {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Student.class);
        criteria.setProjection(Projections.rowCount());
        return Integer.parseInt(criteria.list().get(0).toString());
    }
}
