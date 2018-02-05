package poe.blablacar.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class RideCreateForm {
	
	
	private String startDate;
	String location;
	String caracteristic ;
	List<String>arrivalDates = new ArrayList<String>();
	int totalPlaces;
	int leftPlaces;
	
	
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCaracteristic() {
		return caracteristic;
	}
	public void setCaracteristic(String caracteristic) {
		this.caracteristic = caracteristic;
	}
	public List<String> getArrivalDates() {
		return arrivalDates;
	}
	public void setArrivalDates(String arrivalDate) {
		this.arrivalDates.add(arrivalDate);
	}
	public int getTotalPlaces() {
		return totalPlaces;
	}
	public void setTotalPlaces(int totalPlaces) {
		this.totalPlaces = totalPlaces;
	}
	public int getLeftPlaces() {
		return leftPlaces;
	}
	public void setLeftPlaces(int leftPlaces) {
		this.leftPlaces = leftPlaces;
	}
	
	
	

}
