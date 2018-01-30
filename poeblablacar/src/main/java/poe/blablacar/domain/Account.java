package poe.blablacar.domain;




import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String password;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	@NotBlank
	private String email;
	private String rating ;
	private boolean confirmed;
	
	@OneToMany(mappedBy="driver")
	private Collection<Ride> proposedRides;
	
	
	
	public Account( String password, String firstName, String lastName, Date birthDate, String email,
			String rating, boolean confirmed) {
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
		this.rating = rating;
		this.confirmed = confirmed;
	}
	
	public Account() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	

}
