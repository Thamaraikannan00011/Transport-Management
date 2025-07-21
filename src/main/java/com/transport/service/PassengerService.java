package com.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.transport.dao.PassengerDAO;
import com.transport.dto.ResponseStructure;
import com.transport.entity.Passenger;
import com.transport.exception.IdNotFoundException;
import com.transport.exception.NoRecordFoundException;

public class PassengerService {
	
	@Autowired
	private PassengerDAO dao;
	
	public ResponseEntity<ResponseStructure<Passenger>> createPassenger(Passenger passenger) {
		ResponseStructure<Passenger> res = new ResponseStructure<Passenger>();
		Passenger p = dao.createPassenger(passenger);
		res.setStatus(HttpStatus.CREATED.value());
		res.setMessage("Register new passenger");
		res.setData(p);
		return new ResponseEntity<ResponseStructure<Passenger>>(res, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Passenger>>> getAllPassengers(){
		ResponseStructure<List<Passenger>> res = new ResponseStructure<List<Passenger>>();
		List<Passenger> li = dao.getAllPassengers();
		if(!li.isEmpty()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Retrieve all passengers");
			res.setData(li);
			return new ResponseEntity<ResponseStructure<List<Passenger>>>(res, HttpStatus.OK);
		}
		else {
			throw new NoRecordFoundException("No record found in passanger DB");
		}
	}
	
	public ResponseEntity<ResponseStructure<Passenger>> getPassengerById(Long id) {
		ResponseStructure<Passenger> res = new ResponseStructure<Passenger>();
		Optional<Passenger> opt = dao.getPassengerById(id);
		if(opt.isPresent()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Get specific passenger by ID");
			res.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Passenger>>(res, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("No record found with given id");
		}
	}
	
	public ResponseEntity<ResponseStructure<Passenger>> updatePassenger(Passenger passenger) {
		ResponseStructure<Passenger> res = new ResponseStructure<Passenger>();
		Passenger p = dao.updatePassenger(passenger);
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("Updated passenger information");
		res.setData(p);
		return new ResponseEntity<ResponseStructure<Passenger>>(res, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deletePassenger(Long id) {
		ResponseStructure<String> res = new ResponseStructure<String>();
		Optional<Passenger> opt = dao.getPassengerById(id);
		if(opt.isPresent()) {
			dao.deletePassenger(id);
			res.setStatus(HttpStatus.NO_CONTENT.value());
			res.setMessage("Remove passenger from database");
			res.setData(null);
			return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NO_CONTENT);
		}
		else {
			throw new IdNotFoundException("Id not matching to remove passager");
		}
	}
}
