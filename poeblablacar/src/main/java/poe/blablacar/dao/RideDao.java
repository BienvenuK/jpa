package poe.blablacar.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.repository.CrudRepository;

import com.fasterxml.jackson.annotation.JsonFormat;

import poe.blablacar.domain.Account;
import poe.blablacar.domain.Booking;
import poe.blablacar.domain.Ride;

public interface RideDao extends CrudRepository<Ride, Long> {
	
	
}
