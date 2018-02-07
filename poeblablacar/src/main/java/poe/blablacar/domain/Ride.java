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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class Ride implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	    @Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	//depart - etapes-fin lieu
	String caracteristic;
	
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	int totalPlaces;
	int leftPlaces;
	@ManyToOne
	Account driver;
	 @OneToMany(mappedBy = "ride")
	    private List<Booking> bookings;
	 
	 private String lieuDepart;
	 private String lieuArrive;
	 private Double price;
	
	
	

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getLieuDepart() {
		return lieuDepart;
	}
	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}
	public String getLieuArrive() {
		return lieuArrive;
	}
	public void setLieuArrive(String lieuArrive) {
		this.lieuArrive = lieuArrive;
	}
	public Ride() {
	}
	public Account getDriver() {
		return driver;
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
	public String getCaracteristic() {
		return caracteristic;
	}
	public void setCaracteristic(String caracteristic) {
		this.caracteristic = caracteristic;
	}

	public void setDriver(Account driver) {
		this.driver = driver;
	}
	
	
	
	
	

}
