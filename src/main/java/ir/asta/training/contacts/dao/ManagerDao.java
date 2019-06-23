package ir.asta.training.contacts.dao;

import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.entities.EmployeeEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@Named("managerDao")
public class ManagerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public String AcceptEmployee(int token) {
        String entityName = "EmployeeEntity";

        Query query = entityManager.createQuery(
                "update " + entityName + " e SET e.permission = true " +
                        "WHERE e.token = :token")
                .setParameter("token", token);

        int rowsUpdated = query.executeUpdate();

        if (rowsUpdated == 1) {
            return "با موفقیت تایید شد";

        } else {
            //etminan
            return "خطا";
        }
    }




    public List<EmployeeEntity> getAllPermittedEmployees() {
        String entityName = "EmployeeEntity";
        String queryStr = "select new ir.asta.training.contacts.entities.EmployeeEntity(e.email, e.name, e.semat) from "
                + entityName + " e where e.permission = true";
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(queryStr, EmployeeEntity.class);
        List<EmployeeEntity> results = query.getResultList();
        return results;
    }



    public List<EmployeeEntity> getAllNotPermittedEmployees() {
        String entityName = "EmployeeEntity";
        String queryStr = "select new ir.asta.training.contacts.entities.EmployeeEntity(e.email, e.name, e.semat) from "
                + entityName + " e where e.permission = false";
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(queryStr, EmployeeEntity.class);
        List<EmployeeEntity> results = query.getResultList();
        return results;
    }

}
