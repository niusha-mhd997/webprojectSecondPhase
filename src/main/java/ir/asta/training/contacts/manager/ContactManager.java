package ir.asta.training.contacts.manager;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import ir.asta.training.contacts.dao.ContactDao;
import ir.asta.training.contacts.entities.ContactEntity;

@Named("contactManager")
public class ContactManager {

	@Inject
	ContactDao dao;

	@Transactional
	public void save(ContactEntity entity) {
		dao.save(entity);
	}

	public ContactEntity load(Long id) {
		// TODO implement this method
		return null;
	}
	
	public List<ContactEntity> findAll(String entityName) {
		// TODO implement this method
		return dao.findAll(entityName);
	}


	public int Login(String email, String password){

		return dao.Login(email, password);

	}




	
}
