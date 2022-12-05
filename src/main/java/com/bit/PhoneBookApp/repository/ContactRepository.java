package com.bit.PhoneBookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bit.PhoneBookApp.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
