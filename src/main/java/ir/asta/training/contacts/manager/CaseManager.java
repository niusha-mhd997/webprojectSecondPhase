package ir.asta.training.contacts.manager;

/**
 * Created by win_8.1 on 5/19/2019.
 */
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Query;

import ir.asta.training.contacts.dao.CaseDao;
import ir.asta.training.contacts.dao.StudentDao;
import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.entities.StudentEntity;
import org.springframework.transaction.annotation.Transactional;

import ir.asta.training.contacts.dao.ContactDao;
import ir.asta.training.contacts.entities.ContactEntity;

@Named("caseManager")
public class CaseManager {


    @Inject
    CaseDao caseDao;

    @Transactional
    public boolean AddCase(CaseEntity entity){
        return caseDao.AddCase(entity);
    }

    public List<CaseEntity> getAllCases(){
        return caseDao.getAllCases();
    }

    public void deleteCase(Long id){
        caseDao.deleteCase(id);
    }


    public List<CaseEntity> getCasesByUserToken(int token) {
        return caseDao.getCasesByUserToken(token);
    }


    public CaseEntity getCaseByCaseToken(String token){
        return caseDao.getCaseByCaseToken(token);
    }


}