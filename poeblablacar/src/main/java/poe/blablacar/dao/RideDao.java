package poe.blablacar.dao;

import org.springframework.data.repository.CrudRepository;
import poe.blablacar.domain.Ride;

public interface RideDao extends CrudRepository<Ride, Long> {
	
	
}
