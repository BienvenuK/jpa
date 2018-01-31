package poe.blablacar.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import poe.blablacar.domain.Account;
import poe.blablacar.domain.Ride;

public class AccountDto {


	private String password;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String email;
	private String rating ;
	private boolean confirmed;


	public static AccountDto buildFrom(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setPassword(account.getPassword());
		accountDto.setFirstName(account.getFirstName());
		accountDto.setLastName(account.getLastName());
		accountDto.setBirthDate(account.getBirthDate());
		accountDto.setEmail(account.getEmail());
		accountDto.setRating(account.getRating());
		accountDto.setConfirmed(account.isConfirmed());

		Collection<RideDto> rides = new ArrayList<>();
		for (Ride ride : account.getProposedRides()) {
			RideDto rideDto = new RideDto();
			rideDto.setStartDate(ride.getStartDate());
			rideDto.setLocations(ride.getLocations());
			rideDto.setCaracteristics(ride.getCaracteristics());
			rideDto.setArrivalDates(ride.getArrivalDates());
			rideDto.setTotalPlaces(ride.getTotalPlaces());
			rideDto.setLeftPlaces(ride.getLeftPlaces());;

			rides.add(rideDto);
		}
		accountDto.setProposedRides(rides);
		return accountDto;
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



	public Collection<RideDto> getProposedRides() {
		return proposedRides;
	}



	public void setProposedRides(Collection<RideDto> rides) {
		this.proposedRides = rides;
	}


	private Collection<RideDto> proposedRides;

}
