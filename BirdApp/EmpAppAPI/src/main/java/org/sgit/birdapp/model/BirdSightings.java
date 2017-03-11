package org.sgit.birdapp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BirdSightings {

	@XmlElement
	String SightedDate;
	@XmlElement
	String StartSightedTime;
	@XmlElement
	String EndSightedTime;
	@XmlElement
	String Location;
	@XmlElement
	String BirdCode;
	@XmlElement
	String Email;
	
	public BirdSightings() {
		// TODO Auto-generated constructor stub
	}
	
	public BirdSightings(String SightedDate, String StartSightedTime, String EndSightedTime, String Location, String BirdCode, String Email) {
		// TODO Auto-generated constructor stub
		this.SightedDate = SightedDate;
		this.StartSightedTime = StartSightedTime;
		this.EndSightedTime = EndSightedTime;
		this.Location = Location;
		this.BirdCode = BirdCode;
		this.Email = Email;
	}

	public String getSightedDate() {
		return SightedDate;
	}

	public void setSightedDate(String sightedDate) {
		SightedDate = sightedDate;
	}

	public String getStartSightedTime() {
		return StartSightedTime;
	}

	public void setStartSightedTime(String startSightedTime) {
		StartSightedTime = startSightedTime;
	}

	public String getEndSightedTime() {
		return EndSightedTime;
	}

	public void setEndSightedTime(String endSightedTime) {
		EndSightedTime = endSightedTime;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getBirdCode() {
		return BirdCode;
	}

	public void setBirdCode(String birdCode) {
		BirdCode = birdCode;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
}
