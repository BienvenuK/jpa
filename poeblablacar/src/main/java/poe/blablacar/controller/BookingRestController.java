package poe.blablacar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.blablacar.Service.BookingService;
import poe.blablacar.domain.Booking;


@RequestMapping("/booking")
@RestController
public class BookingRestController {
	

	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping
	public void add(@RequestBody Booking booking) {
		bookingService.add(booking);
	}
	
	@GetMapping("/exist/{id}")
	public boolean exist(@PathVariable("id") Long idBooking) {
		return bookingService.exist(idBooking);
	} 
	
//	@PostMapping
//	public void edit(ride ride) {
//		rideService.edit(ride);
//	}
//	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long idBooking) {
		bookingService.delete(idBooking);
		
	}
	
	@GetMapping("/bookings")
	public Iterable<Booking> bookings(){
		return bookingService.bookings();
	}
	
	
	@GetMapping("/show/{id}")
	public Booking get(@PathVariable("id")Long idBooking) {
		
		return bookingService.get(idBooking);
	}
	
	
	

}
