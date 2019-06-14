package ir.asta.training.contacts.services.impl;

import ir.asta.training.contacts.entities.EmployeeEntity;
import ir.asta.training.contacts.manager.EmployeeManager;
import ir.asta.training.contacts.services.EmployeeService;
import ir.asta.wise.core.datamanagement.ActionResult;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Random;

/**
 * Created by win_8.1 on 6/13/2019.
 */

@Named("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    EmployeeManager employeeManager;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeManager.getAllEmployees();
    }

    @Override
    public ActionResult<EmployeeEntity> register(String email, String name, String semat, String password) {
        if (email.contains("@") && email.contains(".com")) {

            if (password.length() < 6) {
                return new ActionResult<EmployeeEntity>(false, "طول رمز عبور باید حداقل 6 باشد", null);
            } else {

                int max = 99999999;
                int min = 10000000;
                Random rand = new Random();
                int token = rand.nextInt((max - min) + 1) + min;

                EmployeeEntity entity = new EmployeeEntity();
                entity.setEmail(email);
                entity.setName(name);
                entity.setPassword(password);
                entity.setToken(token);
                entity.setPermission(false);
                entity.setSemat(semat);

                if (employeeManager.register(entity) == true) {
                    return new ActionResult<EmployeeEntity>(true, "با موفقیت ثبت نام شد", entity);
                } else {
                    return new ActionResult<EmployeeEntity>(false, "این ایمیل قبلا ثبت شده", entity);
                }
            }
        } else {
            return new ActionResult<EmployeeEntity>(false, "ایمیل وارد شده معتبر نیست", null);

        }
    }



}
