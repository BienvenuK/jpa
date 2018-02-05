package poe.blablacar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poe.blablacar.domain.Booking;

@Repository
public interface BookingDao extends CrudRepository<Booking, Long>{

}
