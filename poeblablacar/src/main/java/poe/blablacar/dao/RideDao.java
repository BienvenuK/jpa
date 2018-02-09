package poe.blablacar.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import poe.blablacar.domain.Ride;

public interface RideDao extends CrudRepository<Ride, Long> {
	 List<Ride> findAllByLieuArriveLikeIgnoreCaseOrLieuDepartLikeIgnoreCase(String toCity, String fromCity);
	
	
}
