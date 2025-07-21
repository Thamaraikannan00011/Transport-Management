package com.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.transport.dao.VehicleDAO;
import com.transport.dto.ResponseStructure;
import com.transport.entity.Vehicle;
import com.transport.exception.IdNotFoundException;
import com.transport.exception.NoRecordFoundException;

@Service
public class VehicleService {
	@Autowired
	private VehicleDAO dao;
	
	// create vehicle
	public ResponseEntity<ResponseStructure<Vehicle>> createVehicle(Vehicle vehicle){
		Vehicle v = dao.createVehicle(vehicle);
		ResponseStructure<Vehicle> res = new ResponseStructure<Vehicle>();
		res.setStatus(HttpStatus.ACCEPTED.value());
		res.setMessage("Record created");
		res.setData(v);
		return new ResponseEntity<ResponseStructure<Vehicle>>(res, HttpStatus.ACCEPTED);
	}
	
	// get all vehicles 
	public ResponseEntity<ResponseStructure<List<Vehicle>>> getAllVehicles(){
		List<Vehicle> li = dao.getAllVehicles();
		ResponseStructure<List<Vehicle>> res = new ResponseStructure<List<Vehicle>>();
		if(!li.isEmpty()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Fetched all the vehicle records");
			res.setData(li);
			return new ResponseEntity<ResponseStructure<List<Vehicle>>>(res, HttpStatus.OK);
		}
		else {
			throw new NoRecordFoundException("No vehicle found in Database");
		}
	}
	
	// get vehicle By Id
	public ResponseEntity<ResponseStructure<Vehicle>> getVehicleById(Long id){
		Optional<Vehicle> opt = dao.getVehicleById(id);
		ResponseStructure<Vehicle> res = new ResponseStructure<Vehicle>();
		if(opt.isPresent()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Vehicle found by id");
			res.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Vehicle>>(res, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Given id Does not found in Database");
		}
	}
	
	// update vehicle 
	public ResponseEntity<ResponseStructure<Vehicle>> updateVehicle(Vehicle vehicle){
		ResponseStructure<Vehicle> res = new ResponseStructure<Vehicle>();
		Optional<Vehicle> opt = dao.getVehicleById(vehicle.getVehicleId());
		if(opt.isPresent()) {
			Vehicle v = dao.updateVehicle(vehicle);
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Vehicle updated");
			res.setData(v);
			return new ResponseEntity<ResponseStructure<Vehicle>>(res, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("to update id doesn't matching");
		}
	}
	
	// delete vehicle
	public ResponseEntity<ResponseStructure<String>> deleteVehicle(Long id){
		ResponseStructure<String> res = new ResponseStructure<String>();
		Optional<Vehicle> opt = dao.getVehicleById(id);
		if(opt.isPresent()) {
			dao.deleteVehicle(id);
			res.setStatus(HttpStatus.NO_CONTENT.value());
			res.setMessage("Record deleted");
			return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NO_CONTENT);
		}
		else {
			throw new IdNotFoundException("to delete id doesn't match");
		}
	}
	
}
