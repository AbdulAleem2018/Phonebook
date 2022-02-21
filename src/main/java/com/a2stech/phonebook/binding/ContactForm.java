package com.a2stech.phonebook.binding;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ContactForm {
/**
 This class is a binding(Front end) class like previously called as DTO(DataTransferObject),VO(ValueObject),BO
 We will use this binContactding class as RequestBinding class (capture request(UI) data) and ResponceBinding class (sent response data to UI) 
 **/
	private String number;
	private String name;
	private String email;
	
	private int id;
	private String activeSW;
	private LocalDate createdDate;
	private LocalDate updatedDate;
}
