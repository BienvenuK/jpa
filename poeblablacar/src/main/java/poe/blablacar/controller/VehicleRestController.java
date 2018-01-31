package poe.blablacar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poe.blablacar.Service.VehicleService;
import poe.blablacar.domain.Vehicle;


@RestController
@RequestMapping("/vehicle")
public class VehicleRestController {
	@Autowired
	VehicleService vehicleService;
	
	
	
	@PostMapping
	public void add(@RequestBody Vehicle vehicle) {
		vehicleService.add(vehicle);
	}
	
	@GetMapping("/exist/{id}")
	public boolean exist(@PathVariable("id") Long idVehicle) {
		return vehicleService.exist(idVehicle);
	} 
	
//	@PostMapping
//	public void edit(ride ride) {
//		rideService.edit(ride);
//	}
//	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long idVehicle) {
		vehicleService.delete(idVehicle);
		
	}
	
	@GetMapping("/vehicles")
	public Iterable<Vehicle> rides(){
		return vehicleService.vehicles();
	}
	
	
	@GetMapping("/show/{id}")
	public Vehicle get(@PathVariable("id")Long id) {
		
		return vehicleService.get(id);
	}

}
