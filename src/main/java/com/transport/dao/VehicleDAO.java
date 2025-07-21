package com.transport.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transport.entity.Vehicle;
import com.transport.repository.VehicleRepository;

@Repository
public class VehicleDAO {
	
	@Autowired
	private VehicleRepository rep;
	
	// create vehicle
	public Vehicle createVehicle(Vehicle vehicle) {
		return rep.save(vehicle);
	}
	
	// fetch all vehicle
	public List<Vehicle> getAllVehicles(){
		return rep.findAll();
	}
	
	// fetch vehicle by Id
	public Optional<Vehicle> getVehicleById(Long id) {
		return rep.findById(id);
	}
	
	// update vehicle by Id
	public Vehicle updateVehicle(Vehicle vehicle) {
		return rep.save(vehicle);
	}
	
	// delete by id
	public void deleteVehicle(Long id) {
		rep.deleteById(id);
	}
}
