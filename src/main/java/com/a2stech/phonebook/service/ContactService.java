package com.a2stech.phonebook.service;

import java.util.List;
import com.a2stech.phonebook.binding.ContactForm;

public interface ContactService {
	
	public String saveContact(ContactForm contactDetails);
	
	public ContactForm getContactById(Integer contactId);
	
	public List<ContactForm> viewAllContacts();
	
	public List<ContactForm> deleteContact(int contactId);

}
