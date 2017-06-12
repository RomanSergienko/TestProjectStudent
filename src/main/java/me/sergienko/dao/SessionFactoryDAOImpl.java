package me.sergienko.dao;


import me.sergienko.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SessionFactoryDAOImpl implements StudentDAO {

    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
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
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> variableRoot = query.from(Student.class);
        query.select(variableRoot);

        return entityManager.createQuery(query).getResultList();
    }
}
