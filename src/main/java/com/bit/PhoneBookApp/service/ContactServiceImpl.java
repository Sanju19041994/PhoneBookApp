package com.bit.PhoneBookApp.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		Stream<Contact> stream = list.stream();
		Stream<Contact> filter = stream.filter((contact)-> contact.getActiveSwitch()=='Y');
		List<Contact> list2 = filter.collect(Collectors.toList());
		return list2;
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


	@Override
	public boolean deleteContactSoft(Integer contactId) {

		Contact contact = contactRepository.findById(contactId).orElseThrow(()-> new ResourceNotFoundException("Contact", "Contact Id", contactId));
		if(contact != null) {
			contact.setActiveSwitch('N');
			contactRepository.save(contact);
			return true;
		}else {
		return false;
		}
	}

}
