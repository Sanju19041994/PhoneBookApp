package com.bit.PhoneBookApp.service;

import java.util.List;

import com.bit.PhoneBookApp.entity.Contact;

public interface ContactServiceI {

	boolean saveContact(Contact contact);
	
	public List<Contact>  getAllContact();
	
	public Contact getContactById(Integer contactId);
	
	public Contact updateContact(Contact contact, Integer contactId);
	
	boolean deleteContactById(Integer contactId);
	
	boolean deleteContactSoft(Integer contactId);

}
