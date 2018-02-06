package poe.blablacar.domain;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Booking implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @JsonIgnore
	    @ManyToOne
	    private Ride ride;

	    @JsonIgnore
	    @ManyToOne
	    private Account  account;

	    public Ride getRide() {
	        return ride;
	    }

	    public void setRide(Ride ride) {
	        this.ride = ride;
	    }


	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }
	    public Account getAccount() {
			return account;
		}

		public void setAccount(Account account) {
			this.account = account;
		}
	
	

}
