package org.sgit.birdapp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Birds {

	@XmlElement
	String BirdCode;
	@XmlElement
	String Bird_Name;
	@XmlElement
	String Scientific_Name;
	@XmlElement
	String Regional_Name;
	@XmlElement
	String Image;
	@XmlElement
	String Email;
	
	public Birds() {
		// TODO Auto-generated constructor stub
	}
	public Birds(String BirdCode, String Bird_Name, String Scientific_Name, String Regional_Name, String Image, String Email) {
		// TODO Auto-generated constructor stub
		this.BirdCode = BirdCode;
		this.Bird_Name = Bird_Name;
		this.Scientific_Name = Scientific_Name;
		this.Regional_Name = Regional_Name;
		this.Image = Image;
		this.Email = Email;
	}
	
	public String getBirdCode() {
		return BirdCode;
	}
	public void setBirdCode(String birdCode) {
		BirdCode = birdCode;
	}
	
	public String getBird_Name() {
		return Bird_Name;
	}
	public void setBird_Name(String bird_Name) {
		Bird_Name = bird_Name;
	}
	public String getScientific_Name() {
		return Scientific_Name;
	}
	public void setScientific_Name(String scientific_Name) {
		Scientific_Name = scientific_Name;
	}
	public String getRegional_Name() {
		return Regional_Name;
	}
	public void setRegional_Name(String regional_Name) {
		Regional_Name = regional_Name;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
