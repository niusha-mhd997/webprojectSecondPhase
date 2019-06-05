package ir.asta.training.contacts.dao;

import ir.asta.training.contacts.entities.EmployeeEntity;
import ir.asta.training.contacts.entities.StudentEntity;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by win_8.1 on 6/5/2019.
 */

@Named("employeeDao")
public class EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;


    public EmployeeEntity getEmployeeByEmail(String email){
        String entityName = "EmployeeEntity";
        return (EmployeeEntity) entityManager.createQuery("select e from " + entityName + " e where e.email = :email")
                .setParameter("email", email)
                .getResultList()
                .get(0);

    }

}
