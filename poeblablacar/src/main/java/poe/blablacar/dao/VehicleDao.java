package poe.blablacar.dao;

import org.springframework.data.repository.CrudRepository;

import poe.blablacar.domain.Vehicle;

public interface VehicleDao extends CrudRepository<Vehicle, Long>{

}
