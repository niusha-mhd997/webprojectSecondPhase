package ir.asta.training.contacts.services.impl;

/**
 * Created by win_8.1 on 5/18/2019.
 */

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.entities.ContactEntity;
import ir.asta.training.contacts.entities.EmployeeEntity;
import ir.asta.training.contacts.entities.StudentEntity;
import ir.asta.training.contacts.manager.CaseManager;
import ir.asta.training.contacts.manager.ContactManager;
import ir.asta.training.contacts.manager.EmployeeManager;
import ir.asta.training.contacts.manager.StudentManager;
import ir.asta.training.contacts.services.ContactService;
import ir.asta.training.contacts.services.StudentService;
import ir.asta.wise.core.datamanagement.ActionResult;

import java.util.List;

@Named("studentService")
public class StudentServiceImpl implements StudentService {

    @Inject
    StudentManager manager;


    @Inject
    CaseManager caseManager;


    @Inject
    EmployeeManager employeeManager;



    @Override
    public ActionResult<StudentEntity> register(String email, String name, String pasword) {


        if (email.contains("@") && email.contains(".com")) {

            if (pasword.length() < 6) {
                return new ActionResult<StudentEntity>(false, "طول رمز عبور باید حداقل 6 باشد", null);
            } else {

                int max = 99999999;
                int min = 10000000;

                Random rand = new Random();
                int token = rand.nextInt((max - min) + 1) + min;

                StudentEntity entity = new StudentEntity();
                entity.setEmail(email);
                entity.setName(name);
                entity.setPassword(pasword);
                entity.setToken(token);

                if (manager.register(entity) == true) {
                    return new ActionResult<StudentEntity>(true, "با موفقیت ثبت نام شد", entity);
                } else {
                    return new ActionResult<StudentEntity>(false, "این ایمیل قبلا ثبت شده", entity);
                }
            }
        } else {
            return new ActionResult<StudentEntity>(false, "ایمیل وارد شده معتبر نیست", null);

        }
    }

    @Override
    public ActionResult<String> AddCase(String subject, String description, String receiver, String senderemail, String senderpassword) {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int[] persian = gregorian_to_jalali(year, month, day);
        String currentdate = persian[0] + "/" + persian[1] + "/" + persian[2];


        int max = 99;
        int min = 10;
        int max2 = 999;
        int min2 = 100;
        Random rand = new Random();
        int token1 = rand.nextInt((max - min) + 1) + min;
        char c = (char) (rand.nextInt(26) + 'a');
        int token2 = rand.nextInt((max2 - min2) + 1) + min2;
        char c2 = (char) (rand.nextInt(26) + 'a');

        String token = token1 + "" + c + "-" + token2 + "" + c2;

        System.out.println(receiver);

        EmployeeEntity employeeEntity = employeeManager.getEmployeeByEmail(receiver);

        CaseEntity entity = new CaseEntity();
        entity.setSubject(subject);
        entity.setDescription(description);

        //for relation
        entity.setRECEIVER(employeeEntity);

        entity.setDate(currentdate);
        entity.setStatuss(false);
        entity.setId(token);

        try {
            StudentEntity studentEntity = manager.getStudentByEmail(senderemail, senderpassword);
            entity.setSENDER(studentEntity);

            if (caseManager.AddCase(entity) == true) {
                return new ActionResult<String>(true, "مورد با موفقیت ثبت شد", "");

            } else {
                return new ActionResult<String>(false, "خطای ناشناخته", "");
            }
        } catch (Exception e) {
            return new ActionResult<String>(false, "شما دسترسی لازم را ندارید!", "");
        }
    }

    @Override
    public List<CaseEntity> getCasesByUserToken(int token) {
        try {
            List<CaseEntity> caseEntities = caseManager.getCasesByUserToken(token);
            for(CaseEntity c: caseEntities){
                c.getRECEIVER().setPassword(null);
                c.getRECEIVER().setEmail(null);
                c.getRECEIVER().setToken(0);
                c.getRECEIVER().setPermission(false);
                c.getSENDER().setPassword(null);
                c.getSENDER().setToken(0);
            }
            return caseManager.getCasesByUserToken(token);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<StudentEntity> findAll() {
        return manager.findAll();
    }

    @Override
    public List<CaseEntity> getAllCases() {
        return caseManager.getAllCases();
    }

    @Override
    public ActionResult<String> delete(Long id) {
        caseManager.deleteCase(id);
        return new ActionResult<String>(true, "دیلیت با موفقیت ثبت شد", "");

    }


    @Override
    public CaseEntity getCaseByCaseToken(String token) {
        CaseEntity caseEntity = caseManager.getCaseByCaseToken(token);
        caseEntity.getRECEIVER().setPassword(null);
        caseEntity.getRECEIVER().setEmail(null);
        caseEntity.getRECEIVER().setToken(0);
        caseEntity.getRECEIVER().setPermission(false);
        return caseEntity;
    }


    public static int[] gregorian_to_jalali(int gy, int gm, int gd) {
        int[] g_d_m = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int jy;
        if (gy > 1600) {
            jy = 979;
            gy -= 1600;
        } else {
            jy = 0;
            gy -= 621;
        }
        int gy2 = (gm > 2) ? (gy + 1) : gy;
        int days = (365 * gy) + ((int) ((gy2 + 3) / 4)) - ((int) ((gy2 + 99) / 100)) + ((int) ((gy2 + 399) / 400)) - 80 + gd + g_d_m[gm - 1];
        jy += 33 * ((int) (days / 12053));
        days %= 12053;
        jy += 4 * ((int) (days / 1461));
        days %= 1461;
        if (days > 365) {
            jy += (int) ((days - 1) / 365);
            days = (days - 1) % 365;
        }
        int jm = (days < 186) ? 1 + (int) (days / 31) : 7 + (int) ((days - 186) / 30);
        int jd = 1 + ((days < 186) ? (days % 31) : ((days - 186) % 30));
        int[] out = {jy, jm, jd};
        return out;
    }


    public static int[] jalali_to_gregorian(int jy, int jm, int jd) {
        int gy;
        if (jy > 979) {
            gy = 1600;
            jy -= 979;
        } else {
            gy = 621;
        }
        int days = (365 * jy) + (((int) (jy / 33)) * 8) + ((int) (((jy % 33) + 3) / 4)) + 78 + jd + ((jm < 7) ? (jm - 1) * 31 : ((jm - 7) * 30) + 186);
        gy += 400 * ((int) (days / 146097));
        days %= 146097;
        if (days > 36524) {
            gy += 100 * ((int) (--days / 36524));
            days %= 36524;
            if (days >= 365) days++;
        }
        gy += 4 * ((int) (days / 1461));
        days %= 1461;
        if (days > 365) {
            gy += (int) ((days - 1) / 365);
            days = (days - 1) % 365;
        }
        int gd = days + 1;
        int[] sal_a = {0, 31, ((gy % 4 == 0 && gy % 100 != 0) || (gy % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int gm;
        for (gm = 0; gm < 13; gm++) {
            int v = sal_a[gm];
            if (gd <= v) break;
            gd -= v;
        }
        int[] out = {gy, gm, gd};
        return out;
    }


    @Override
    public String AddWord(int firstword) {

        int sum = firstword + 8;
        return "<html lang=\"en\"><body><h1>final result: " + sum + "</h1></body></html>";
    }
}
