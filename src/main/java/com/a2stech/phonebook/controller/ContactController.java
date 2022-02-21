package com.a2stech.phonebook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.a2stech.phonebook.binding.ContactForm;
import com.a2stech.phonebook.binding.ResponseMessage;
import com.a2stech.phonebook.service.ContactService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="")
public class ContactController {
	//Decoder: ${jndi:ldap://127.0.0.1:3089/}
	//Encoder: %24%7Bjndi%3Aldap%3A%2F%2F127.0.0.1%3A3089%2F%7D
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	ContactService contactService;
	
	@PostMapping(value="/savecontact", produces = {"application/json"})
	public ResponseEntity<ResponseMessage> saveContactInfo(@RequestBody ContactForm contactForm) {
		System.out.println("Request :"+contactForm);
		String receivedMsg= contactService.saveContact(contactForm);
		//return new ResponseEntity<>(receivedMsg,HttpStatus.OK);
		//return ResponseEntity.ok().body(new String(receivedMsg));
		//return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(receivedMsg));
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(receivedMsg));
	}
	
	@PostMapping(value="/save")
	public String saveContact(@RequestBody ContactForm contactForm) {
		System.out.println("Request :"+contactForm);
		return contactService.saveContact(contactForm);
	}

	@GetMapping(value="/all")
	public List<ContactForm> allContacts() {
		return contactService.viewAllContacts();
	}

	@GetMapping(value="/edit/{contactId}")
	public ContactForm editContact(@PathVariable("contactId") Integer editContactId) {
		return contactService.getContactById(editContactId);
	}

	@DeleteMapping(value="/delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable("contactId") int deleteContactId) {
		return contactService.deleteContact(deleteContactId);
	}
	//To find Log4j2 volunarbility(Log4j RCE CVE- 2021-44228 - Third Party Products)
	@GetMapping(value="/edits")
	public String edit(@RequestParam("contactId") String editContactId) {
		
		LOGGER.trace("Edit contactId input:"+editContactId);
		LOGGER.debug("Edit contactId input:"+editContactId);
		LOGGER.info("Edit contactId input:"+editContactId);
		LOGGER.warn("Edit contactId input:"+editContactId);
		LOGGER.error("Edit contactId input:"+editContactId);
		
		return "{}";
	}
	//Request: http://localhost:8080/edits?contactId=%24%7Bjndi%3Aldap%3A%2F%2F127.0.0.1%3A3089%2F%7D
	//Responce: 2021-12-17 08:14:39.071  INFO 37040 --- [nio-8080-exec-3] c.a.p.controller.ContactController       : Edit contactId input:${jndi:ldap://127.0.0.1:3089/}

	/**
	 Request: GET: http://localhost:8080/controler/swaggerMsg/Aleem
	 Response: Aleem Good Morning!!
	 
	 import io.swagger.annotations.ApiOperation;
	 import io.swagger.annotations.ApiParam;
	 */
	@ApiOperation(value="This operation is used for generate swagger message" ,response = String.class)
	@GetMapping("/swaggerMsg/{name}")
	public String swaggerMessage(@ApiParam("Name to Wish") @PathVariable String name) {
		return name+" Good Morning!!";
	}
}