package ir.asta.training.contacts.dao;

/**
 * Created by win_8.1 on 5/18/2019.
 */
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.entities.ContactEntity;
import ir.asta.training.contacts.entities.StudentEntity;

@Named("studentDao")
public class StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    ContactDao contactDao;
    CaseDao caseDao;

    public boolean Register(StudentEntity entity) {

        int result = contactDao.CheckMail(entity.getEmail());

        if(result==0) {
            entityManager.persist(entity);
            return true;
        }else{
            return false;
        }
    }

    public ContactEntity load(Long id) {
        // TODO implement this method
        return null;
    }

    public StudentEntity getStudentByEmail(String email, String password){
        String entityName = "StudentEntity";
        return (StudentEntity) entityManager.createQuery("select e from " + entityName + " e where e.email = :email AND e.password = :password")
                .setParameter("email", email)
                .setParameter("password",password)
                .getResultList()
                .get(0);

    }

    public List<StudentEntity> findAll() {
        // TODO implement this method
        String entityName = "StudentEntity";
        List<StudentEntity> students = entityManager.createQuery("select e from " + entityName + " e").getResultList();
        return students;

    }

}
