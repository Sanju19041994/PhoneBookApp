package com.bit.PhoneBookApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.PhoneBookApp.entity.Contact;
import com.bit.PhoneBookApp.exception.ResourceNotFoundException;
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


	@Override
	public List<Contact> getAllContact() {
		List<Contact> list = contactRepository.findAll();
		return list;
	}


	@Override
	public Contact getContactById(Integer contactId) {
		Contact contact = contactRepository.findById(contactId).orElseThrow(()-> new ResourceNotFoundException("Contact", "Contact Id", contactId));
		return contact;
	}


	@Override
	public Contact updateContact(Contact contact, Integer contactId) {
		Contact cont = contactRepository.findById(contactId).orElseThrow(()-> new ResourceNotFoundException("Contact", "Contact Id", contactId));
		
		cont.setContactName(contact.getContactName());
		cont.setContactNumber(contact.getContactNumber());
		cont.setContactEmail(contact.getContactEmail());
		
		Contact updatedContact = contactRepository.save(cont);
		return updatedContact;
	}


	@Override
	public boolean deleteContactById(Integer contactId) {
		Contact cont = contactRepository.findById(contactId).orElseThrow(()-> new ResourceNotFoundException("Contact", "Contact Id", contactId));

		if(cont!=null) {
			contactRepository.delete(cont);
			return true;
		}
		return false;
	}

}
