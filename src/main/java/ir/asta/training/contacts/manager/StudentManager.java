package ir.asta.training.contacts.manager;

/**
 * Created by win_8.1 on 5/18/2019.
 */
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ir.asta.training.contacts.dao.CaseDao;
import ir.asta.training.contacts.dao.StudentDao;
import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.entities.StudentEntity;
import org.springframework.transaction.annotation.Transactional;

import ir.asta.training.contacts.dao.ContactDao;
import ir.asta.training.contacts.entities.ContactEntity;

@Named("studentManager")
public class StudentManager {

    @Inject
    StudentDao dao;

    @Inject
    CaseDao caseDao;

    @Transactional
    public boolean register(StudentEntity entity) {
        return dao.Register(entity);
    }


    public List<StudentEntity> findAll() {
        // TODO implement this method
        return dao.findAll();
    }

    public StudentEntity getStudentByEmail(String email, String password){
        return dao.getStudentByEmail(email, password);
    }

//    public void deleteAll(){
//        dao.deleteAll();
//    }

}