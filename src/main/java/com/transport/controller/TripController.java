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
import com.transport.entity.Trip;
import com.transport.service.TripService;

@RestController
@RequestMapping("/trip")
public class TripController {
	
	@Autowired
	private TripService ser;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Trip>> createTrip(@RequestBody Trip trip) {
		return ser.createTrip(trip);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Trip>>> getAllTrips(){
		return ser.getAllTrips();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Trip>> getTripById(@PathVariable Long id) {
		return ser.getTripById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Trip>> updateTrip(@RequestBody Trip trip) {
		return ser.updateTrip(trip);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> cancelTrip(Long id) {
		return ser.cancelTrip(id);
	}
}
