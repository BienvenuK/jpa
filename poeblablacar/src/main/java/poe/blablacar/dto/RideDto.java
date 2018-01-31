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
	List<String>locations = new ArrayList<String>();
	List<String>caracteristics = new ArrayList<String>();
	List<Date>arrivalDates = new ArrayList<Date>();
	int totalPlaces;
	int leftPlaces;
	
	
	
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public List<String> getLocations() {
		return locations;
	}
	public void setLocations(List<String> locations) {
		this.locations = locations;
	}
	public List<String> getCaracteristics() {
		return caracteristics;
	}
	public void setCaracteristics(List<String> caracteristics) {
		this.caracteristics = caracteristics;
	}
	public List<Date> getArrivalDates() {
		return arrivalDates;
	}
	public void setArrivalDates(List<Date> arrivalDates) {
		this.arrivalDates = arrivalDates;
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
