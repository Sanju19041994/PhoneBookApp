package com.bit.PhoneBookApp.entity;

import javax.persistence.Entity;

@Entity
public class Contact {

	private int S_No;
	
	private String Name;
	
	private String Email;
	
	private String Phone;

	public int getS_No() {
		return S_No;
	}

	public void setS_No(int s_No) {
		S_No = s_No;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Contact [S_No=" + S_No + ", Name=" + Name + ", Email=" + Email + ", Phone=" + Phone + "]";
	}
	
	
	
	
}
