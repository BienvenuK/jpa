package poe.blablacar.Service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poe.blablacar.dao.RideDao;
import poe.blablacar.domain.Account;
import poe.blablacar.domain.Ride;

@Service
public class RideService {

	@Autowired
	RideDao rideDao;
	
	@Autowired
	AccountService accountService;


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
	
	public void offerARide( Date startDate, String caracteristic, int totalPlaces , int leftPlaces , String lieuDepart, String lieuArrive, Double price, Long driver) {
		
		Ride ride = new Ride();
		ride.setStartDate(startDate);
		ride.setCaracteristic(caracteristic);
		ride.setTotalPlaces(totalPlaces);
		ride.setLeftPlaces(leftPlaces);
		ride.setLieuDepart(lieuDepart);
		ride.setLieuArrive(lieuArrive);
		ride.setPrice(price);
		Account account = accountService.get(driver);
		ride.setDriver(account);
		rideDao.save(ride);
		

	}

}
