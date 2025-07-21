package com.transport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transport.dto.ResponseStructure;
import com.transport.entity.Driver;
import com.transport.service.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private DriverService ser;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Driver>> createDriver(@RequestBody Driver driver){
		return ser.createDriver(driver);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Driver>>> getAllDrivers(){
		return ser.getAllDrivers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Driver>> getDriverById(@PathVariable Long id){
		return ser.getDriverById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Driver>> updateDriver(@RequestBody Driver driver){
		return ser.updateDriver(driver);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteDriver(@PathVariable Long id){
		return ser.deleteDriver(id);
	}
	
	@GetMapping("/available")
	public ResponseEntity<ResponseStructure<List<Driver>>> getAvailableDrivers(){
		return ser.getAvailableDrivers();
	}

}
