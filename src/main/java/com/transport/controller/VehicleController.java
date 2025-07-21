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
import com.transport.entity.Vehicle;
import com.transport.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService ser;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Vehicle>> createVehicle(@RequestBody Vehicle vehicle){
		return ser.createVehicle(vehicle);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Vehicle>>> getAllVehicles(){
		return ser.getAllVehicles();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Vehicle>> getVehicleById(@PathVariable Long id){
		return ser.getVehicleById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Vehicle>> updateVehicle(@RequestBody Vehicle vehicle){
		return ser.updateVehicle(vehicle);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteVehicle(@PathVariable Long id){
		return ser.deleteVehicle(id);
	}

}
