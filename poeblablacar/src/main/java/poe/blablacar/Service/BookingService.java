package poe.blablacar.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.blablacar.dao.BookingDao;
import poe.blablacar.domain.Account;
import poe.blablacar.domain.Booking;
import poe.blablacar.domain.Ride;

@Service
public class BookingService {
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private BookingDao bookibg;
	@Autowired
	private AccountService accountService;
	@Autowired
	private RideService rideService;
	
	
	
	
	
	
	public void add(Booking booking) {
		bookingDao.save(booking);
	}

	public Booking get(Long idBooking) {
		return bookingDao.findOne(idBooking);
	}

//	 public void edit(ride ride) {
//	 rideDao.save(ride);
//	 }

	public void delete(Long idBooking) {
		bookingDao.delete(idBooking);
	}

	public Iterable<Booking> bookings() {

		return bookingDao.findAll();

	}



	public boolean exist(Long idBooking) {
		return bookingDao.exists(idBooking);
	}
	
	 public Booking bookARide(Long userId, Long rideId) {
		 System.out.println(" je suis service booking");
	        Account account = accountService.get(userId);
	        Ride ride = rideService.get(rideId);
	        Booking booking = new Booking();
	        booking.setAccount(account);
	        booking.setRide(ride);
	        bookingDao.save(booking);
	        return booking;
	}

}
