package com.a2stech.phonebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a2stech.phonebook.binding.ContactForm;
import com.a2stech.phonebook.entity.Contact;
import com.a2stech.phonebook.repository.ContactRepository;

@Service
public class ContactServiceImplementation implements ContactService {
	
	@Autowired
	ContactRepository contactRepository;
	
	/*private ContactRepository contactRepository;
	public ContactServiceImplementation(ContactRepository accRepo) {
		this.contactRepository = accRepo;
	}*/

	@Override
	public String saveContact(ContactForm Contact) {
		Contact contact=new Contact();
		BeanUtils.copyProperties(Contact, contact);
		contact.setActiveSW("Y");
		contactRepository.save(contact);
		System.out.println("ID :"+contact.getId());
		if(contact.getId()!=0)
			return "Contact is saved SUCCESSFULLY !!!";
		else
			return "Contact is FAILED to Save.";
	}

	@Override
	public ContactForm getContactById(int contactId) {
		ContactForm Contact=new ContactForm();
		Optional<Contact> findContactId=contactRepository.findById(contactId);
		
		if(findContactId.isPresent()) {
			Contact contact=findContactId.get();
			BeanUtils.copyProperties(contact, Contact);
			return Contact;
		}
		return null;
	}

	@Override
	public List<ContactForm> viewAllContacts() {
		List<Contact> contactList=contactRepository.findAll();
		List<ContactForm> ContactList=new ArrayList<>();
		
		for(Contact contact:contactList){
			ContactForm contactForm=new ContactForm();
			BeanUtils.copyProperties(contact,contactForm);
			ContactList.add(contactForm);
		}
		return ContactList;
	}

	@Override
	public List<ContactForm> deleteContact(int contactId) {
		contactRepository.deleteById(contactId);
		return viewAllContacts();
	}
}