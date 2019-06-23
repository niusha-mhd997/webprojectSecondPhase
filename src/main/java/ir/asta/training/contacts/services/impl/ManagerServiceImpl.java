package ir.asta.training.contacts.services.impl;


import ir.asta.training.contacts.entities.EmployeeEntity;
import ir.asta.training.contacts.manager.ManagerManager;
import ir.asta.training.contacts.manager.StudentManager;
import ir.asta.training.contacts.services.ManagerService;
import ir.asta.training.contacts.services.StudentService;
import ir.asta.wise.core.datamanagement.ActionResult;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("managerService")
public class ManagerServiceImpl implements ManagerService {

    @Inject
    ManagerManager manager;

    @Override
    public ActionResult<String> AcceptEmployee(String employeemail) {
        String respons = manager.AcceptEmployee(employeemail);
        return new ActionResult<String>(true, respons, null);
    }

    @Override
    public List<EmployeeEntity> getAllNotPermittedEmployees() {
        return manager.getAllNotPermittedEmployees();
    }

    @Override
    public List<EmployeeEntity> getAllPermittedEmployees() {
        return manager.getAllPermittedEmployees();
    }
}
