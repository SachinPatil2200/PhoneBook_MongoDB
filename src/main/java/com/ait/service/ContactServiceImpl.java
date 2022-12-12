package com.ait.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.dao.ContactRepository;
import com.ait.model.Contact;
@Service
public class ContactServiceImpl implements ContactService  {
	

	@Autowired
	ContactRepository repo;

	
	@Override
	public String saveContact(Contact contact) {
		contact=repo.save(contact);
		if(contact.getContactId()!=null) {
			return "Saved Successfully";
		}
		return "Failed to Save";
	}

	@Override
	public List<Contact> getAllContacts() {
		
		return repo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		
			Optional<Contact> optional = repo.findById(contactId);
			if(optional.isPresent()) {
			return optional.get();
		}
		return null;	
	}

	@Override
	public String updateContact(Contact contact) {
		if( repo.findById(contact.getContactId()).isPresent()) {
			repo.save(contact);
			return "Updated Successfully";
		}
		return "Given Contact is not Present ";
	}

	@Override
	public String deleteContactById(Integer contactId) {
		if( repo.findById(contactId).isPresent()) {
			repo.deleteById(contactId);
			return "Deleted Successfully";
		}
		return "Given Contact is not Present";
		
	}

}
