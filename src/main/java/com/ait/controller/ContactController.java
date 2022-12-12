package com.ait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.model.Contact;
import com.ait.service.ContactServiceImpl;
import com.ait.service.SequenceGeneratorService;

@RestController
public class ContactController {

	@ Autowired
	ContactServiceImpl service;
	@Autowired
	SequenceGeneratorService sequenceGenerator;
	
	@PostMapping("/save")
	public String saveContact(@RequestBody Contact contact) {
		contact.setContactId(sequenceGenerator.generateSequence(contact.SEQUENCE_NAME));
		
		return service.saveContact(contact);
	}
	
	@GetMapping("/getAll")
	public List<Contact> getAllContacts( ) {
		return service.getAllContacts();
	}
	@GetMapping("/get/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId ) {
		return service.getContactById(contactId);
	}
	@PutMapping("/update")
	public String updateContact(@RequestBody Contact contact ) {
		return service.updateContact(contact);
	}
	@DeleteMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable Integer contactId) {
		return service.deleteContactById(contactId);
	}
}
