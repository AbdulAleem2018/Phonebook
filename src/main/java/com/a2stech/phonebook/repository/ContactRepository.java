package com.a2stech.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.a2stech.phonebook.entity.Contact;

//Generic class Serializable or Primarykey Type like Integer
//@Repository is not required if extends JpaRepository or CrudRepository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
