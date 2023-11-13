package com.example.repositorydemo.repository.student;

import com.example.repositorydemo.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Queue;

@Repository
@Transactional
public class StudentRepository implements IStudentRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("select c from Student c", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findById(Long id) {
        TypedQuery<Student> query = entityManager.createQuery("select c from Student c where c.id =:id ", Student.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Student student) {
        if (student.getId() != null) {
            entityManager.merge(student);//update
        } else {
            entityManager.persist(student);//create
        }
    }

    @Override
    public void remove(Long id) {
        Student student = findById(id);
        if(student != null){
            entityManager.remove(student);
        }
    }

    @Override
    public boolean saveWithStoredProcedure(Student student) {
        String sql = "CALL Insert_Student(:dob, :gender, :name)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("dob", student.getDob());
        query.setParameter("gender", student.getGender());
        query.setParameter("name", student.getName());
        return query.executeUpdate() != 0;
    }
}
