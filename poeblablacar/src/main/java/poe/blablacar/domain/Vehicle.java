package poe.blablacar.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String name;
	@Temporal(TemporalType.DATE)
    private Date yearOfBuilding;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getYearOfBuilding() {
		return yearOfBuilding;
	}
	public void setYearOfBuilding(Date yearOfBuilding) {
		this.yearOfBuilding = yearOfBuilding;
	}
	
	

}
