package me.sergienko.dao;


import me.sergienko.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class SessionFactoryDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Integer createStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        int id = (int) session.save(student);
        student.setId(id);

        return id;
    }

    @Override
    @Transactional
    public Student getStudent(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.load(Student.class, id);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = session.load(Student.class, id);
        if (student != null)
            session.delete(student);

    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(student);
    }

    @Override
    @Transactional
    public List<Student> listStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaQuery<Student> criteriaQuery = session.getCriteriaBuilder().createQuery(Student.class);
        criteriaQuery.from(Student.class);
        List<Student> studentsList = session.createQuery(criteriaQuery).getResultList();
        return studentsList;
    }
}
