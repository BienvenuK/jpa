package poe.blablacar.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.blablacar.dao.VehicleDao;
import poe.blablacar.domain.Vehicle;

@Service
public class VehicleService {
	
	@Autowired
	VehicleDao vehicleDao;
	
	
	public void add(Vehicle vehicle) {
		vehicleDao.save(vehicle);
	}
	
	public Vehicle get(Long idVehicle) {
		return  vehicleDao.findOne(idVehicle);
	}
	
//	public void edit(Account account) {
//		accountDao.save(account);
//	}
	
	public void delete(Long idVehicle) {
		vehicleDao.delete(idVehicle);
	}
	
	public Iterable<Vehicle> vehicles(){
		
		return  vehicleDao.findAll();
		
	}
	
	public boolean exist(Long idVehicle) {
		return vehicleDao.exists(idVehicle);
	}
	

}
