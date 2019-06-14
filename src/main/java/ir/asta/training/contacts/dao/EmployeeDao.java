package ir.asta.training.contacts.dao;

import ir.asta.training.contacts.entities.EmployeeEntity;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by win_8.1 on 6/5/2019.
 */

@Named("employeeDao")
public class EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Inject
    ContactDao contactDao;


    public EmployeeEntity getEmployeeByEmail(String email) {
        String entityName = "EmployeeEntity";
        return (EmployeeEntity) entityManager.createQuery("select e from " + entityName + " e where e.email = :email")
                .setParameter("email", email)
                .getResultList()
                .get(0);

    }

    public List<EmployeeEntity> getAllEmployees() {
        String entityName = "EmployeeEntity";
        String queryStr = "select new ir.asta.training.contacts.entities.EmployeeEntity(e.email, e.name, e.semat) from " + entityName + " e";
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(queryStr, EmployeeEntity.class);
        List<EmployeeEntity> results = query.getResultList();
        return results;
    }


    public boolean Register(EmployeeEntity entity) {

        int result = contactDao.CheckMail(entity.getEmail());

        if (result == 0) {
            entityManager.persist(entity);
            return true;
        } else {
            return false;
        }
    }
}
