package me.sergienko.dao;

import me.sergienko.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SessionFactoryDAOImpl implements StudentDAO {

    @Autowired
    SessionFactory sessionFactory;

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Integer createStudent(Student student) {
        this.getCurrentSession().persist(student);
        return student.getId();
    }

    @Override
    public Student getStudent(Integer id) {
        Student student = (Student) this.getCurrentSession().load(Student.class, id);
        return student;
    }

    @Override

    public void deleteStudent(Integer id) {
        Session session = this.getCurrentSession();
        Student student = (Student) session.load(Student.class, id);
        if (student!=null)
        {
            session.delete(student);
        }
    }

    @Override
    public void updateStudent(Student student) {
        this.getCurrentSession().update(student);
    }

    @Override
    public List<Student> listStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> contactRoot = criteria.from(Student.class);
        criteria.select(contactRoot);
        List<Student> studentsList = session.createQuery(criteria).getResultList();

        return studentsList;
    }
}
