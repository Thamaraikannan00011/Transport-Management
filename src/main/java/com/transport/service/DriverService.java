package com.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.transport.dao.DriverDAO;
import com.transport.dto.ResponseStructure;
import com.transport.entity.Driver;
import com.transport.exception.IdNotFoundException;
import com.transport.exception.NoRecordFoundException;

@Service
public class DriverService {
	
	@Autowired
	private DriverDAO dao;
	
	public ResponseEntity<ResponseStructure<Driver>> createDriver(Driver driver){
		ResponseStructure<Driver> res = new ResponseStructure<Driver>();
		Driver d = dao.createDriver(driver);
		res.setStatus(HttpStatus.CREATED.value());
		res.setMessage("Driver created successfully");
		res.setData(d);
		return new ResponseEntity<ResponseStructure<Driver>>(res, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Driver>>> getAllDrivers(){
		ResponseStructure<List<Driver>> res = new ResponseStructure<List<Driver>>();
		List<Driver> li = dao.getAllDrivers();
		if(!li.isEmpty()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Fetched all drivers");
			res.setData(li);
			return new ResponseEntity<ResponseStructure<List<Driver>>>(res, HttpStatus.OK);
		}
		else {
			throw new NoRecordFoundException("No record found in Database");
		}
	}
	
	public ResponseEntity<ResponseStructure<Driver>> getDriverById(Long id){
		ResponseStructure<Driver> res = new ResponseStructure<Driver>();
		Optional<Driver> opt = dao.getDriverById(id);
		if(opt.isPresent()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Driver fetched");
			res.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Driver>>(res, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("No driver found with given id");
		}
	}
	
	public ResponseEntity<ResponseStructure<Driver>> updateDriver(Driver driver){
		Driver d = dao.updateDriver(driver);
		ResponseStructure<Driver> res = new ResponseStructure<Driver>();
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("Driver updated");
		res.setData(d);
		return new ResponseEntity<ResponseStructure<Driver>>(res, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteDriver(Long id){
		ResponseStructure<String> res = new ResponseStructure<String>();
		Optional<Driver> opt = dao.getDriverById(id);
		if(opt.isPresent()) {
			dao.deleteDriver(id);
			res.setStatus(HttpStatus.ACCEPTED.value());
			res.setMessage("Driver removed");
			res.setData("Deleted successfully");
			return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFoundException("No driver found with Id to delete");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Driver>>> getAvailableDrivers(){
		List<Driver> li = dao.getAvailableDrivers();
		ResponseStructure<List<Driver>> res = new ResponseStructure<List<Driver>>();
		if(!li.isEmpty()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Found available driver");
			res.setData(li);
			return new ResponseEntity<ResponseStructure<List<Driver>>>(res, HttpStatus.OK);
		}
		else {
			throw new NoRecordFoundException("No driver are available");
		}
	}

}
