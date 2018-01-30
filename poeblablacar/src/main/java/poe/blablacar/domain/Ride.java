package poe.blablacar.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Ride {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date startDate;
	//depart - etapes-fin lieu
   
	
     int totalPlaces;
     int leftPlaces;
     @ManyToOne
     Account driver;
     
     
     
     public Account getDriver() {
		return driver;
	}
	public void setDriver(Account driver) {
		this.driver = driver;
	}
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
 
	

}
