//package poe.blablacar.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import poe.blablacar.dao.BookingDao;
//import poe.blablacar.domain.Booking;
//
//@Service
//public class BookingService {
//	
//	@Autowired
//	private BookingDao bookingDao;
//	
//	
//	
//	public void add(Booking booking) {
//		bookingDao.save(booking);
//	}
//
//	public Booking get(Long idBooking) {
//		return bookingDao.findOne(idBooking);
//	}
//
////	 public void edit(ride ride) {
////	 rideDao.save(ride);
////	 }
//
//	public void delete(Long idBooking) {
//		bookingDao.delete(idBooking);
//	}
//
//	public Iterable<Booking> bookings() {
//
//		return bookingDao.findAll();
//
//	}

//
//
//	public boolean exist(Long idBooking) {
//		return bookingDao.exists(idBooking);
//	}
//
//}
