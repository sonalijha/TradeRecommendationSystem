package com.stockmarket.customer;
import java.util.*;

public class Customer {
	String username;
	String name;
	String password;
	String gender;
	String dateOfBirth;
	long phoneNumber;
	String emailId;
	String marketCapType;
	
	
	public Customer(String username, String name, String password, String gender, String dateOfBirth, long phoneNumber, String emailId, String marketCapType) {
		super();
		this.username = username;
		this.name = name;
		this.password=password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMarketCapType() {
		return marketCapType;
	}
	public void setMarketCapType(String marketCapType) {
		this.marketCapType = marketCapType;
	}	
}
