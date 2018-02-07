package poe.blablacar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.blablacar.Service.RideService;
import poe.blablacar.domain.Ride;


@RestController
@RequestMapping("/api/ride")
public class RideRestController {
	@Autowired
	RideService rideService;
	
	
	
	@PostMapping("/api/")
	public void add(@RequestBody Ride ride) {
		rideService.add(ride);
	}
	
	@GetMapping("/exist/{id}")
	public boolean exist(@PathVariable("id") Long idRide) {
		return rideService.exist(idRide);
	} 
	
//	@PostMapping
//	public void edit(ride ride) {
//		rideService.edit(ride);
//	}
//	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long idRide) {
		rideService.delete(idRide);
		
	}
	
	@GetMapping("/rides")
	public Iterable<Ride> rides(){
		return rideService.rides();
	}
	
	
	@GetMapping("/show/{id}")
	public Ride get(@PathVariable("id")Long id) {
		
		return rideService.get(id);
	}
	
	
	
	

}
