package ir.asta.training.contacts.services.impl;

import javax.inject.Inject;
import javax.inject.Named;

import ir.asta.training.contacts.entities.ContactEntity;
import ir.asta.training.contacts.entities.StudentEntity;
import ir.asta.training.contacts.manager.ContactManager;
import ir.asta.training.contacts.manager.StudentManager;
import ir.asta.training.contacts.services.ContactService;
import ir.asta.wise.core.datamanagement.ActionResult;

import java.util.List;

@Named("contactService")
public class ContactServiceImpl implements ContactService {

	@Inject
	ContactManager manager;

	@Inject
	StudentManager studentManager;
	
	@Override
	public ContactEntity load(Long id) {
		// TODO implement this method
		ContactEntity entity = new ContactEntity(); 
		entity.setId(100L);
		entity.setName("Dummy Contact");
		return entity;
	}

	@Override
	public ActionResult<Long> save(ContactEntity entity) {
		manager.save(entity);
		return new ActionResult<Long>(true, "New contact saved successfully.", entity.getId());
	}

	@Override
	public List<ContactEntity> findAll(String entityName) {
		return manager.findAll(entityName);
	}




	@Override
	public ActionResult<Object> Login(String email, String password) {

		String resp = "";

		if( manager.Login(email, password)== -1){
			 resp = "کاربری با این مشخصات یافت نشد";
			return new ActionResult<Object>(true, resp,"");
		}
		if( manager.Login(email, password)== 0){
			 resp = "رمز عبور اشتباه است";
			return new ActionResult<Object>(true, resp,"");
		}
		if( manager.Login(email, password)== 1){
			 resp = "به عنوان دانشجو وارد شدید";
			StudentEntity student = studentManager.getStudentByEmail(email, password);
			return new ActionResult<Object>(true, resp,student);
		}
		if( manager.Login(email, password)== 2){
			resp = "به عنوان مدیر وارد شدید";
			return new ActionResult<Object>(true, resp,"");
		}
		if( manager.Login(email, password)== 3){
			resp = "به عنوان کارمند وارد شدید";
			return new ActionResult<Object>(true, resp,"");
		}
		if( manager.Login(email, password)== 4){
			resp = "کارمندی شما تایید نشده";
			return new ActionResult<Object>(true, resp,"");
		}

		return new ActionResult<Object>(false, resp,null);

	}


}
