package org.kottu.birdapp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Users {
	
	@XmlElement
	String Email;
	@XmlElement
	String Name;
	@XmlElement
	String phoneNo;
	@XmlElement
	String Password;
	
	public Users(){
		
	}
	public Users(String Email, String Name, String phoneNo, String Password) {
		// TODO Auto-generated constructor stub
		this.Email = Email;
		this.Name = Name;
		this.phoneNo = phoneNo;
		this.Password = Password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
