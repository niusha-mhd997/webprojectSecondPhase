package ir.asta.training.contacts.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ir.asta.training.contacts.entities.ContactEntity;

@Named("contactDao")
public class ContactDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(ContactEntity entity) {
        entityManager.persist(entity);
    }


    public int CheckMail(String email) {

        String entityName = "StudentEntity";
        Query q1 = entityManager.createQuery("select e from " + entityName + " e WHERE e.email = :email");
        q1.setParameter("email", email);
        int s1 = q1.getResultList().size();

        String entityName2 = "ManagerEntity";
        System.out.println(entityManager);
        Query q2 = entityManager.createQuery("select e from " + entityName2 + " e WHERE e.email = :email");
        q2.setParameter("email", email);
        int s2 = q2.getResultList().size();

        String entityName3 = "EmployeeEntity";
        Query q3 = entityManager.createQuery("select e from " + entityName3 + " e WHERE e.email = :email");
        q3.setParameter("email", email);
        int s3 = q3.getResultList().size();

        return s1 + s2 + s3;

    }


    public int Login(String email, String password) {

        if( CheckMail(email) == 0){
            //not found
            System.out.println("-1");
            return -1;

        }

        String entityName = "StudentEntity";
        Query q1 = entityManager.createQuery("select e from " + entityName + " e WHERE" +
                " e.email = :email AND e.password = :password");
        q1.setParameter("email", email);
        q1.setParameter("password", password);
        int s1 = q1.getResultList().size();


        String entityName2 = "ManagerEntity";
        Query q2 = entityManager.createQuery("select e from " + entityName2 + " e WHERE" +
                " e.email = :email AND e.password = :password");
        q2.setParameter("email", email);
        q2.setParameter("password", password);
        int s2 = q2.getResultList().size();


        String entityName3 = "EmployeeEntity";
        Query q3 = entityManager.createQuery("select e from " + entityName3 + " e WHERE" +
                " e.email = :email AND e.password = :password");
        q3.setParameter("email", email);
        q3.setParameter("password", password);
        int s3 = q3.getResultList().size();

        if ((s1 + s2 + s3) == 0) {
            // wrong pawwword
            System.out.println("0");
            return 0;
        }

        if (s1 == 1) {
            //student
            System.out.println("1");
            return 1;
        }
        if (s2 == 1) {
            //manager
            System.out.println("2");
            return 2;
        }
        if (s3 == 1) {
            //employee
            String entityName4 = "EmployeeEntity";
            Query q4 = entityManager.createQuery("select e.permission from " + entityName4 + " e WHERE" +
                    " e.email = :email AND e.password = :password");
            int per = (int) q4.getResultList().get(0);
            if(per == 1){
                System.out.println("3");
                return 3;
            }
            if(per == 0){
                System.out.println("4");
                return 4;
            }

        }

        return -1;

    }


    public ContactEntity load(Long id) {
        // TODO implement this method
        return null;
    }

    public List<ContactEntity> findAll(String entityName) {
        // TODO implement this method
        System.out.println(entityManager);
        return entityManager.createQuery("select e from " + entityName + " e")
                .setMaxResults(100)
                .getResultList();
    }



}
