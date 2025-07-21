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
import com.transport.entity.Passenger;
import com.transport.service.PassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
	
	@Autowired
	private PassengerService ser;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Passenger>> createPassenger(@RequestBody Passenger passenger) {
		return ser.createPassenger(passenger);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Passenger>>> getAllPassengers(){
		return ser.getAllPassengers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Passenger>> getPassengerById(@PathVariable Long id) {
		return ser.getPassengerById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Passenger>> updatePassenger(@RequestBody Passenger passenger) {
		return ser.updatePassenger(passenger);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deletePassenger(@PathVariable Long id) {
		return ser.deletePassenger(id);
	}

}
