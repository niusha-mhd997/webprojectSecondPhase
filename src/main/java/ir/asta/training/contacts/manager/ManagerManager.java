package ir.asta.training.contacts.manager;

import ir.asta.training.contacts.dao.ManagerDao;
import ir.asta.training.contacts.dao.StudentDao;
import ir.asta.training.contacts.entities.EmployeeEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("managerManager")
public class ManagerManager {

    @Inject
    ManagerDao dao;

    public String AcceptEmployee(String employeemail) {
        return dao.AcceptEmployee(employeemail);
    }

    public List<EmployeeEntity> getAllPermittedEmployees(){
        return dao.getAllPermittedEmployees();
    }

    public List<EmployeeEntity> getAllNotPermittedEmployees(){
        return dao.getAllNotPermittedEmployees();
    }

}
