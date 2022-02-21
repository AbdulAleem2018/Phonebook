package com.a2stech.phonebook.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="CONTACT")
@Data
public class Contact {
	/**
	 It is back end binding class to map the DB table
	 */
	@Id
	/*import javax.persistence.SequenceGenerator;
	  @SequenceGenerator(name="abc", sequenceName = "contact_id_seq", allocationSize = 1)
	  @GeneratedValue(generator = "abc", strategy = GenerationType.SEQUENCE)*/
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="NUMBER")
	private String number;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ACTIVE_SW")
	private String activeSW;
	
	@Column(name="CREATED_DATE")
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE")
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	@Transient
	private LocalDateTime ignoreField;
}
