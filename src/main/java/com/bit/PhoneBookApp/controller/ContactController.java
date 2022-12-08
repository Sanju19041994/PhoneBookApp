package com.bit.PhoneBookApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit.PhoneBookApp.entity.Contact;
import com.bit.PhoneBookApp.exception.ApiResponse;
import com.bit.PhoneBookApp.exception.ResourceNotFoundException;
import com.bit.PhoneBookApp.service.ContactServiceI;

@RestController
public class ContactController {

	@Autowired
	private ContactServiceI contactServiceI;

	/**
	 * @author Sanju
	 * @param contact
	 * @return 
	 * api implemented for save contact
	 */
	@PostMapping(value = "/saveContact")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact) {

		boolean saveContact = contactServiceI.saveContact(contact);
		if (saveContact) {
			String msg = "Contact Saved Successfuly";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Contact Not Saved", HttpStatus.CREATED);
		}
	}

	/**
	 * @author Sanju
	 * @return 
	 * api implemented for get all contact list
	 */
	@GetMapping(value = "/getAllContact")
	public ResponseEntity<List<Contact>> getAllContact() {
		List<Contact> allContact = contactServiceI.getAllContact();
		return new ResponseEntity<List<Contact>>(allContact, HttpStatus.OK);
	}

	/**
	 * @author Sanju
	 * @param conatactId
	 * @return
	 * @exception ResourceNotFoundException 
	 * api implemented for get single contact by contact id
	 */
	@GetMapping(value = "/contact/{contactId}")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer contactId) {
		Contact contact = contactServiceI.getContactById(contactId);
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}

	/**
	 * @author Sanju
	 * @param contact
	 * @param contactId
	 * @return
	 * @exception ResourceNotFoundException 
	 * api implemented for update contact
	 */
	@PutMapping(value = "/contact/{contactId}")
	public ResponseEntity<Contact> updateContact(@RequestBody Contact contact, @PathVariable Integer contactId) {
		Contact updatedContact = contactServiceI.updateContact(contact, contactId);
		return new ResponseEntity<Contact>(updatedContact, HttpStatus.CREATED);
	}

	/**
	 * @author Sanju
	 * @param contactId
	 * @return
	 * @exception ResourceNotFoundException 
	 * api implemented for delete contact by contact id
	 */
	@DeleteMapping(value = "/contact/{contactId}")
	public ResponseEntity<String> deleteContactById(@PathVariable Integer contactId) {
		boolean deleteContact = contactServiceI.deleteContactById(contactId);
		if (deleteContact) {
			String msg = "Contact Deleted Successfuly";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			String msg1 = "Contact Not Deleted";
			return new ResponseEntity<String>(msg1, HttpStatus.OK);
		}
	}
}
