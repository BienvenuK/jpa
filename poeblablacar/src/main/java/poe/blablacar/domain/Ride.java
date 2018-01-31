package poe.blablacar.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Ride implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	//depart - etapes-fin lieu
	@Column
	@ElementCollection(targetClass=String.class)
	List<String>locations = new ArrayList<String>();
	@Column
	@ElementCollection(targetClass=String.class)
	List<String>caracteristics = new ArrayList<String>();
	@Temporal(TemporalType.DATE)
	@Column
	@ElementCollection(targetClass=Date.class)
	List<Date>arrivalDates = new ArrayList<Date>();
	int totalPlaces;
	int leftPlaces;
	public Account getDriver() {
		return driver;
	}

	

	@ManyToOne
	Account driver;

	public Ride() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
	
	public List<String> getCaracteristics() {
		return caracteristics;
	}
	
	public void setCaracteristics(String caracteristic) {
		this.caracteristics.add(caracteristic);
	}
	
	public List<Date> getArrivalDates() {
		return arrivalDates;
	}
	
	public void setArrivalDates(Date arrivalDate) {
		this.arrivalDates.add(arrivalDate) ;
	}
	
	public List<String> getLocations() {
		return locations;
	}
	
	public void setLocations(String location) {
		this.locations.add(location);
	}

	public void setDriver(Account driver) {
		this.driver = driver;
	}


	
	

}
