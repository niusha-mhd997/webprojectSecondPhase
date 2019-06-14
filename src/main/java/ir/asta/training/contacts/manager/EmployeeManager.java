package ir.asta.training.contacts.manager;

/**
 * Created by win_8.1 on 6/5/2019.
 */

import ir.asta.training.contacts.dao.EmployeeDao;
import ir.asta.training.contacts.entities.EmployeeEntity;
import org.springframework.transaction.annotation.Transactional;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("employeeManager")
public class EmployeeManager {


    @Inject
    EmployeeDao employeeDao;

    public EmployeeEntity getEmployeeByEmail(String email){
        return employeeDao.getEmployeeByEmail(email);
    }


    public List<EmployeeEntity> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }


    @Transactional
    public boolean register(EmployeeEntity entity) {
        return employeeDao.Register(entity);
    }
}
