package poe.blablacar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poe.blablacar.Service.AccountService;
import poe.blablacar.Service.BookingService;
import poe.blablacar.Service.RideService;
import poe.blablacar.domain.Account;
import poe.blablacar.domain.Booking;
import poe.blablacar.domain.Ride;


@RequestMapping("/booking")
@RestController
public class BookingRestController {
	

	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	RideService rideService;
	
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
	
	 @PostMapping("{userId}/{rideId}")
	    public void save(@PathVariable("userId") Long idAccount, @PathVariable("rideId") Long rideId) {
	       Account account = accountService.get(idAccount);
	        Ride ride = rideService.get(rideId);

	        Booking booking = new Booking();
	        booking.setAccount(account);
	        booking.setRide(ride);
	       bookingService.add(booking);

	    }
	 
	 @GetMapping("{ride}/{account}")
	    public String bookARide(@RequestParam(name = "ride") String rideId, @RequestParam(name = "account") String userId, Model model) {
		 System.out.println("je suis controller book");
	        if (rideId != null && !rideId.isEmpty()) {
	            Booking booking = bookingService.bookARide(Long.valueOf(userId), Long.valueOf(rideId));
	            model.addAttribute("booking", booking);
	        }
	        return "ride/accountAddRide";
	}
	 
	 
	
	 
	 
	

}
