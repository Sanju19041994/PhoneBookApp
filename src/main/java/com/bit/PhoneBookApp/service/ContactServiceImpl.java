package com.bit.PhoneBookApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.PhoneBookApp.entity.Contact;
import com.bit.PhoneBookApp.repository.ContactRepository;


@Service
public class ContactServiceImpl implements ContactServiceI{

	@Autowired
	private ContactRepository contactRepository;
	
	
	@Override
	public boolean saveContact(Contact contact) {
		Contact saveedContact = contactRepository.save(contact);
		if(saveedContact != null) {
			return true;
		}
		return false;
	}

}