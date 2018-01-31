package poe.blablacar.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poe.blablacar.dao.RideDao;
import poe.blablacar.domain.Ride;

@Service
public class RideService {

	@Autowired
	RideDao rideDao;

	public void add(Ride ride) {
		rideDao.save(ride);
	}

	public Ride get(Long idRide) {
		return rideDao.findOne(idRide);
	}

//	 public void edit(ride ride) {
//	 rideDao.save(ride);
//	 }

	public void delete(Long idRide) {
		rideDao.delete(idRide);
	}

	public Iterable<Ride> rides() {

		return rideDao.findAll();

	}

	public boolean exist(Long idRide) {
		return rideDao.exists(idRide);
	}

}
