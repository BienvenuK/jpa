package poe.blablacar.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class RideDto {
	private Date startDate;
	private String location;
	private String caracteristic;
	private Date arrivalDate ;
	private int totalPlaces;
	private int leftPlaces;
	
	
	
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
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
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
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
